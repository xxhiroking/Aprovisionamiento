package mx.hiro.aprovisionamiento.dto;

import java.util.Date;

public class NotificacionesDTO {
    private int idOperacion;
    private String nombreArchivo;
    private Date fechaAlta;
    private String usr;
    private String tipoOperacion;
    private int idCifra;
    private int idIncidencia;
    private Date fechaCreacion;
    private String estatus;
    private String version;

    public NotificacionesDTO(int idOperacion, String nombreArchivo, Date fechaAlta, String usr, String tipoOperacion, int idCifra, int idIncidencia, Date fechaCreacion, String estatus, String version) {
        this.idOperacion = idOperacion;
        this.nombreArchivo = nombreArchivo;
        this.fechaAlta = fechaAlta;
        this.usr = usr;
        this.tipoOperacion = tipoOperacion;
        this.idCifra = idCifra;
        this.idIncidencia = idIncidencia;
        this.fechaCreacion = fechaCreacion;
        this.estatus = estatus;
        this.version = version;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getIdCifra() {
        return idCifra;
    }

    public void setIdCifra(int idCifra) {
        this.idCifra = idCifra;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
