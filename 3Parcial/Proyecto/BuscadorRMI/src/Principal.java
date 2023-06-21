import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends javax.swing.JFrame implements ActionListener {
    private JLabel lblEntrada, lblSalida;
    private JLabel lblResultado, lblResultado2, lblResultado3;
    JTextArea txtEntrada, txtSalida;
    JTextField txtResultado, txtResultadoF, txtResultadoE;
    private JButton btnSecuencial;
    private JButton btnExecutor;
    private JButton btnForkJoin;
    private JButton btnClean;
    private JButton btnAdd;
    private JPanel panel;

    // Search management
    private ArrayList<String> buscadorHistory;

    private buscadorServidor servidor;

    public Principal(buscadorServidor servidor) throws RemoteException {
        this.servidor = servidor;
        this.buscadorHistory = new ArrayList<String>();

        setSize(700, 550);
        setTitle("Buscador de Palabras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        lblEntrada = new JLabel("Ingresa el texto:");
        lblEntrada.setBounds(10, 10, 300, 20);
        panel.add(lblEntrada);

        txtEntrada = new JTextArea();
        txtEntrada.setBounds(10, 30, 480, 150);
        panel.add(txtEntrada);

        lblSalida = new JLabel("Texto unido:");
        lblSalida.setBounds(10, 360, 300, 20);
        panel.add(lblSalida);

        txtSalida = new JTextArea();
        txtSalida.setBounds(10, 380, 480, 100);
        panel.add(txtSalida);
        txtSalida.setEditable(false);

        lblResultado = new JLabel("Resultado secuencial:");
        lblResultado.setBounds(10, 200, 200, 20);
        panel.add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(10, 220, 480, 20);
        txtResultado.setEditable(false);
        panel.add(txtResultado);

        lblResultado2 = new JLabel("Resultado ForkJoin:");
        lblResultado2.setBounds(10, 250, 200, 20);
        panel.add(lblResultado2);

        txtResultadoF = new JTextField();
        txtResultadoF.setBounds(10, 280, 480, 20);
        txtResultadoF.setEditable(false);
        panel.add(txtResultadoF);

        lblResultado3 = new JLabel("Resultado Executor:");
        lblResultado3.setBounds(10, 300, 200, 20);
        panel.add(lblResultado3);

        txtResultadoE = new JTextField();
        txtResultadoE.setBounds(10, 330, 480, 20);
        txtResultadoE.setEditable(false);
        panel.add(txtResultadoE);

        btnSecuencial = new JButton("Buscar (Secuencial)");
        btnSecuencial.setBounds(500, 40, 170, 30);
        btnSecuencial.addActionListener(this);
        panel.add(btnSecuencial);

        btnForkJoin = new JButton("Buscar (ForkJoin)");
        btnForkJoin.setBounds(500, 80, 170, 30);
        btnForkJoin.addActionListener(this);
        panel.add(btnForkJoin);

        btnExecutor = new JButton("Buscar (Executor)");
        btnExecutor.setBounds(500, 120, 170, 30);
        btnExecutor.addActionListener(this);
        panel.add(btnExecutor);

        btnAdd = new JButton("Agregar (unir)");
        btnAdd.setBounds(500, 150, 170, 30);
        btnAdd.addActionListener(this);
        panel.add(btnAdd);

        btnClean = new JButton("Limpiar");
        btnClean.setBounds(500, 180, 170, 30);
        btnClean.addActionListener(this);
        panel.add(btnClean);

        add(panel);
        setVisible(true);
    }

    /*
     * public static void main(String[] args) {
     * new Principal();
     * }
     */

    private void ejecutarSecuencial() {
        String texto = txtEntrada.getText();
        String palabra = JOptionPane.showInputDialog(this, "Ingresa la palabra a buscar:");
        if (palabra == null || palabra.isEmpty()) {
            return;
        }

        long startTime = System.nanoTime(); // inicio del tiempo de ejecución

        int index = texto.indexOf(palabra);
        int count = 0;
        while (index != -1) {
            count++;
            texto = texto.substring(index + palabra.length());
            index = texto.indexOf(palabra);
        }

        long endTime = System.nanoTime();// fin del tiempo de ejecución
        long tiempoEjecucion = (endTime - startTime) / 1000; // tiempo total de ejecución

        txtResultado.setText("Se encontraron " + count + " resultados para la palabra \"" + palabra
                + "\". Tiempo de ejecución: " + tiempoEjecucion + " ms.");
    }

    private void ejecutarForkJoin() {
        String texto = txtEntrada.getText();
        String palabra = JOptionPane.showInputDialog(this, "Ingresa la palabra a buscar:");
        if (palabra == null || palabra.isEmpty()) {
            return;
        }

        long startTime = System.nanoTime(); // tiempo de inicio de la búsqueda

        BuscadoAr buscador = new BuscadoAr(texto, palabra, 100);
        ForkJoinPool pool = new ForkJoinPool();
        int count = pool.invoke(buscador);

        long endTime = System.nanoTime(); // tiempo de finalización de la búsqueda
        long duration = (endTime - startTime) / 10000; // duración de la búsqueda en milisegundos

        txtResultadoF.setText("Se encontraron " + count + " resultados para la palabra \"" + palabra
                + "\". Tiempo de ejecución: " + duration + " ms.");
    }

    private void ejecutarExecutorService() throws ExecutionException {
        String texto = txtEntrada.getText();
        String palabra = JOptionPane.showInputDialog(this, "Ingresa la palabra a buscar:");
        if (palabra == null || palabra.isEmpty()) {
            return;
        }

        long inicio = System.nanoTime(); // Tiempo inicial

        // Divide el texto en bloques más grandes (frases)
        String[] frases = texto.split(" ");

        // Crea un ThreadPoolExecutor con 4 hilos
        int numHilos = Runtime.getRuntime().availableProcessors(); // Usa el número de núcleos disponibles en la máquina
        ExecutorService executor = new ThreadPoolExecutor(numHilos, numHilos, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        // Crea una lista para almacenar los resultados
        List<Future<Integer>> resultados = new ArrayList<>();

        // Itera por cada frase y crea un Callable para buscar la palabra
        for (String frase : frases) {
            Callable<Integer> buscador = new BuscadorCallable(frase, palabra);
            Future<Integer> resultado = executor.submit(buscador);
            resultados.add(resultado);
        }

        // Cierra el ExecutorService
        executor.shutdown();

        // Espera a que todos los hilos terminen
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Suma todos los resultados
        int count = 0;
        for (Future<Integer> resultado : resultados) {
            try {
                count += resultado.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        long fin = System.nanoTime(); // Tiempo final
        long duracion = (fin - inicio) / 10000; // Duración en milisegundos

        txtResultadoE.setText("Se encontraron " + count + " resultados para la palabra \"" + palabra
                + "\". Tiempo de ejecución: " + duracion + " ms.");
    }

    private void clean() {
        txtEntrada.setText("");
        txtResultadoE.setText("");
        txtResultadoF.setText("");
        txtResultado.setText("");

        try {
            servidor.limpiarVariables();
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
        }

    }

    private void add() {

        try {
            /*
             * doTextUnion();
             * updateInputOutputScreens();
             */

            buscadorHistory.add(txtEntrada.getText().toString());
            JOptionPane.showMessageDialog(null, "buscadorHistory: " + buscadorHistory);

            String textosUnidos = servidor.saveText(buscadorHistory);
            // String textoSalida = String.join(" ", textosUnidos);
            txtSalida.setText(textosUnidos);
            txtEntrada.setText(textosUnidos);

            clearBuscadorHistory();
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
        }
    }

    private void updateInputOutputScreens() {
        String resultString = "";
        for (String s : buscadorHistory) {
            resultString += s + " ";
        }

        txtEntrada.setText(resultString);
        txtSalida.append("-> " + resultString + "\n");

    }

    private void updateInputOutputScreens(String resultString) {
        txtEntrada.setText(resultString);
        txtSalida.append(resultString + "\n");
    }

    private void doTextUnion() {
        ArrayList<String> textHistory = (ArrayList<String>) buscadorHistory.clone();

        if (textHistory.size() == 0) {
            txtSalida.append("No input given\n");
            return;
        }

        try {
            StringBuilder sb = new StringBuilder();

            for (String text : textHistory) {
                sb.append(text);
            }

            String mergedText = sb.toString();
            servidor.escrito(mergedText);

            clearBuscadorHistory();
        } catch (RemoteException e) {
            System.out.println("Client error: " + e);
        }
    }

    private void clearBuscadorHistory() {
        buscadorHistory = new ArrayList<String>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSecuencial) {
            ejecutarSecuencial();
        } else if (e.getSource() == btnForkJoin) {
            ejecutarForkJoin();
        } else if (e.getSource() == btnAdd) {
            add();
        } else if (e.getSource() == btnClean) {
            clean();
        } else if (e.getSource() == btnExecutor) {

            try {
                ejecutarExecutorService();
            } catch (ExecutionException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
