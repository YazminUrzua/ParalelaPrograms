/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yazminurzuac
 */
public class Jirafa extends Thread{
   
     @Override
    public void run(){
        double j = 16.6667;
        int usuario =100;
        double recorrido = 0;
       
        System.out.println("**Jirafa inicia**");
        while(recorrido<usuario){
            try{

            
            Thread.sleep(1000);
            
            System.out.println("Jirafa ha avanzado: "+recorrido+"m/s");
            recorrido+=j;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
            j++;
      }
        System.out.println("**Jirafa ha terminado**");
    }

}
