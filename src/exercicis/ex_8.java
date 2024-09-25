package exercicis;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class ex_8 {
    public static void main(String[] args) {
        // Nom del fitxer
        String fileName = "files/Exercici08.txt";

        // Format per assegurar-nos que els números tinguin dos dígits (ex: 01, 02...)
        DecimalFormat df = new DecimalFormat("00");

        try (FileWriter writer = new FileWriter(fileName)) {
            // Escriure les files numerades de 01 a 10
            for (int i = 1; i <= 10; i++) {
                writer.write("Fila número: " + df.format(i) + "\n");
            }

            // Tancar l'arxiu automàticament gràcies al try-with-resources
            System.out.println("Les files han estat escrites amb èxit al fitxer " + fileName);
        } catch (IOException e) {
            System.out.println("S'ha produït un error en escriure al fitxer: " + e.getMessage());
        }
    }
}
