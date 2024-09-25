package exercicis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ex_7 {
    public static void main(String[] args) {
        // Nom del fitxer que volem llegir
        String fileName = "files/Exercici06.txt";

        // Intentar obrir el fitxer i llegir-lo línia per línia
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Llegir cada línia i mostrar-la
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("S'ha produït un error en llegir el fitxer: " + e.getMessage());
        }
    }
}
