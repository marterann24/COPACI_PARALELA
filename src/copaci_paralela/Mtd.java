package copaci_paralela;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Mtd
{

    private static final Pattern FORMATO_FECHA = Pattern.compile("^(\\d{2})/(\\d{2})/(\\d{4})$");

    public static long calcularMesesDesdeMayoriaEdad(String fechaNacimientoString)
    {
        if (fechaNacimientoString == null || fechaNacimientoString.trim().length() != 10)
        {
            return -1;
        }

        var matcher = FORMATO_FECHA.matcher(fechaNacimientoString.trim());
        if (!matcher.matches())
        {
            return -1;
        }

        int dia = Integer.parseInt(matcher.group(1));
        int mes = Integer.parseInt(matcher.group(2));
        int anio = Integer.parseInt(matcher.group(3));

        // Validar mes (1-12)
        if (mes < 1 || mes > 12)
        {
            return -1;
        }

        // Validar año (ej. 1900-2007 para que tenga al menos 18 en 2025, ajusta si necesitas)
        if (anio < 1900 || anio > 2007)
        {  // Asumiendo hoy ~2025
            return -1;
        }

        // Días máximos por mes
        int[] diasMaximos =
        {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        // Ajustar febrero para bisiesto
        if (mes == 2 && esBisiesto(anio))
        {
            diasMaximos[1] = 29;
        }

        // Validar día
        if (dia < 1 || dia > diasMaximos[mes - 1])
        {
            return -1;
        }

        // Crear fecha de nacimiento
        LocalDate nacimiento = LocalDate.of(anio, mes, dia);

        // Calcular fecha en que cumplió 18 años
        LocalDate cumple18 = nacimiento.plusYears(18);

        // Fecha actual (usa LocalDate.now() en producción; aquí fixed para demo)
        LocalDate hoy = LocalDate.now();  // O LocalDate.of(2025, 11, 18) para reproducibilidad

        // Si cumple18 es futura, retorna -1 o maneja como necesites
        if (cumple18.isAfter(hoy))
        {
            return -1;
        }

        // Calcular meses totales desde los 18 años
        return ChronoUnit.MONTHS.between(cumple18, hoy);
    }

    // Método auxiliar para año bisiesto
    private static boolean esBisiesto(int anio)
    {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    public static int extraerAnio(String fechaString)
    {
        if (fechaString == null || fechaString.trim().length() != 10)
        {
            return -1;
        }

        var matcher = FORMATO_FECHA.matcher(fechaString.trim());
        if (!matcher.matches())
        {
            return -1;
        }

        // Extraer año como String y convertir a int (grupo 3 = yyyy)
        try
        {
            return Integer.parseInt(matcher.group(3));
        } catch (NumberFormatException e)
        {
            // En teoría no llega aquí por el regex, pero por seguridad
            return -1;
        }
    }

    public static boolean esFechaNacimientoValida(String fechaNacimiento)
    {
        // Verificar formato con try-catch
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac;
        try
        {
            fechaNac = LocalDate.parse(fechaNacimiento, formatter);
        } catch (DateTimeParseException e)
        {
            return false; // Formato inválido
        }

        LocalDate fechaActual = LocalDate.now();

        // Si la fecha es futura
        if (fechaNac.isAfter(fechaActual))
        {
            return false;
        }

        // Calcular edad
        int edad = Period.between(fechaNac, fechaActual).getYears();
        if (edad < 18)
        {
            return false;
        }

        return true;
    }
    
    /**
     * Genera una JTable con pagos mensuales desde que la persona cumple 18 años hasta la fecha actual.
     * 
     * @param fechaNacimientoStr String en formato 'dd/MM/yyyy' (ej: "15/06/2000")
     * @param pago double: monto total pagado. Cada 100 unidades cubre un mes (ej: 1500.0 cubre 15 meses)
     * 
     * Retorna:
     * JTable con columnas: Mes, Año, Pagado (X si está pagado, vacío si no).
     * La fecha actual se fija en 2025-11-26.
     */
    public static JTable generarTabla(String fechaNacimientoStr, double pago) {
        // Parsear la fecha de nacimiento
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
        
        // Calcular fecha de inicio: cuando cumple 18 años
        LocalDate fechaInicio = fechaNacimiento.plusYears(18);
        // Empezar desde el primer día del mes de cumpleaños de 18
        LocalDate mesInicio = fechaInicio.withDayOfMonth(1);
        
        // Fecha actual fija (en código real, usa LocalDate.now())
        LocalDate fechaActual = LocalDate.of(2025, 11, 26);
        LocalDate mesActual = fechaActual.withDayOfMonth(1);
        
        // Número de meses pagados: floor(pago / 100)
        int mesesPagados = (int) (pago / 100);
        
        // Crear modelo de tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mes");
        model.addColumn("Año");
        model.addColumn("Pagado");
        
        // Generar filas mes a mes
        LocalDate mesActualTabla = mesInicio;
        int contadorMeses = 0;
        
        while (!mesActualTabla.isAfter(mesActual)) {
            int mes = mesActualTabla.getMonthValue();
            int año = mesActualTabla.getYear();
            String pagado = (contadorMeses < mesesPagados) ? "X" : "";
            
            // Añadir fila al modelo
            model.addRow(new Object[]{mes, año, pagado});
            
            // Siguiente mes
            mesActualTabla = mesActualTabla.plusMonths(1);
            contadorMeses++;
        }
        
        // Crear JTable con el modelo
        JTable tabla = new JTable(model);
        tabla.setEnabled(false); // Opcional: deshabilitar edición
        
        System.out.println("Tabla generada con " + contadorMeses + " filas.");
        System.out.println("Meses con X: " + Math.min(mesesPagados, contadorMeses));
        
        return tabla;
    }
    
    public static String[] nombresMeses =
    {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    /**
     * Calcula el número de meses transcurridos desde una fecha dada hasta la
     * fecha actual.
     *
     * @param fechaStr Cadena en formato dd/MM/yyyy (ej. "15/03/2020")
     * @return Número de meses (0 si la fecha es futura o inválida)
     */
    public static int mesesTranscurridos(String fechaStr)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now(); // Fecha simulada; en producción: LocalDate.now()

        try
        {
            LocalDate fechaInicio = LocalDate.parse(fechaStr, formatter);

            if (fechaInicio.isAfter(fechaActual))
            {
                return 0; // Si es futura, no hay meses pasados
            }

            long meses = ChronoUnit.MONTHS.between(fechaInicio, fechaActual);
            return (int) meses;

        } catch (DateTimeParseException e)
        {
            System.err.println("Formato de fecha inválido: " + e.getMessage());
            return 0;
        }
    }

    /**
     * Calcula la fecha en que se cumple la mayoría de edad (18 años) a partir
     * de la fecha de nacimiento.
     *
     * @param fechaNacimiento Cadena en formato dd/MM/yyyy (ej. "15/03/2007")
     * @return Fecha de mayoría de edad en formato dd/MM/yyyy
     * @throws DateTimeParseException si el formato de fecha es inválido
     */
    public static String fechaMayoriaEdad(String fechaNacimiento)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try
        {
            LocalDate nacimiento = LocalDate.parse(fechaNacimiento, formatter);
            LocalDate mayoria = nacimiento.plusYears(18);
            return mayoria.format(formatter);

        } catch (DateTimeParseException e)
        {
            throw new DateTimeParseException("Formato de fecha inválido: se espera dd/MM/yyyy", fechaNacimiento, e.getErrorIndex());
        }
    }

    /**
     * Genera array de meses transcurridos (solo meses).
     */
    public static String[] generarMesesTranscurridos(String fechaMayoriaStr)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now();  // Fecha simulada
        try
        {
            LocalDate fechaMayoria = LocalDate.parse(fechaMayoriaStr, formatter);
            if (fechaMayoria.isAfter(fechaActual))
            {
                return new String[0];  // Vacío si futura
            }
            ArrayList<String> mesesList = new ArrayList<String>();
            YearMonth inicio = YearMonth.from(fechaMayoria);
            YearMonth actualYM = YearMonth.from(fechaActual);
            for (YearMonth ym = inicio; !ym.isAfter(actualYM); ym = ym.plusMonths(1))
            {
                int mesIndex = ym.getMonthValue() - 1;
                String mesStr = nombresMeses[mesIndex] + " " + ym.getYear();
                mesesList.add(mesStr);
            }
            return mesesList.toArray(new String[mesesList.size()]);
        } catch (DateTimeParseException e)
        {
            throw new DateTimeParseException("Formato de fecha inválido: se espera dd/MM/yyyy", fechaMayoriaStr, e.getErrorIndex());
        }
    }

    /**
     * Genera array de años únicos transcurridos (solo años).
     */
    public static String[] generarAñosTranscurridos(String fechaMayoriaStr)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now();  // Fecha simulada

        try
        {
            LocalDate fechaMayoria = LocalDate.parse(fechaMayoriaStr, formatter);

            if (fechaMayoria.isAfter(fechaActual))
            {
                return new String[0];  // Vacío si futura
            }

            // Usar HashSet explícitamente (NO Set)
            HashSet<Integer> añosSet = new HashSet<Integer>();

            YearMonth inicio = YearMonth.from(fechaMayoria);
            YearMonth actualYM = YearMonth.from(fechaActual);

            for (YearMonth ym = inicio; !ym.isAfter(actualYM); ym = ym.plusMonths(1))
            {
                añosSet.add(ym.getYear());
            }

            // Convertir a array ordenado
            Integer[] añosArray = añosSet.toArray(new Integer[añosSet.size()]);
            Arrays.sort(añosArray);
            String[] años = new String[añosArray.length];
            for (int i = 0; i < añosArray.length; i++)
            {
                años[i] = String.valueOf(añosArray[i]);
            }

            return años;

        } catch (DateTimeParseException e)
        {
            throw new DateTimeParseException("Formato de fecha inválido: se espera dd/MM/yyyy", fechaMayoriaStr, e.getErrorIndex());
        }
    }
}
