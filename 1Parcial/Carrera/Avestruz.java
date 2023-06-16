/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author yazminurzuac
 */
public class Avestruz extends Thread{
  
   @Override
    public void run(){
        double  a = 19.6667;
        int usuario =100;
        double recorrido = 0;
        
        System.out.println("**Avestruz inicia**");
        
        
        while(recorrido<usuario){
           
           
            try{
            
            System.out.println("Avestruz ha avanzado: "+recorrido+"m/s");
            recorrido+=a;
            Thread.sleep(1000);
            
           
        }catch (InterruptedException e){
            e.printStackTrace();
        }
            a++;
      }
        System.out.println("**Avestruz ha terminado**");
    }
}