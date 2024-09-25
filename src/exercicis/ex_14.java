package exercicis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ex_14 {
    public static void main(String[] args) {
        // Nom del fitxer
        String fileName = "files/Exercici14.dat";

        // Llegir i mostrar les dades dels objectes Persona
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    Persona persona = (Persona) ois.readObject();
                    System.out.println("Nom: " + persona.getNom() + " Edat: " + persona.getEdat());
                } catch (IOException | ClassNotFoundException e) {
                    break; // Final de fitxer
                }
            }
        } catch (IOException e) {
            System.out.println("S'ha produït un error en llegir el fitxer: " + e.getMessage());
        }
    }
}
