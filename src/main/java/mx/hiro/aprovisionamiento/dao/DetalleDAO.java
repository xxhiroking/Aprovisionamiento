package mx.hiro.aprovisionamiento.dao;
import mx.hiro.aprovisionamiento.dao.impl.DetalleDAOImp;
import mx.hiro.aprovisionamiento.dto.DetalleDTO;

public interface DetalleDAO {
    public int insertarDetalle(DetalleDTO detalleDTO);
    public int actualizarDetalle(DetalleDTO detalleDTO);
}
