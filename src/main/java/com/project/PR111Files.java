package com.project;

import java.io.File;
import java.io.IOException;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        gestionarArxius(camiFitxer);
    }

    public static void gestionarArxius(String camiFitxer) {
    
        // Crear la carpeta myFiles si no existeix
        String directoriMyFiles = camiFitxer + "/myFiles"; // Ruta completa de la carpeta myFiles
        File carpeta = new File(directoriMyFiles); // Crear objecte File per a la carpeta
        if (!carpeta.exists()) { // Comprovar si la carpeta no existeix
            if (carpeta.mkdirs()) { // Crear la carpeta
            System.out.println("Carpeta creada: " + directoriMyFiles);
            } else {
            System.out.println("Error en crear la carpeta: " + directoriMyFiles);
            return;
            }
        }

        // Crear file1.txt i file2.txt
        File file1 = new File(directoriMyFiles + "/file1.txt"); // Ruta completa de file1.txt
        File file2 = new File(directoriMyFiles + "/file2.txt"); // Ruta completa de file2.txt
        try {
            if (file1.createNewFile()) {
            System.out.println("Arxiu creat: " + file1.getName());
            }
            if (file2.createNewFile()) {
            System.out.println("Arxiu creat: " + file2.getName());
            }
        } catch (IOException e) {
            System.out.println("Error en crear els arxius: " + e.getMessage());
        }

        // Renombrar file2.txt a renamedFile.txt
        File renamedFile = new File(directoriMyFiles + "/renamedFile.txt");
        if (file2.exists()) { // Comprovar si file2.txt existeix
            if (file2.renameTo(renamedFile)) { // Renombrar l'arxiu
            System.out.println("Arxiu renombrat a: " + renamedFile.getName());
            } else {
            System.out.println("No s'ha pogut renombrar l'arxiu.");
            }
        }

        // Llistar arxius de la carpeta
        System.out.println("Els arxius de la carpeta són:"); // Llistar arxius
        String[] arxius = carpeta.list(); // Obtenir llista d'arxius
        if (arxius != null) {
            for (String nomArxiu : arxius) { // Iterar i imprimir noms d'arxius
            System.out.println(nomArxiu);
            }
        }

        // Eliminar file1.txt
        if (file1.exists()) { // Comprovar si file1.txt existeix
            if (file1.delete()) {
            System.out.println("Arxiu eliminat: " + file1.getName());
            } else {
            System.out.println("No s'ha pogut eliminar l'arxiu: " + file1.getName());
            }
        }

        // Tornar a llistar arxius de la carpeta
        System.out.println("Els arxius de la carpeta són:");
        arxius = carpeta.list();
        if (arxius != null) {
            for (String nomArxiu : arxius) {
            System.out.println(nomArxiu);
            }
        }

    }
}
