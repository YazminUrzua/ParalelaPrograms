/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yazminurzuac
 */
public class Cocinero extends Thread{
    private Buffer buffer;
    private final String cantOllas = "123456789";
   
              

    public Cocinero(Buffer b) {
    this.buffer = b;
    }
    
    public void run(){
        while(true){
            
            try {
               
                char c =  cantOllas.charAt ((int)(Math.random() * cantOllas.length()));
                buffer.producir(c);
                System.out.println("El cocinero ha servido la olla numero: "+c);
                sleep((int)Math.random()*2000);
                 
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
