package mx.hiro.aprovisionamiento.dto;

import java.time.LocalDateTime;

public class DetalleDTO {
    private Long idDetalle;
    private Long idOperacion;
    private Long idCifras;
    private String cliente;
    private String cuenta;
    private String folio;
    private String rfcR;
    private String rfcE;
    private String tipoParticipacion;
    private Integer ejercicioFiscal;
    private String estatus;
    private Integer idConstancia;
    private String version;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaCancelacion;

    // Getters and Setters
    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Long getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Long idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Long getIdCifras() {
        return idCifras;
    }

    public void setIdCifras(Long idCifras) {
        this.idCifras = idCifras;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getRfcR() {
        return rfcR;
    }

    public void setRfcR(String rfcR) {
        this.rfcR = rfcR;
    }

    public String getRfcE() {
        return rfcE;
    }

    public void setRfcE(String rfcE) {
        this.rfcE = rfcE;
    }

    public String getTipoParticipacion() {
        return tipoParticipacion;
    }

    public void setTipoParticipacion(String tipoParticipacion) {
        this.tipoParticipacion = tipoParticipacion;
    }

    public Integer getEjercicioFiscal() {
        return ejercicioFiscal;
    }

    public void setEjercicioFiscal(Integer ejercicioFiscal) {
        this.ejercicioFiscal = ejercicioFiscal;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Integer getIdConstancia() {
        return idConstancia;
    }

    public void setIdConstancia(Integer idConstancia) {
        this.idConstancia = idConstancia;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(LocalDateTime fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    @Override
    public String toString() {
        return "DetalleDTO{" +
                "idDetalle=" + idDetalle +
                ", idOperacion=" + idOperacion +
                ", idCifras=" + idCifras +
                ", cliente='" + cliente + '\'' +
                ", cuenta='" + cuenta + '\'' +
                ", folio='" + folio + '\'' +
                ", rfcR='" + rfcR + '\'' +
                ", rfcE='" + rfcE + '\'' +
                ", tipoParticipacion='" + tipoParticipacion + '\'' +
                ", ejercicioFiscal=" + ejercicioFiscal +
                ", estatus='" + estatus + '\'' +
                ", idConstancia=" + idConstancia +
                ", version='" + version + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaCancelacion=" + fechaCancelacion +
                '}';
    }
}
