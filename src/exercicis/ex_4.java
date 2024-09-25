package exercicis;

import java.io.FileReader;
import java.io.IOException;


public class ex_4 {
    public static void main(String[] args) {
        String fileName = "files/text.txt";  // Cambia a la ruta del archivo real

        try (FileReader reader = new FileReader(fileName)) {
            char[] buffer = new char[20]; // Crear un buffer de 20 caràcters
            int numCharsRead;

            // Llegir el fitxer en blocs de 20 caràcters
            while ((numCharsRead = reader.read(buffer)) != -1) {
                // Mostrar els caràcters llegits
                System.out.println(new String(buffer, 0, numCharsRead) + "20 chars");

            }
        } catch (IOException e) {
            System.out.println("S'ha produït un error en llegir el fitxer: " + e.getMessage());
        }
    }
}
