/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matriz;

/**
 *
 * @author yazminurzuac
 */
public class Thread2 extends Matriz implements Runnable{
    @Override
    public void run(){
    Matriz hilo2 = new Matriz();
    
    hilo2.creation();
    }
}
