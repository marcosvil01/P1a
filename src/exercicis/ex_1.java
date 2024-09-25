package exercicis;

import java.io.File;

public class ex_1 {
    public static void main(String[] args) {
        // Aquí puedes poner directamente la ruta del archivo que deseas comprobar
        String fileName = "files/text.txt";

        // Crear el objeto File
        File file = new File(fileName);

        // Comprobar si el archivo existe
        if (!file.exists()) {
            System.out.println("L'arxiu no existeix.");
        } else {
            // Comprobar si es un directori
            if (file.isDirectory()) {
                System.out.println("Aquest és un directori.");
            } else {
                // Mostrar informació del fitxer
                System.out.println("Informació del fitxer:");
                System.out.println("Nom: " + file.getName());
                System.out.println("Camí: " + file.getPath());
                System.out.println("Camí absolut: " + file.getAbsolutePath());
                System.out.println("Es pot llegir: " + (file.canRead() ? "Sí" : "No"));
                System.out.println("Es pot escriure: " + (file.canWrite() ? "Sí" : "No"));
                System.out.println("Mida: " + file.length() + " bytes");
            }
        }
    }
}
