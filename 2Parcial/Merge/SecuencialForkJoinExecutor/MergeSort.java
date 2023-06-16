/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecuencialForkJoinExecutor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author yaz
 */
public class MergeSort extends javax.swing.JFrame  implements ActionListener{
    //Components and array
    int array[];
    int arrayAux[];
    int widthFrame = 1000;
    int heightFrame = 400;
    JButton buttonMerge, buttonFork, buttonExecutor, buttonClean;
    JLabel timeMerge, timeFork,timeExecutor,arrayLong;
    TextField longArray;
    JTable tabla;
    JScrollPane scrollArray, scrollMerge, scrollFork, scrollExecutor;


    public static void main(String[] args) {
        MergeSort frame = new MergeSort();
       
        //Boton Generar array dinamico
        JButton buttonGenerateArray = new JButton("Generar Arreglo");
        buttonGenerateArray.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int sizeArray = Integer.parseInt(frame.longArray.getText().toString());
               
                frame.array = new int[sizeArray];
                frame.arrayAux = new int[sizeArray];
                frame.generateArray(frame.array, sizeArray);
                //Create a graphic interface with a cicle for just for the array lenght
                JTextArea textAreaArray = new JTextArea();
                textAreaArray.setText("");
                for(int i=0; i<frame.array.length;i++)
                textAreaArray.append(frame.array[i] + ", ");
                frame.scrollArray.setViewportView(textAreaArray);
                frame.setVisible(true);                
            }
        });
        buttonGenerateArray.setBounds(680, 30, 200, 30);
        frame.add(buttonGenerateArray);
       
        //Boton buttonMerge
        JButton buttonMerge = new JButton("Secuencial");
        buttonMerge.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
                for(int i=0; i<frame.array.length; i++){
                    frame.arrayAux[i] = frame.array[i];
                }
                
                long inicioTiempo = System.nanoTime();
                new mergeSortSecuencial(frame.arrayAux);
                long finTiempo = System.nanoTime();

                System.out.println("\nTiempo de ejecución en ms = " + (finTiempo-inicioTiempo));

                JTextArea textAreaArray = new JTextArea();
                textAreaArray.setText("");
                for(int i=0; i<frame.arrayAux.length;i++)
                    textAreaArray.append(frame.arrayAux[i] + ", ");
                frame.scrollMerge.setViewportView(textAreaArray);
                frame.setVisible(true);
                frame.timeMerge.setText("Tiempo de ejecución Secuencial (ms): " + (finTiempo-inicioTiempo)/1000);
                //frame.timeMerge.setText("Tiempo de ejecución Secuencial (ms): " + (finTiempo-inicioTiempo)/1000);
            
            }
        });
        buttonMerge.setBounds(115, 170, 100, 30);
        frame.add(buttonMerge);
       
        //Button ForkJoin
        JButton buttonFork = new JButton("Fork/Join");
        buttonFork.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                for(int i=0; i<frame.array.length; i++){
                    frame.arrayAux[i] = frame.array[i];
                }
            
                long inicioTiempo = System.nanoTime();
                ForkJoinPool pool = ForkJoinPool.commonPool();
                pool.invoke(new ForkJoin(frame.arrayAux, 0, frame.arrayAux.length-1));                
                long finTiempo = System.nanoTime();
               
                JTextArea textAreaArray = new JTextArea();
                textAreaArray.setText("");
                for(int i=0; i<frame.arrayAux.length;i++)
                textAreaArray.append(frame.arrayAux[i] + ", ");
                frame.scrollFork.setViewportView(textAreaArray);
                frame.setVisible(true);
                frame.timeFork.setText("Tiempo de ejecución ForkJoin (ms): " + (finTiempo-inicioTiempo)/1000);
            }
        });
        buttonFork.setBounds(430, 170, 100, 30);
        frame.add(buttonFork);
       
         //Boton ExecutorService
        JButton buttonExecutor = new JButton("ExecutorService");
        buttonExecutor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
               
                for(int i=0; i<frame.array.length; i++){
                    frame.arrayAux[i] = frame.array[i];
                }
              
                long inicioTiempo = System.nanoTime();
                ExecutorService executor = Executors.newCachedThreadPool();//se generan subprocesos para ayudar con el funcionamiento
                executor.execute(new executorService(frame.arrayAux, 0, frame.arrayAux.length-1));
                //Ejecuta el comando dado en algún momento en el futuro.(creo que es lo de las promesas)
                
                executor.shutdown();//Las tareas enviadas anteriormente, pero no se aceptarán tareas nuevas.
                //No espera a que las tareas enviadas anteriormente completen la ejecución.
                //while(!executor.isTerminated()){}
                long finTiempo = System.nanoTime();
               

                JTextArea textAreaArray = new JTextArea();
                textAreaArray.setText("");
                for(int i=0; i<frame.arrayAux.length;i++)
                textAreaArray.append(frame.arrayAux[i] + ", ");
                frame.scrollExecutor.setViewportView(textAreaArray);
                frame.setVisible(true);
                frame.timeExecutor.setText("Tiempo de ejecución ExcecutorService (ms): " + (finTiempo-inicioTiempo)/1000);
            }
        });
        buttonExecutor.setBounds(705, 170, 150, 30);
        frame.add(buttonExecutor);  
    
    
    //Button ForkJoin
        JButton buttonClean = new JButton("Limpiar");
        buttonClean.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.timeMerge.setText("");
               frame.timeExecutor.setText("");
               frame.timeFork.setText("");
               frame.longArray.setText("");
               frame.scrollExecutor.setViewportView(null);
               frame.scrollMerge.setViewportView(null);
               frame.scrollFork.setViewportView(null);
               frame.scrollArray.setViewport(null);
               
            }
        });
      
        buttonClean.setBounds(430, 290, 100, 30);
        frame.add(buttonClean);  
                }
    
    
    public MergeSort(){
        setSize(widthFrame,heightFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("MergeSort");
        setResizable(false);
        this.setLayout(null);
       
        //Merge secuencial
        arrayLong = new JLabel("Ingrese cantidad de números del array: ");
        arrayLong.setBounds(10, 35, 300, 30);
        this.add(arrayLong);
     
       //Longitud de array
        longArray = new TextField();
        longArray.setBounds(350, 35, 300, 30);
        this.add(longArray);    
       
        //Array generado
        JLabel label1 = new JLabel("Arreglo Global");
        label1.setBounds(450, 70, 150, 20);
        this.add(label1);
        scrollArray = new JScrollPane();
        scrollArray.setBounds(10, 100, 920, 40);
        this.add(scrollArray);
       
        //Secuencial
        timeMerge = new JLabel("Tiempo de ejecución Merge (ms): ");
        timeMerge.setBounds(10, 250, 300, 30);
        this.add(timeMerge);
        scrollMerge = new JScrollPane();
        scrollMerge.setBounds(10, 210, 300, 40);
        this.add(scrollMerge);
       
        //Fork/Join
        timeFork = new JLabel("Tiempo de ejecución ForkJoin (ms): ");
        timeFork.setBounds(320, 250, 300, 30);
        this.add(timeFork);
        scrollFork = new JScrollPane();
        scrollFork.setBounds(320, 210, 300, 40);
        this.add(scrollFork);        
       
        //ExecutorService
        timeExecutor = new JLabel("Tiempo de ejecución ExcecutorService (ms): ");
        timeExecutor.setBounds(630, 250, 350, 30);
        this.add(timeExecutor);
        scrollExecutor = new JScrollPane();
        scrollExecutor.setBounds(630, 210, 300, 40);
        this.add(scrollExecutor);      
       
        this.setVisible(true);
    }
   
   public void generateArray(int []array, int limite){
        for(int i=0; i<array.length; i++){
            array[i] = (int) (Math.random()*100);
        }
    }
   

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}