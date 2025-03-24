package mx.hiro.aprovisionamiento.dao;
import java.sql.Connection;
import java.sql.SQLException;

import mx.hiro.aprovisionamiento.dto.DetalleDTO;

public interface DetalleDAO {
    public int actualizarDetalle(DetalleDTO detalleDTO);
    void guardarDetalle(Connection connection, DetalleDTO detalleDTO) throws SQLException;
}
