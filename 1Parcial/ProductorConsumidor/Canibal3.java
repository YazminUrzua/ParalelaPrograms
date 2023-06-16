/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yazminurzuac
 */

public class Canibal3 extends Thread{
    private Buffer buffer;
    

    public Canibal3(Buffer b) {
        this.buffer = b;
    }
  
    public void run(){
        while(true){
            
            try {
                char c = this.buffer.consumir();
                System.out.println("Canibal #3 ha consumido la olla: "+c);
                
                sleep((int)Math.random()*2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Canibal.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
      
   }
}


