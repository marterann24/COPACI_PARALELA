/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DB.DataBaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author marit
 */
public class Usuarios {

    private Integer id;


    private String nombre;

    private String manzana;

    private Date fechaNacimiento;

    private String lugarNacimiento;

    private String domicilio;

    private String estadoCivil;

    private String ocupacion;

    private String telefono;

    private String maxEstudios;

    private String certificado;

    private Date fechaAlta;

    private boolean esExtemporaneo;

    private boolean esOriginario;

    private Double faenasPago;

    private Double cooperacionesPago;

    private Double cooperacionesDeuda;

    private Date fechaRegistro;

    private boolean activo;

    public Usuarios() {

    }

    public Usuarios(Integer id, String nombre, String manzana, Date fechaNacimiento, String lugarNacimiento, String domicilio, String estadoCivil, String ocupacion, String telefono, String maxEstudios, String certificado, Date fechaAlta, boolean esExtemporaneo, boolean esOriginario, Double faenasPago, Double cooperacionesPago, Double cooperacionesDeuda, Date fechaRegistro, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.manzana = manzana;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.domicilio = domicilio;
        this.estadoCivil = estadoCivil;
        this.ocupacion = ocupacion;
        this.telefono = telefono;
        this.maxEstudios = maxEstudios;
        this.certificado = certificado;
        this.fechaAlta = fechaAlta;
        this.esExtemporaneo = esExtemporaneo;
        this.esOriginario = esOriginario;
        this.faenasPago = faenasPago;
        this.cooperacionesPago = cooperacionesPago;
        this.cooperacionesDeuda = cooperacionesDeuda;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMaxEstudios() {
        return maxEstudios;
    }

    public void setMaxEstudios(String maxEstudios) {
        this.maxEstudios = maxEstudios;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public boolean isEsExtemporaneo() {
        return esExtemporaneo;
    }

    public void setEsExtemporaneo(boolean esExtemporaneo) {
        this.esExtemporaneo = esExtemporaneo;
    }

    public boolean isEsOriginario() {
        return esOriginario;
    }

    public void setEsOriginario(boolean esOriginario) {
        this.esOriginario = esOriginario;
    }

    public Double getFaenasPago() {
        return faenasPago;
    }

    public void setFaenasPago(Double faenasPago) {
        this.faenasPago = faenasPago;
    }

    public Double getCooperacionesPago() {
        return cooperacionesPago;
    }

    public void setCooperacionesPago(Double cooperacionesPago) {
        this.cooperacionesPago = cooperacionesPago;
    }

    public Double getCooperacionesDeuda() {
        return cooperacionesDeuda;
    }

    public void setCooperacionesDeuda(Double cooperacionesDeuda) {
        this.cooperacionesDeuda = cooperacionesDeuda;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Boolean createUser(Usuarios usuario) {
        String sql = """
        INSERT INTO socio (
            cve, nombre, manzana, fecha_nacimiento, lugar_nacimiento,
            domicilio, estado_civil, ocupacion, telefono, max_estudios,
            certificado, fecha_alta, es_extemporaneo, es_originario,
            faenas_pago, cooperaciones_pago, cooperaciones_deuda,
            fecha_registro, activo
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conexion = new DataBaseConnection().getConnection(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getCve());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getManzana());

            // Fecha de nacimiento (java.util.Date → java.sql.Date)
            pstmt.setDate(4, usuario.getFechaNacimiento() != null
                    ? new java.sql.Date(usuario.getFechaNacimiento().getTime()) : null);

            pstmt.setString(5, usuario.getLugarNacimiento());
            pstmt.setString(6, usuario.getDomicilio());
            pstmt.setString(7, usuario.getEstadoCivil());
            pstmt.setString(8, usuario.getOcupacion());
            pstmt.setString(9, usuario.getTelefono());
            pstmt.setString(10, usuario.getMaxEstudios());
            pstmt.setString(11, usuario.getCertificado());

            // Fecha alta
            pstmt.setDate(12, usuario.getFechaAlta() != null
                    ? new java.sql.Date(usuario.getFechaAlta().getTime()) : null);

            pstmt.setBoolean(13, usuario.isEsExtemporaneo());
            pstmt.setBoolean(14, usuario.isEsOriginario());

            pstmt.setDouble(15, usuario.getFaenasPago() != null ? usuario.getFaenasPago() : 0.0);
            pstmt.setDouble(16, usuario.getCooperacionesPago() != null ? usuario.getCooperacionesPago() : 0.0);
            pstmt.setDouble(17, usuario.getCooperacionesDeuda() != null ? usuario.getCooperacionesDeuda() : 0.0);

            // Fecha registro (ahora)
            pstmt.setTimestamp(18, new java.sql.Timestamp(new Date().getTime()));

            pstmt.setBoolean(19, usuario.isActivo());

            int filasInsertadas = pstmt.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error al registrar el socio: " + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

}
