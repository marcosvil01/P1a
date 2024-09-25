package exercicis;

import java.io.FileReader;
import java.io.IOException;

public class ex_3 {
    public static void main(String[] args) {
        // Ruta del fitxer de text que vols llegir
        String filePath = "files/text.txt";  // Cambia a la ruta del archivo real

        try (FileReader reader = new FileReader(filePath)) {
            int character;
            // Llegeix el fitxer caràcter a caràcter
            while ((character = reader.read()) != -1) {
                // Mostra el caràcter llegit
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("S'ha produït un error en llegir el fitxer: " + e.getMessage());
        }
    }
}
