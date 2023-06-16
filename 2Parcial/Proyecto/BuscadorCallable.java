/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p;

import java.util.concurrent.Callable;

/**
 *
 * @author yazminurzuac
 */import java.util.concurrent.Callable;

public class BuscadorCallable implements Callable<Integer> {

    private String texto;
    private String palabra;

    public BuscadorCallable(String texto, String palabra) {
        this.texto = texto;
        this.palabra = palabra;
    }

    @Override
    public Integer call() throws Exception {
        int index = texto.indexOf(palabra);
        int count = 0;
        while (index != -1) {
            count++;
            texto = texto.substring(index + palabra.length());
            index = texto.indexOf(palabra);
        }
        return count;
    }
}
