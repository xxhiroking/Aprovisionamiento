package mx.hiro.aprovisionamiento.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import mx.hiro.aprovisionamiento.dao.impl.NotificacionesDAOImp;
import mx.hiro.aprovisionamiento.dto.NotificacionesDTO;
import mx.hiro.aprovisionamiento.util.Constantes;

public class NotificacionService implements Constantes {
    private final NotificacionesDAOImp notificacionesDAO;

    public NotificacionService() {
        this.notificacionesDAO = new NotificacionesDAOImp();
    }

    //Creamos una notificacion inicial
    public void crearNotificacionInicial(Connection connection, long idOper, long idCifras, long idIncidencias, String fileName) throws SQLException {
        NotificacionesDTO notificacionesDTO = construirNotificacionInicial(connection, idOper, idCifras, idIncidencias,fileName);
        int filasAfectadas = notificacionesDAO.crearNotificacion(connection, notificacionesDTO);
        if (filasAfectadas == 1) {
            System.out.println("Notificación inicial creada correctamente");
        } else {
            System.out.println("No se pudo crear la notificación inicial");
        }
    }

    //Construimos la notificacion inicial
    private NotificacionesDTO construirNotificacionInicial(Connection connection, long idOper, long idCifras, long idIncidencias, String filaName) {
        Date fechaAlta = new Date();
        Date fechaCreacion = new Date();
        Path ruta = Paths.get(filaName);
        String nombreArchivo = ruta.getFileName().toString();

        return new NotificacionesDTO(
            (int) idOper,
            nombreArchivo,
            fechaAlta,
            Constantes.USR,
            Constantes.TIPO_OPERACION,
            (int) idCifras,
            (int) idIncidencias,
            fechaCreacion,
            Constantes.ESTATUS_INICIAL,
            Constantes.VERSION_INICIAL
        );
    }
}
