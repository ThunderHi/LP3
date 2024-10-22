package Actividades;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class ContadorPalabras {
    public static void main(String[] args) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            int totalLineas = 0, totalPalabras = 0, totalCaracteres = 0;
            Map<String, Integer> frecuenciaPalabras = new HashMap<>();

            while ((linea = lector.readLine()) != null) {
                totalLineas++;
                String[] palabras = linea.split("\\s+");
                totalPalabras += palabras.length;
                for (String palabra : palabras) {
                    totalCaracteres += palabra.length();
                    palabra = palabra.toLowerCase();
                    frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                }
            }
            lector.close();

            // Resultados
            System.out.println("Total de líneas: " + totalLineas);
            System.out.println("Total de palabras: " + totalPalabras);
            System.out.println("Total de caracteres: " + totalCaracteres);
            System.out.println("Promedio de palabras por línea: " + (double) totalPalabras / totalLineas);

            // Palabras más frecuentes
            System.out.println("Palabras más frecuentes:");
            frecuenciaPalabras.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(5).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        }
    }
}

