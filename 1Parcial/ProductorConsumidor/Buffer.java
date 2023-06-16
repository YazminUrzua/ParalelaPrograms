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
public class Buffer {
    private char []buffer;
    private int siguiente;
    private boolean estaLlena;
    private boolean estaVacia;

    public Buffer(int tamanio) {
        
        this.buffer = new char[tamanio];
        this.siguiente = 0;
        this.estaLlena = false;
        this.estaVacia = true;
    }
    
    public synchronized char consumir(){
        while(this.estaVacia){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        siguiente--;
        this.estaLlena =false;
        if(siguiente == 0){
            this.estaVacia = true;
            
        }
        notifyAll();
        return this.buffer[siguiente];
        
    }
    
    public synchronized void producir(char c){
        while(this.estaLlena){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        buffer[siguiente]= c;
        siguiente++;
        
        this.estaVacia = false;
        if(siguiente == this.buffer.length){
            this.estaLlena = true;
            
        }
        notify();
    }
    
}
