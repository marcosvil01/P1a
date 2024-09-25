package exercicis;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ex_12 {
    public static void main(String[] args) {
        // Nom del fitxer
        String fileName = "files/Exercici11.dat";

        // Llegir i mostrar els noms i edats del fitxer binari
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                String nom = dis.readUTF(); // Llegir el nom
                int edat = dis.readInt();    // Llegir l'edat
                System.out.println(nom + " " + edat);
            }
        } catch (IOException e) {
            System.out.println("S'ha produït un error en llegir el fitxer: " + e.getMessage());
        }
    }
}
