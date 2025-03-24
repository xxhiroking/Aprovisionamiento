package mx.hiro.aprovisionamiento.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import mx.hiro.aprovisionamiento.dao.NotificacionesDAO;
import mx.hiro.aprovisionamiento.dto.NotificacionesDTO;
import mx.hiro.aprovisionamiento.util.Constantes;

public class NotificacionesDAOImp implements NotificacionesDAO {
    private static final Logger LOGGER = Logger.getLogger(NotificacionesDAOImp.class.getName());
    private static final String SQL_INSERT = "INSERT INTO notificaciones (idOperacion, nombreArchivo, fechaAlta, usr, tipoOperacion, idCifras, idIncidencias, fechaCreacion, estatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE notificaciones SET estatus = ? WHERE idOperacion = ?";
    private static final String SQL_UPDATE_EXITOSO = "UPDATE notificaciones SET estatus = ? WHERE idOperacion = ?";

    @Override
    public int crearNotificacion(Connection connection, NotificacionesDTO notificacionesDTO) throws SQLException {
        int generatedIdOperacion = -1;

        try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, notificacionesDTO.getIdOperacion());
            stmt.setString(2, notificacionesDTO.getNombreArchivo());
            stmt.setDate(3, new java.sql.Date(notificacionesDTO.getFechaAlta().getTime()));
            stmt.setString(4, notificacionesDTO.getUsr());
            stmt.setString(5, notificacionesDTO.getTipoOperacion());
            stmt.setLong(6, notificacionesDTO.getIdCifra());
            stmt.setLong(7, notificacionesDTO.getIdIncidencia());
            stmt.setDate(8, new java.sql.Date(notificacionesDTO.getFechaCreacion().getTime()));
            stmt.setString(9, notificacionesDTO.getEstatus());

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedIdOperacion = generatedKeys.getInt(1);
                        LOGGER.info("Generated idOperacion: " + generatedIdOperacion);

                        // Update status to EXITOSO
                        try (PreparedStatement updateStmt = connection.prepareStatement(SQL_UPDATE_EXITOSO)) {
                            updateStmt.setString(1, Constantes.ESTATUS_EXITOSO);
                            updateStmt.setInt(2, generatedIdOperacion);
                            int rowsUpdated = updateStmt.executeUpdate();
                            LOGGER.info("Updated status to EXITOSO for idOperacion: " + generatedIdOperacion + ", Rows affected: " + rowsUpdated);
                        }
                    }
                }
            }
        }

        return generatedIdOperacion;
    }

    @Override
    public int actualizarNotiFallida(Connection connection, int idOperacion) throws SQLException {
        int rowsAffected = 0;

        // Log the input parameters
        LOGGER.info("Updating notification to failed. idOperacion: " + idOperacion + ", estatus: " + Constantes.ESTATUS_FALLADO);

        // Validate the constant value
        if (Constantes.ESTATUS_FALLADO == null || Constantes.ESTATUS_FALLADO.isEmpty()) {
            LOGGER.severe("Constantes.ESTATUS_FALLADO is null or empty.");
            return rowsAffected;
        }

        // Validate idOperacion
        if (idOperacion <= 0) {
            LOGGER.severe("Invalid idOperacion: " + idOperacion);
            return rowsAffected;
        }

        // Check if the record exists
        String sqlCheck = "SELECT estatus FROM notificaciones WHERE idOperacion = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(sqlCheck)) {
            checkStmt.setInt(1, idOperacion);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    String currentStatus = rs.getString("estatus");
                    LOGGER.info("Current status for idOperacion " + idOperacion + ": " + currentStatus);
                } else {
                    LOGGER.warning("No record found for idOperacion: " + idOperacion);
                    return rowsAffected;
                }
            }
        }

        // Perform the update
        try (PreparedStatement ps = connection.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, Constantes.ESTATUS_FALLADO);
            ps.setInt(2, idOperacion);

            // Log the SQL query
            LOGGER.info("Executing query: " + SQL_UPDATE);

            rowsAffected = ps.executeUpdate();

            // Log the result
            LOGGER.info("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            LOGGER.severe("Error updating notification: " + e.getMessage());
            throw e;
        }

        return rowsAffected;
    }
}
