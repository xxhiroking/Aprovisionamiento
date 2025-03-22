package mx.hiro.aprovisionamiento.dto;
import java.util.Date;
public class BitacoraDTO {
    private int idBitacora;
    private int idOperacion;
    private int idIncidencia;
    private int idCifra;
    private int idDetalle;
    private String folio;
    private String cuenta;
    private String cliente;
    private Date fechaCreacion;
    private String estatus;
    private String version;

    public BitacoraDTO(int idBitacora, int idOperacion, int idIncidencia, int idCifra, int idDetalle, String folio, String cuenta, String cliente, Date fechaCreacion, String estatus, String version) {
        this.idBitacora = idBitacora;
        this.idOperacion = idOperacion;
        this.idIncidencia = idIncidencia;
        this.idCifra = idCifra;
        this.idDetalle = idDetalle;
        this.folio = folio;
        this.cuenta = cuenta;
        this.cliente = cliente;
        this.fechaCreacion = fechaCreacion;
        this.estatus = estatus;
        this.version = version;
    }

    public int getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(int idBitacora) {
        this.idBitacora = idBitacora;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public int getIdCifra() {
        return idCifra;
    }

    public void setIdCifra(int idCifra) {
        this.idCifra = idCifra;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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
