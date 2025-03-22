package mx.hiro.aprovisionamiento.dao.impl;

import mx.hiro.aprovisionamiento.dao.NotificacionesDAO;
import mx.hiro.aprovisionamiento.dto.NotificacionesDTO;
import mx.hiro.aprovisionamiento.util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotificacionesDAOImp implements NotificacionesDAO {
    private static final String SQL_INSERT = "INSERT INTO notificaciones (idOperacion, nombreArchivo, fechaAlta, usr, tipoOperacion, idCifras, idDetalle, idIncidencias, fechaCreacion, estatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE notificaciones SET estatus = ? WHERE idNotificacion = ?";


    @Override
    public int crearNotificacion(Connection connection, NotificacionesDTO notificacionesDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = connection != null ? connection : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, notificacionesDTO.getIdOperacion());
            stmt.setString(2, notificacionesDTO.getNombreArchivo());
            stmt.setDate(3, new java.sql.Date(notificacionesDTO.getFechaAlta().getTime()));
            stmt.setString(4, notificacionesDTO.getUsr());
            stmt.setString(5, notificacionesDTO.getTipoOperacion());
            stmt.setInt(6, notificacionesDTO.getIdCifra());
            stmt.setInt(7, notificacionesDTO.getIdIncidencia());
            stmt.setDate(8, new java.sql.Date(notificacionesDTO.getFechaCreacion().getTime()));
            stmt.setString(9, notificacionesDTO.getEstatus());
            stmt.setString(10, notificacionesDTO.getVersion());
            rows = stmt.executeUpdate();

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return rows;



    }

    public void actualizarNotificacion(String mensaje) {
        System.out.println("Notificacion actualizada: " + mensaje);
    }
}
