package mx.hiro.aprovisionamiento.service;

import mx.hiro.aprovisionamiento.dao.DetalleDAO;
import mx.hiro.aprovisionamiento.dao.impl.DetalleDAOImp;
import mx.hiro.aprovisionamiento.dto.DetalleDTO;
import mx.hiro.aprovisionamiento.util.FileReaderUtil;
import mx.hiro.aprovisionamiento.util.Conexion;
import mx.hiro.aprovisionamiento.util.SequenceUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DetallleService {
    public void procesarDetalle(String filePath) {
        System.out.println("Procesando detalle...");
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            // trata de leer el archivo
            try {
                List<String[]> lines = FileReaderUtil.readTxtFile(filePath);


                for (String[] values: lines) {
                    DetalleDTO detalleDTO = new DetalleDTO();
                    detalleDTO.setIdDetalle(SequenceUtil.getNextValue(conexion, "idDetalle"));



                }

            }
            catch (IOException ioE) {
                ioE.printStackTrace(System.out);
                System.out.println("Error en la lectura del archivo");
            }
            int idDetalle = SequenceUtil.getNextValue(conexion, "idDetalle");

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Rollback - Error en la transacción");
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace(System.out);
            }


        }
    }
}