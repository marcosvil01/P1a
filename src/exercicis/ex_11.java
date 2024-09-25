package exercicis;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ex_11 {
    public static void main(String[] args) {
        // Arrays de noms i edats
        String[] noms = {"Ana", "Lluís Miquel", "Alícia", "Pere", "Manel", "Andrés", "Julio", "Antoni", "Maria"};
        int[] edats = {14, 15, 13, 15, 16, 12, 16, 14, 13};

        // Nom del fitxer
        String fileName = "files/Exercici11.dat";

        // Escriure els noms i edats al fitxer binari de manera alternada
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int i = 0; i < noms.length; i++) {
                dos.writeUTF(noms[i]); // Escriure el nom
                dos.writeInt(edats[i]); // Escriure l'edat
            }
            System.out.println("Les dades han estat escrites correctament a " + fileName);
        } catch (IOException e) {
            System.out.println("S'ha produït un error en escriure al fitxer: " + e.getMessage());
        }
    }
}
