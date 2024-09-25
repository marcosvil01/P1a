package exercicis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ex_10 {
    public static void main(String[] args) {
        String fileName = "files/Exercise10.dat";

        // Escriure els números de l'1 al 100 en el fitxer binari
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int i = 1; i <= 100; i++) {
                dos.writeInt(i);
            }
            System.out.println("Els números s'han escrit al fitxer binari correctament.");
        } catch (IOException e) {
            System.out.println("S'ha produït un error en escriure al fitxer: " + e.getMessage());
        }

        // Llegir els números del fitxer binari
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int number;
            while (dis.available() > 0) {
                number = dis.readInt();
                System.out.println(number);
            }
        } catch (IOException e) {
            System.out.println("S'ha produït un error en llegir el fitxer: " + e.getMessage());
        }
    }
}
