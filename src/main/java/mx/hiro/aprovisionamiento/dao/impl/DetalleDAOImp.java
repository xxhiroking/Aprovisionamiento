package mx.hiro.aprovisionamiento.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mx.hiro.aprovisionamiento.dao.DetalleDAO;
import mx.hiro.aprovisionamiento.dto.DetalleDTO;

public class DetalleDAOImp implements DetalleDAO {
    @Override
    public int actualizarDetalle(DetalleDTO detalleDTO) {
        return 0;
    }

    @Override
    public void guardarDetalle(Connection connection, DetalleDTO detalleDTO) throws SQLException {
        String sql = "INSERT INTO detalle (idDetalle, idOperacion, idCifras, cliente, cuenta, folio, rfcR, rfcE, tipoParticipacion, ejercicioFiscal, estatus, idConstancia, version,  fechaCreacion, fechaCancelacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, detalleDTO.getIdDetalle());
            ps.setLong(2, detalleDTO.getIdOperacion());
            ps.setLong(3, detalleDTO.getIdCifras());
            ps.setString(4, detalleDTO.getCliente());
            ps.setString(5, detalleDTO.getCuenta());
            ps.setString(6, detalleDTO.getFolio());
            ps.setString(7, detalleDTO.getRfcR());
            ps.setString(8, detalleDTO.getRfcE());
            ps.setString(9, detalleDTO.getTipoParticipacion());
            ps.setInt(10, detalleDTO.getEjercicioFiscal());
            ps.setString(11, detalleDTO.getEstatus());
            ps.setInt(12, detalleDTO.getIdConstancia());
            ps.setString(13, detalleDTO.getVersion());
            ps.setObject(14, detalleDTO.getFechaCreacion());
            ps.setObject(15, detalleDTO.getFechaCancelacion());
            ps.executeUpdate();
        }
        System.out.println("El detalle se ha guardado correctamente");
    }

}
