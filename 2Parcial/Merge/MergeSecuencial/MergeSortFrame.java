package MergeSecuencial;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MergeSortFrame extends javax.swing.JFrame {

    private JPanel panel;
    private JLabel etiqueta;
    private JTextField textField;
    private JButton boton, boton2, boton3, boton4;
    private JTextArea textArea;

    public MergeSortFrame() {
        super("Merge Sort");

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        etiqueta = new JLabel("Ingrese la cantidad de números:");
        etiqueta.setBounds(60,5,300,30);
        add(etiqueta);
        

        textField = new JTextField(20);
        textField.setBounds(95,35,150,30);
        add(textField);
        
      

        boton = new JButton("MergeSort");
        boton.setBounds(350,20,140,30);
        add(boton);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(textField.getText());
                int[] arr = generarArreglo(n);
                textArea.setText("Arreglo original: " + Arrays.toString(arr) + "\n");
                mergeSort(arr, 0, n - 1);
                textArea.append("Arreglo ordenado: " + Arrays.toString(arr) + "\n");
            }
        });
        
        
        boton2 = new JButton("Limpiar");
        boton2.setBounds(350,50,140,30);
        add(boton2);
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                textArea.setText("");
                textField.setText("");
               
            }
        });
        
        boton3 = new JButton("Executor Services");
        boton3.setBounds(350,85,140,30);
        add(boton3);
        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
               
            }
        });
        
        
        boton4 = new JButton("Forkjoin");
        boton4.setBounds(350,120,140,30);
        add(boton4);
        boton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
               
            }
        });
      

        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(30,90,280,150);
        add(scrollPane);
       
        add(panel);

        setSize(520, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static int[] generarArreglo(int n) {
        int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = (int) (Math.random() * 100);
    }
    return arr;
}

public static void main(String[] args) {
    MergeSortFrame frame = new MergeSortFrame();
}
}