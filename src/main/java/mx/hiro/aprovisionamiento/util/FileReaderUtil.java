package mx.hiro.aprovisionamiento.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    public static List<String[]> readTxtFile(String filePath) throws IOException {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Divide la línea por comas y la agrega a la lista
                lines.add(line.split("\\|"));
            }
        }
        return lines;
    }
}
