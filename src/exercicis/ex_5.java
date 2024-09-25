package exercicis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ex_5 {
    public static void main(String[] args) {
        // Declarar e inicialitzar la cadena de text
        String text = "Aquest és un exemple de cadena de text.";

        // Nom del fitxer
        String fileName = "files/Exercici05.txt";

        // Crear l'objecte File per comprovar si el fitxer existeix
        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("El fitxer ja existeix.");
        } else {
            System.out.println("El fitxer no existeix, es crearà un nou fitxer.");
        }

        try (FileWriter writer = new FileWriter(file)) {
            // Escriure la cadena caràcter a caràcter
            for (int i = 0; i < text.length(); i++) {
                writer.write(text.charAt(i));
            }

            // Escriure l'asterisc (*) al final
            writer.write('*');

            // Tancar l'arxiu automàticament gràcies al try-with-resources
            System.out.println("Text escrit amb èxit al fitxer " + fileName);
        } catch (IOException e) {
            System.out.println("S'ha produït un error en escriure al fitxer: " + e.getMessage());
        }
    }
}
