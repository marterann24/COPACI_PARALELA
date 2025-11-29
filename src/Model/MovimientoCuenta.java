package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MovimientoCuenta {

    private int id;
    private int cuentaId;          // o CuentaUsuario cuenta;
    private LocalDate fecha;
    private char tipoMovimiento;   // 'C' = cargo, 'A' = abono
    private BigDecimal monto;
    private String descripcion;

    public MovimientoCuenta() {
    }

    public MovimientoCuenta(int id, int cuentaId, LocalDate fecha,
                            char tipoMovimiento, BigDecimal monto,
                            String descripcion) {
        this.id = id;
        this.cuentaId = cuentaId;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public char getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(char tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MovimientoCuenta{" +
                "id=" + id +
                ", cuentaId=" + cuentaId +
                ", fecha=" + fecha +
                ", tipoMovimiento=" + tipoMovimiento +
                ", monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

