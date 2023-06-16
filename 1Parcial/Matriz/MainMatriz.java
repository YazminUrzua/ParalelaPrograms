/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matriz;

/**
 *
 * @author yazminurzuac
 */
public class MainMatriz {
    public static void main(String[] ar){
    Thread matrix1 = new Thread(new Thread1());
    Thread matrix2 = new Thread(new Thread2());
       
       matrix1.start();
       matrix2.start();
     
       System.out.println("\nH1\n"+matrix1);
       System.out.println("\nH2\n"+matrix2);
       
}
}