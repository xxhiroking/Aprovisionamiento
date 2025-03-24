package mx.hiro.aprovisionamiento.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import mx.hiro.aprovisionamiento.dao.DetalleDAO;
import mx.hiro.aprovisionamiento.dao.NotificacionesDAO;
import mx.hiro.aprovisionamiento.dao.impl.DetalleDAOImp;
import mx.hiro.aprovisionamiento.dao.impl.NotificacionesDAOImp;
import mx.hiro.aprovisionamiento.dto.DetalleDTO;
import mx.hiro.aprovisionamiento.util.Constantes;
import mx.hiro.aprovisionamiento.util.FileReaderUtil;

public class DetallleService implements Constantes {
    //leemos archivo de entrada
    public void procesarDetalle(Connection connection, String fileName, long idOper, long idCifra, long idDetalle) throws IOException, SQLException {
        List<String[]> lines = FileReaderUtil.readTxtFile(fileName);
        DetalleDAO detalleDAO = new DetalleDAOImp();
        NotificacionesDAO notificacionesDAO = new NotificacionesDAOImp(); // Added DAO for updating notification status

        int totalInsertados = 0;
        int totalIncidencias = 0;

        if (lines.isEmpty()) { // Check if the file is empty
            notificacionesDAO.actualizarNotiFallida(connection, (int) idOper);
            System.out.println("El archivo está vacío. Notificación marcada como FALLIDA.");
            return;
        }

        for (String[] line : lines) {
            // Validate that the line has the expected number of fields
            if (line.length < 7) {
                totalIncidencias++; // Increment incidences for invalid format
                continue;
            }

            // Asignamos cada campo a una variable según el layout
            DetalleDTO detalleDTO = new DetalleDTO();
            detalleDTO.setIdDetalle(idDetalle);
            detalleDTO.setIdOperacion(idOper);
            detalleDTO.setIdCifras(idCifra);
            detalleDTO.setCliente(line[0]);
            detalleDTO.setCuenta(line[1]);
            detalleDTO.setFolio(line[2]);
            detalleDTO.setRfcR(line[3]);
            detalleDTO.setRfcE(line[4]);
            detalleDTO.setTipoParticipacion(line[5]);
            detalleDTO.setEjercicioFiscal(Integer.valueOf(line[6]));
            detalleDTO.setEstatus(Constantes.ESTATUS_INICIAL);
            detalleDTO.setIdConstancia(Constantes.ID_CONSTANCIA);
            detalleDTO.setVersion(Constantes.VERSION_INICIAL);
            // Set fechaCreacion to the current system date and time
            detalleDTO.setFechaCreacion(LocalDateTime.now());
            // Set fechaCancelacion to null
            detalleDTO.setFechaCancelacion(null);

            // Persistimos el objeto en la base de datos
            try {
                detalleDAO.guardarDetalle(connection, detalleDTO);
                totalInsertados++; // Increment successful inserts
            } catch (SQLException e) {
                totalIncidencias++; // Increment incidences for failed insert
            }
        }

        if (totalInsertados == 0) { // If no records were inserted
            notificacionesDAO.actualizarNotiFallida(connection, (int) idOper);
            System.out.println("No se pudo insertar ningún registro. Notificación marcada como FALLIDA.");
        }

        System.out.println("Total registros insertados correctamente: " + totalInsertados);
        System.out.println("Total incidencias: " + totalIncidencias);
    }

}