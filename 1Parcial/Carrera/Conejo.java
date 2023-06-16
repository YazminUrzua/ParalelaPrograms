/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author yazminurzuac
 */
public class Conejo extends Thread{
     @Override
    public void run(){
        double c = 11.1111;
        int usuario =100;
        double recorrido = 0;
       
        System.out.println("**Conejo inicia**");
        while(recorrido<usuario){
            try{

            
            Thread.sleep(1000);
            
            System.out.println("Conejo ha avanzado: "+recorrido+"m/s");
            recorrido+=c;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
            c++;
      }
        System.out.println("**Conejo ha terminado**");
    }

}