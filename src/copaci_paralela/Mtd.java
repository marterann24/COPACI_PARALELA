package copaci_paralela;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

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

    public static int extraerAnio(String fechaString) {
        if (fechaString == null || fechaString.trim().length() != 10) {
            return -1;
        }
        
        var matcher = FORMATO_FECHA.matcher(fechaString.trim());
        if (!matcher.matches()) {
            return -1;
        }
        
        // Extraer año como String y convertir a int (grupo 3 = yyyy)
        try {
            return Integer.parseInt(matcher.group(3));
        } catch (NumberFormatException e) {
            // En teoría no llega aquí por el regex, pero por seguridad
            return -1;
        }
    }
}
