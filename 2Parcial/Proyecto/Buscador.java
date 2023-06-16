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
//algoritmo
public class Buscador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el texto: ");
        String texto = scanner.nextLine();

        System.out.print("Ingresa la palabra a buscar: ");
        String palabra = scanner.nextLine();

        int index = texto.indexOf(palabra);
        int count = 0;
        while (index != -1) {
            count++;
            texto = texto.substring(index + palabra.length());
            index = texto.indexOf(palabra);
        }
        System.out.println("Se encontraron " + count + " resultados.");
    }

    Buscador(String texto, String palabra) {
         }

  

}
