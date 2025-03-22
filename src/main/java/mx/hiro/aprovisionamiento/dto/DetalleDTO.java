package mx.hiro.aprovisionamiento.dto;

import java.time.LocalDateTime;

public class DetalleDTO {
    private int idDetalle;
    private int idOperacion;
    private int idCifras;
    private String cliente;
    private String cuenta;
    private String folio;
    private String rfcR;
    private String rfcE;
    private String tipoParticipacion;
    private int ejercicioFiscal;
    private String estatus;
    private int idConstancia;
    private String version;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaCancelacion;

    public DetalleDTO() {
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public void setIdCifras(int idCifras) {
        this.idCifras = idCifras;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setRfcR(String rfcR) {
        this.rfcR = rfcR;
    }

    public void setRfcE(String rfcE) {
        this.rfcE = rfcE;
    }

    public void setTipoParticipacion(String tipoParticipacion) {
        this.tipoParticipacion = tipoParticipacion;
    }

    public void setEjercicioFiscal(int ejercicioFiscal) {
        this.ejercicioFiscal = ejercicioFiscal;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setIdConstancia(int idConstancia) {
        this.idConstancia = idConstancia;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaCancelacion(LocalDateTime fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public int getIdCifras() {
        return idCifras;
    }

    public String getCliente() {
        return cliente;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getFolio() {
        return folio;
    }

    public String getRfcR() {
        return rfcR;
    }

    public String getRfcE() {
        return rfcE;
    }

    public String getTipoParticipacion() {
        return tipoParticipacion;
    }

    public int getEjercicioFiscal() {
        return ejercicioFiscal;
    }

    public String getEstatus() {
        return estatus;
    }

    public int getIdConstancia() {
        return idConstancia;
    }

    public String getVersion() {
        return version;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaCancelacion() {
        return fechaCancelacion;
    }
}
