package exercicis;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ex_16 {
    public static void main(String[] args) {
        String fileName = "files/Exercise16.dat";
        int idBuscat = 5; // Identificador de l'empleat que volem consultar

        // Cada empleat té: 4 bytes per l'ID (int), 20 bytes per al cognom (10 caràcters * 2 bytes), 4 bytes pel departament (int), 8 bytes pel salari (double)
        int midaRegistre = 4 + 20 + 4 + 8;

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            long posicio = (idBuscat - 1) * midaRegistre; // Calcular la posició de l'empleat al fitxer
            raf.seek(posicio); // Mou l'apuntador a la posició de l'empleat

            // Llegir les dades de l'empleat
            int id = raf.readInt(); // ID de l'empleat
            String cognom = "";
            for (int i = 0; i < 10; i++) { // Llegir els 10 caràcters del cognom
                cognom += raf.readChar();
            }
            int dept = raf.readInt();
            double salari = raf.readDouble();

            // Mostrar les dades de l'empleat
            System.out.println("ID: " + id + ", Cognom: " + cognom.trim() + ", Departament: " + dept + ", Salari: " + salari);
        } catch (IOException e) {
            System.out.println("S'ha produït un error en llegir el fitxer: " + e.getMessage());
        }
    }
}
