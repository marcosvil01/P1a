package exercicis;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ex_15 {
    public static void main(String[] args) {
        String fileName = "files/Exercise16.dat";

        // Dades dels empleats
        String[] cognoms = {"Güllich", "Usobiaga", "Bereciartu", "Rébuffat", "Cassin", "Andrada", "Iglesias"};
        int[] departaments = {10, 20, 10, 10, 30, 30, 20};
        double[] salaris = {1000.45, 2400.60, 3000.00, 1500.56, 2200.00, 1435.87, 2000.00};

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            // Escriure les dades dels empleats
            for (int i = 0; i < cognoms.length; i++) {
                raf.writeInt(i + 1); // Identificador (ID)

                // Escriure cognom amb un màxim de 10 caràcters (si el cognom és més curt, es completa amb espais)
                String cognom = String.format("%-10s", cognoms[i]);
                raf.writeChars(cognom);

                raf.writeInt(departaments[i]); // Departament
                raf.writeDouble(salaris[i]); // Salari
            }
            System.out.println("Les dades dels empleats s'han escrit correctament al fitxer.");
        } catch (IOException e) {
            System.out.println("S'ha produït un error: " + e.getMessage());
        }

        // Llegir i mostrar les dades dels empleats
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                int id = raf.readInt();
                String cognom = "";
                for (int i = 0; i < 10; i++) {
                    cognom += raf.readChar(); // Llegir cada caràcter del cognom
                }
                int dept = raf.readInt();
                double salari = raf.readDouble();

                System.out.println("ID: " + id + ", Cognom: " + cognom.trim() + ", Departament: " + dept + ", Salari: " + salari);
            }
        } catch (IOException e) {
            System.out.println("S'ha produït un error en llegir el fitxer: " + e.getMessage());
        }
    }
}
