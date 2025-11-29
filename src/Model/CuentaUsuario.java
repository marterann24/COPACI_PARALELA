package Model;

import java.math.BigDecimal;

public class CuentaUsuario {

    private int id;
    private int usuarioId;  // si quieres, luego lo cambias a Usuario usuario;
    private String tipo;    // 'FAENA' o 'COOPERACION'
    private BigDecimal totalPago;
    private BigDecimal totalDeuda;

    public CuentaUsuario() {
    }

    public CuentaUsuario(int id, int usuarioId, String tipo,
                         BigDecimal totalPago, BigDecimal totalDeuda) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.totalPago = totalPago;
        this.totalDeuda = totalDeuda;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
    }

    public BigDecimal getTotalDeuda() {
        return totalDeuda;
    }

    public void setTotalDeuda(BigDecimal totalDeuda) {
        this.totalDeuda = totalDeuda;
    }

    @Override
    public String toString() {
        return "CuentaUsuario{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", tipo='" + tipo + '\'' +
                ", totalPago=" + totalPago +
                ", totalDeuda=" + totalDeuda +
                '}';
    }
}

