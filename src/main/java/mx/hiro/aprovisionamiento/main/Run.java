package mx.hiro.aprovisionamiento.main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import mx.hiro.aprovisionamiento.service.DetallleService;
import mx.hiro.aprovisionamiento.service.NotificacionService;
import mx.hiro.aprovisionamiento.util.Conexion;
import mx.hiro.aprovisionamiento.util.Constantes;
import mx.hiro.aprovisionamiento.util.SequenceUtil;

public class Run {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            // Generar secuencias
            long idOperation = SequenceUtil.getNextValue(conexion, Constantes.SEC_ID_OPER);
            long idCifra = SequenceUtil.getNextValue(conexion, Constantes.SEC_ID_CIF);
            long idIncidencia = SequenceUtil.getNextValue(conexion, Constantes.SEC_ID_INC);
            long idDetalle = SequenceUtil.getNextValue(conexion, Constantes.SEC_ID_DETALLE);


            System.out.println("Secuencia idOperacion: " + idOperation);
            System.out.println("Secuencia idCifra: " + idCifra);
            System.out.println("Secuencia idIncidencia: " + idIncidencia);

            //recibimos el archivo
            String fileName="/home/hiro/Documentos/Coding/GenDatosClientes.txt";

            //Validamos que existe si no no procesamo
            File interfazEntrada = new File(fileName);
            if(!interfazEntrada.exists()){
                throw new IOException("El archivo no existe");
            }else{
                // Se llama a logica de negocio
                NotificacionService notificacionService = new NotificacionService();
                notificacionService.crearNotificacionInicial(conexion, idOperation, idCifra, idIncidencia, fileName);
                DetallleService procesaArchivo = new DetallleService();
                procesaArchivo.procesarDetalle(conexion, fileName, idOperation, idCifra, idDetalle);




            }

            // Crear notificación inicial





            conexion.commit();
            System.out.println("Se ha hecho commit de la transacción");
        } catch (SQLException | IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        } finally {
            Conexion.close(conexion);
        }
    }
}

