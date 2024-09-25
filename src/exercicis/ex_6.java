package exercicis;

import java.io.FileWriter;
import java.io.IOException;

public class ex_6 {
    public static void main(String[] args) {
        // Declarar i inicialitzar l'array de cadenes de text
        String[] textos = {
                "Primera cadena de text.",
                "Segona cadena de text.",
                "Tercera cadena de text.",
                "Quarta cadena de text."
        };

        // Nom del fitxer
        String fileName = "files/Exercici06.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            // Escriure cada cadena del array en el fitxer
            for (String text : textos) {
                writer.write(text + "\n"); // Afegim un salt de línia després de cada cadena
            }

            // Tancar l'arxiu automàticament gràcies al try-with-resources
            System.out.println("Textos escrits amb èxit al fitxer " + fileName);
        } catch (IOException e) {
            System.out.println("S'ha produït un error en escriure al fitxer: " + e.getMessage());
        }
    }
}
