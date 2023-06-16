import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author yazminurzuac
 */
public class Interface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       cal c = new implementacion();    
       Scanner sn = new Scanner(System.in);
       boolean salir = false;
       int num1 = 0;
       int num2 = 0;
       int opcion; //Guardaremos la opcion del usuario
        while(!salir){
           System.out.println("\nBienvenido\nMenu de opciones\n");
         
           System.out.println("1. Suma");
           System.out.println("2. Resta");
           System.out.println("3. Multiplicacion");
           System.out.println("4. Division");
           System.out.println("5. Potencia");
           System.out.println("6. Modulo");
           System.out.println("7. Salir \n");
           System.out.println("Escribe una de las opciones:");
            
           opcion = sn.nextInt();
            
           switch(opcion){
               case 1:
                   System.out.println("\nHas seleccionado la opcion 1\n");
                   c.suma(num1, num2);
                   
                   break;
               
               case 2:
                   System.out.println("\nHas seleccionado la opcion 2\n");
                   c.resta(num1, num2);
                 
                   break;
                   
               case 3:
                   System.out.println("\nHas seleccionado la opcion 3\n");
                   c.multiplicacion(num1, num2);
                   
                   break;
                
               case 4:
                   System.out.println("\nHas seleccionado la opcion 4\n");
                   c.division(num1, num2);
                   
                   break;
               case 5:
                   System.out.println("\nHas seleccionado la opcion 5\n");
                   c.potencia(num1, num2);
                   
                   break;
                
               case 6:
                   System.out.println("\nHas seleccionado la opcion 6\n");
                   c.modulo(num1, num2);
                   
                   break;    
                   
                case 7:
                   salir=true;
                   System.out.println("Hasta luego!\n\nFin del programa.");
                   break;
                   
                default:
                   System.out.println("\nElige porfavor solo números entre 1 y 7\n");
           }
            
       }
    }
    
}
