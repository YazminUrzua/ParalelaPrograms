
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p;

/**
 *
 * @author yazminurzuac
 */
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
//Clase ForkJoinimport java.util.concurrent.RecursiveTask;

public class BuscadoAr extends RecursiveTask<Integer> {
    private String texto;
    private String palabra;
    private int umbral;

    public BuscadoAr(String texto, String palabra, int umbral) {
        this.texto = texto;
        this.palabra = palabra;
        this.umbral = umbral;
    }

    @Override
    protected Integer compute() {
        if (texto.length() <= umbral) {
            // Calcular el número de ocurrencias de la palabra en la porción actual del texto
            int count = 0;
            int index = texto.indexOf(palabra);
            while (index != -1) {
                count++;
                texto = texto.substring(index + palabra.length());
                index = texto.indexOf(palabra);
            }
            return count;
        } else {
            // Dividir el texto en dos partes y crear una tarea para cada parte
            int medio = texto.length() / 2;
            String texto1 = texto.substring(0, medio);
            String texto2 = texto.substring(medio);
            BuscadoAr tarea1 = new BuscadoAr(texto1, palabra, umbral);
            BuscadoAr tarea2 = new BuscadoAr(texto2, palabra, umbral);
            // Invocar las tareas secundarias de forma paralela
            tarea1.fork();
            tarea2.fork();
            // Combinar los resultados de las tareas secundarias
            return tarea1.join() + tarea2.join();
        }
    }
}
