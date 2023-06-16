import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yazminurzuac
 */
public class implementacion implements cal{
    static Scanner sc= new Scanner(System.in);

    @Override
    public int suma(int num1, int num2) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    System.out.println("Introduce el primer número:");      
    num1= sc.nextInt();
      
    System.out.println("Introduce el segundo número:");
    num2= sc.nextInt();
    //Operacion de suma
    int resultado = num1+num2;
    //Resultado impreso
    System.out.println("La suma es " + num1 + " + " + num2 + " = " + resultado);
        return 0;
    }

    @Override
    public int resta(int num1, int num2) {
       //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    System.out.println("Introduce el primer número:");      
    num1= sc.nextInt();
      
    System.out.println("Introduce el segundo número:");
    num2= sc.nextInt();
    //Operacion de resta
    int resultado = num1-num2;
    //Resultado impreso
    System.out.println("La resta es " + num1 + " - " + num2 + " = " + resultado);
        return 0;
    }

    @Override
    public int multiplicacion(int num1, int num2) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    System.out.println("Introduce el primer número:");      
    num1= sc.nextInt();
      
    System.out.println("Introduce el segundo número:");
    num2= sc.nextInt();
    //Operacion de multilplicacion
    int resultado = num1*num2;
    //Resultado impreso
    System.out.println("La multiplicacion de: " + num1 + " * " + num2 + " = " + resultado);
        return 0;
    }
    
    @Override
    public int division(float num1, float num2) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   System.out.println("Introduce el primer número:");      
    num1= sc.nextInt();
      
    System.out.println("Introduce el segundo número:");
    num2= sc.nextInt();
    //Operacion de la division
    float resultado = num1/num2;
    //Resultado impreso
    System.out.println("La division de: " + num1 + " / " + num2 + " = " + resultado);
        return 0;
    }

    @Override
    public int potencia(int num1, int num2) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    System.out.println("Introduce un número:");      
    num1= sc.nextInt();
    System.out.println("Introduce el número potencia:");
    num2= sc.nextInt();
    //Operacion de potencia
        double resultado = Math.pow(num1,num2);
    //Resultado impreso
    System.out.println("El resultado de" + num1 + " ^ " + num2 + " = " + resultado);
        return 0;
    }

    @Override
    public int modulo(int num1, int num2) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    System.out.println("Introduce un primer número:");      
    num1= sc.nextInt();
    System.out.println("Introduce un segundo número :");
    num2= sc.nextInt();
    //Operacion de modulo
        int resultado = num1%num2;
    //Resultado impreso
    System.out.println("El modulo de: " + num1 + " % " + num2 + " = " + resultado);
        return 0;
    }

    
}
