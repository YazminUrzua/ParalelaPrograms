/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matriz;

import java.util.Random;

/**
 *
 * @author yazminurzuac
 */
public class Matriz {
     
    public void creation() {
     //System.out.println("h");
    Random aleatory = new Random();
    int [][] matrix = new int [3][3];
    int n = 2;
    
    //assignment of random numbers
    //first for is for the assignment by row(fila)    columns
    for(int i=0; i<matrix.length; i++){
       //second for is for the assignment by columns(columnas)      
        for(int j=0; j<matrix.length; j++){
            //Use the random function
            matrix[i][j] = aleatory.nextInt(10-0+1)+0;
         }
      }
    
    //Matrix result
    String print = "";
    //Same cycle for
    //first for is for the assignment by row(fila)    columns
    for( int i=0; i<matrix.length; i++){
       //second for is for the assignment by columns(columnas)      
        for(int j=0; j<matrix.length; j++){
            //Matrix multiplication
            int resultado = n*matrix[i][j];
            print = print + "  "+matrix[i][j];
            //print = print + "  "+resultado;
         }
         print = print + "  \n";
      }
    System.out.println(print);
} 
}

