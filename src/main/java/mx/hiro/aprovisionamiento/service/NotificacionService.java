package mx.hiro.aprovisionamiento.service;

import mx.hiro.aprovisionamiento.dao.impl.NotificacionesDAOImp;
import mx.hiro.aprovisionamiento.dto.NotificacionesDTO;
import mx.hiro.aprovisionamiento.util.Constantes;
import mx.hiro.aprovisionamiento.util.SequenceUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class NotificacionService implements Constantes {
    private final NotificacionesDAOImp notificacionesDAO;

    public NotificacionService() {
        this.notificacionesDAO = new NotificacionesDAOImp();
    }

    //Creamos una notificacion inicial
    public void crearNotificacionInicial(Connection connection) throws SQLException {
        NotificacionesDTO notificacionesDTO = construirNotificacionInicial(connection);
        int filasAfectadas = notificacionesDAO.crearNotificacion(connection, notificacionesDTO);
        if (filasAfectadas == 1) {
            System.out.println("Notificacion inicial creada correctamente");
        } else {
            System.out.println("No se pudo crear la notificacion inicial");
        }


    }

    //Construimos la notificacion inicial
    private NotificacionesDTO construirNotificacionInicial(Connection connection) throws SQLException {
        long idOperation = SequenceUtil.getNextValue(connection, Constantes.SEC_ID_OPER);
        Date fechaAlta = new Date();
        long idCifra = SequenceUtil.getNextValue(connection, Constantes.SEC_ID_CIF);
        long idIncidencia = SequenceUtil.getNextValue(connection, Constantes.SEC_ID_INC);
        Date fechaCreacion = new Date();

        return new NotificacionesDTO((int) idOperation, Constantes.FILENAME_GEN, fechaAlta, Constantes.USR, Constantes.TIPO_OPERACION, (int) idCifra, (int) idIncidencia, fechaCreacion, Constantes.ESTATUS_INICIAL, Constantes.VERSION_INICIAL);

    }
}
