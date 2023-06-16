/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yazminurzuac
 * 21110134- Urzúa Casillas Alondra Yazmín 
 * 15/02/23
 */

public class Cronometro extends Thread { 
    public Cronometro(){
        
    }
    @Override
    public void run() {
    int min=0; //minutos
    int seg=0; //segundos
    int hora=0; //horas   
        try {
            for (;min<2; ){ //inicio del for para que el ciclo termine en el minuto 2           
               if(seg!=59) {//if del ultimo segundo
                   seg++; //incremento el numero de segundos                                  
                }else{
                    if(min!=59){//if del ultimo minuto
                        seg=0;//segundos en cero 
                        min++;//incremento de minutos
                    }else{//incremento  horas
                            hora=0;
                            min=0;
                            seg=0;         
                    }
                }               
            System.out.println("0"+hora+":0"+min+":"+seg);//Impresión del cronometro
            sleep(999);//Dormir el hilo casi un segundo
            }             
        } catch (InterruptedException e) {
             
        }                 
 } 
    //Clase main con la ejecución del hilo
 public static void main(String[] args) {
        Cronometro crono=new Cronometro(); 
        crono.start();         
    }
}
