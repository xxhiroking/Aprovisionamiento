package mx.hiro.aprovisionamiento.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SequenceUtil {
    private static final Logger logger = Logger.getLogger(SequenceUtil.class.getName());

    public static int getNextValue(Connection connection, String sequenceName) throws SQLException {
        String sql = "{CALL nextval(?, ?)}"; // Llamada al procedimiento almacenado
        try (CallableStatement callableStatement = connection.prepareCall(sql)) {
            callableStatement.setString(1, sequenceName); // Nombre de la secuencia
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER); // Parámetro de salida

            callableStatement.execute(); // Ejecutar el procedimiento

            int nextValue = callableStatement.getInt(2); // Obtener el valor generado
            if (callableStatement.wasNull()) {
                throw new SQLException("Failed to retrieve next value for sequence: " + sequenceName);
            }
            // Validar el rango del valor generado para evitar truncamiento
            if (nextValue < -32768 || nextValue > 32767) { // Ajustar el rango según el tipo de columna (e.g., SMALLINT)
                throw new SQLException("Generated value " + nextValue + " is out of range for column 'idIncidencias'.");
            }
            return nextValue;
        }
    }
}
