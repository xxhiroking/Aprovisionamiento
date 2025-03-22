package mx.hiro.aprovisionamiento.main;

import mx.hiro.aprovisionamiento.dao.impl.NotificacionesDAOImp;
import mx.hiro.aprovisionamiento.dto.BitacoraDTO;
import mx.hiro.aprovisionamiento.dto.NotificacionesDTO;
import mx.hiro.aprovisionamiento.util.Conexion;
import mx.hiro.aprovisionamiento.util.SequenceUtil;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.SQLException;

public class Run {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //Parametros de inicio
            int idBitacora = SequenceUtil.getNextValue(conexion, "idBitacora");
            int idOperacion = SequenceUtil.getNextValue(conexion, "idOperacion");
            int idIncidencia = SequenceUtil.getNextValue(conexion, "idIncidencia");
            int idCifra = SequenceUtil.getNextValue(conexion, "idCifra");
            Date fechaAlta = new Date();
            Date fechaCreacion = new Date();
            //Inicio de procesomiento
            NotificacionesDTO notificacionesDTO = new NotificacionesDTO(idOperacion, "archivo.txt", fechaAlta, "Hiro", "1", idCifra , idIncidencia, fechaCreacion, "A", "1");
            NotificacionesDAOImp notificacionesDAOImp = new NotificacionesDAOImp();
            notificacionesDAOImp.crearNotificacion(conexion, notificacionesDTO);




















            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }

    }

