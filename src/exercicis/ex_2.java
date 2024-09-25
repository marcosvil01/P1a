package exercicis;

import java.io.File;
import java.io.IOException;

public class ex_2 {
    public static void main(String[] args) {
        // Crear el directorio "New folder"
        File newDirectory = new File("New folder");

        if (newDirectory.exists()) {
            System.out.println("El directori ja existeix.");
        } else {
            if (newDirectory.mkdir()) {
                System.out.println("Directori 'New folder' creat amb èxit.");
            } else {
                System.out.println("No s'ha pogut crear el directori.");
                return;
            }
        }

        // Crear File1.txt y File2.txt en el directori "New folder"
        File file1 = new File(newDirectory, "File1.txt");
        File file2 = new File(newDirectory, "File2.txt");

        try {
            if (file1.createNewFile()) {
                System.out.println("File1.txt creat.");
            } else {
                System.out.println("File1.txt ja existeix.");
            }

            if (file2.createNewFile()) {
                System.out.println("File2.txt creat.");
            } else {
                System.out.println("File2.txt ja existeix.");
            }
        } catch (IOException e) {
            System.out.println("Error en crear els fitxers: " + e.getMessage());
        }

        // Renombrar File1.txt a File1 new.txt
        File newFile1 = new File(newDirectory, "File1 new.txt");
        if (file1.renameTo(newFile1)) {
            System.out.println("File1.txt renombrat a 'File1 new.txt'.");
        } else {
            System.out.println("No s'ha pogut renombrar File1.txt.");
        }

        // Esborrar File2.txt
        if (file2.delete()) {
            System.out.println("File2.txt esborrat amb èxit.");
        } else {
            System.out.println("No s'ha pogut esborrar File2.txt.");
        }
    }
}
