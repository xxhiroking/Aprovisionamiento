package mx.hiro.aprovisionamiento.dao;

import mx.hiro.aprovisionamiento.dto.NotificacionesDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface NotificacionesDAO {
    public int crearNotificacion(Connection connection, NotificacionesDTO notificacionesDTO) throws SQLException;
    public void actualizarNotificacion(String mensaje);
}
