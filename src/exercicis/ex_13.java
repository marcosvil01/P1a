package exercicis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Persona implements Serializable {
    private String nom;
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }
}

public class ex_13 {
    public static void main(String[] args) {
        // Arrays de noms i edats
        String[] noms = {"Ana", "Lluís Miquel", "Alícia", "Pere", "Manel", "Andrés", "Julio", "Antoni", "Maria"};
        int[] edats = {14, 15, 13, 15, 16, 12, 16, 14, 13};

        // Nom del fitxer
        String fileName = "files/Exercici14.dat";

        // Escriure objectes Persona en el fitxer binari
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (int i = 0; i < noms.length; i++) {
                Persona persona = new Persona(noms[i], edats[i]);
                oos.writeObject(persona);
            }
            System.out.println("Les persones han estat escrites correctament a " + fileName);
        } catch (IOException e) {
            System.out.println("S'ha produït un error en escriure al fitxer: " + e.getMessage());
        }
    }
}
