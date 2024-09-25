package exercicis;

import java.io.PrintWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class ex_9 {
    public static void main(String[] args) {
        // Nom del fitxer
        String fileName = "files/Exercici09.txt";

        // Format per assegurar-nos que els números tinguin dos dígits (ex: 01, 02...)
        DecimalFormat df = new DecimalFormat("00");

        try (PrintWriter writer = new PrintWriter(fileName)) {
            // Escriure les files numerades de 01 a 10
            for (int i = 1; i <= 10; i++) {
                writer.println("Fila número: " + df.format(i));
            }

            // Tancar l'arxiu automàticament gràcies al try-with-resources
            System.out.println("Les files han estat escrites amb èxit al fitxer " + fileName);
        } catch (IOException e) {
            System.out.println("S'ha produït un error en escriure al fitxer: " + e.getMessage());
        }
    }
}
