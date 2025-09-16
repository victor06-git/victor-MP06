package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PR110ReadFile {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer);  // Només cridem a la funció amb la ruta del fitxer
    }

    // Funció que llegeix el fitxer i mostra les línies amb numeració
    //Exemple 1: Primera linia del fitxer
    public static void llegirIMostrarFitxer(String camiFitxer) {
        try {
            List<String> linies = Files.readAllLines(Paths.get(camiFitxer), StandardCharsets.UTF_8);
            //Inicialització del número de linia
            int number = 1;
            //Bucle que recorre cada linea de l'arxiu .java
            for (String linia : linies) {
                //Afegeix a cada print el número: linia
                System.out.println(number + ": " + linia);
                //Incrementa el número segons la línia en la que es troba
                number++;
        }
        } catch (IOException e) {
            System.out.println("Error en la lectura del fitxer: " + camiFitxer);
            e.printStackTrace();
        }
    }


}
