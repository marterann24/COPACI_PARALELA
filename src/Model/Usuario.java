package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {

    private int id;
    private String cve;
    private String nombre;
    private String manzana;
    private LocalDate fechaNacimiento;
    private String lugarNacimiento;
    private String domicilio;
    private char estadoCivil;
    private String ocupacion;
    private String telefono;
    private String maxEstudios;
    private String certificado;
    private LocalDate fechaAlta;
    private boolean esExtemporaneo;
    private boolean esOriginario;
    private LocalDateTime fechaRegistro;
    private boolean activo;

    public Usuario() {
    }

    public Usuario(int id, String cve, String nombre, String manzana,
                   LocalDate fechaNacimiento, String lugarNacimiento,
                   String domicilio, char estadoCivil, String ocupacion,
                   String telefono, String maxEstudios, String certificado,
                   LocalDate fechaAlta, boolean esExtemporaneo,
                   boolean esOriginario, LocalDateTime fechaRegistro,
                   boolean activo) {
        this.id = id;
        this.cve = cve;
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
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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

    public char getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(char estadoCivil) {
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

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
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

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", cve='" + cve + '\'' +
                ", nombre='" + nombre + '\'' +
                ", manzana='" + manzana + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", lugarNacimiento='" + lugarNacimiento + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", estadoCivil=" + estadoCivil +
                ", ocupacion='" + ocupacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", maxEstudios='" + maxEstudios + '\'' +
                ", certificado='" + certificado + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", esExtemporaneo=" + esExtemporaneo +
                ", esOriginario=" + esOriginario +
                ", fechaRegistro=" + fechaRegistro +
                ", activo=" + activo +
                '}';
    }
}
