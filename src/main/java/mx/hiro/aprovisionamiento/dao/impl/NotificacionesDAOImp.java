package mx.hiro.aprovisionamiento.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mx.hiro.aprovisionamiento.dao.NotificacionesDAO;
import mx.hiro.aprovisionamiento.dto.NotificacionesDTO;

public class NotificacionesDAOImp implements NotificacionesDAO {
    private static final String SQL_INSERT = "INSERT INTO notificaciones (idOperacion, nombreArchivo, fechaAlta, usr, tipoOperacion, idCifras, idIncidencias, fechaCreacion, estatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE notificaciones SET estatus = ? WHERE idNotificacion = ?";


    @Override
    public int crearNotificacion(Connection connection, NotificacionesDTO notificacionesDTO) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
            stmt.setLong(1, notificacionesDTO.getIdOperacion());
            stmt.setString(2, notificacionesDTO.getNombreArchivo());
            stmt.setDate(3, new java.sql.Date(notificacionesDTO.getFechaAlta().getTime()));
            stmt.setString(4, notificacionesDTO.getUsr());
            stmt.setString(5, notificacionesDTO.getTipoOperacion());
            stmt.setLong(6, notificacionesDTO.getIdCifra());
            stmt.setLong(7, notificacionesDTO.getIdIncidencia());
            stmt.setDate(8, new java.sql.Date(notificacionesDTO.getFechaCreacion().getTime()));
            stmt.setString(9, notificacionesDTO.getEstatus());
            return stmt.executeUpdate();
        }
    }

    @Override
    public void actualizarNotificacion(String mensaje) {
        System.out.println("Notificacion actualizada: " + mensaje);
    }
}
