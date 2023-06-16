/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author yazminurzuac
 */
public class Main {
    public static void main(String args[]){
      
        Buffer b = new Buffer(2);
        Cocinero co = new Cocinero(b);
        Canibal ca = new Canibal(b);
        Canibal2 ca2 = new Canibal2(b);
        Canibal3 ca3 = new Canibal3(b);
        
        
        co.start();
        ca.start();
        ca2.start();
        ca3.start();
    }
}
