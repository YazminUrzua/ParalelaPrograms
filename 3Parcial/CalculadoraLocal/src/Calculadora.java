import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Calculadora  extends javax.swing.JFrame {
    
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;                         // Botones para los numeros
    public JButton btnMas, btnMenos, btnMultiplpicacion, btnDivision, btnIgual, btnClean;               // Botones para las iperaciones

    private JPanel panel;                                                                               // Lienzo de la calculadora

    private JTextArea taPantalla, taPantallaSalida;                                                                       // Pantalla de la calculadora
    private JScrollPane scrollPantalla, scrollPantallaSalida;

    // Calculator management
    private CalculatorInterfaz calculatorInterfaz;
    private ArrayList<String> calculatorHistory;

    private calculadoraServidor servidor;

    // Constructor de la calculadora
    public Calculadora(calculadoraServidor servidor) throws RemoteException {
        
        this.servidor = servidor;
        this.calculatorHistory = new ArrayList<String>();
        this.calculatorInterfaz = new CalculatorC();

        this.setSize(275, 370);
        setLocationRelativeTo(null);                                                                  // Centrar la ventana al centro de la pantalla

        setDefaultCloseOperation(EXIT_ON_CLOSE);                                                        // Cerrar proceso de la ventana
    
        initComponents();
    
        btn0();
        btn1();
        btn2();
        btn3();
        btn4();
        btn5();
        btn6();
        btn7();
        btn8();
        btn9();
        
        btnMas();
        btnMenos();
        btnMultiplpicacion();
        btnDivision();
        btnClean();
        btnIgual();

        setVisible(true);
    }

    // Inicializamos los componentes;
    public void initComponents() {

        panel = new JPanel();                                                                           // Añadimos el JPanel como lienzo
        panel.setLayout(null);
        this.getContentPane().add(panel); 

        taPantalla = new JTextArea();

        taPantalla.setBounds(10, 10, 255, 70);
        taPantalla.setOpaque(false);                             // Establecer fuente más grande
        taPantalla.setEditable(false);

        scrollPantalla = new JScrollPane(taPantalla);
        scrollPantalla.setBounds(10, 10, 255, 70);

        panel.add(scrollPantalla);

        taPantallaSalida = new JTextArea();

        taPantallaSalida.setBounds(205, 210, 60, 40);
        taPantallaSalida.setOpaque(false);                             // Establecer fuente más grande
        taPantallaSalida.setEditable(false);

        scrollPantallaSalida = new JScrollPane(taPantallaSalida);
        scrollPantallaSalida.setBounds(10, 250, 255, 80);

        panel.add(scrollPantallaSalida);

        ordenarBotones();
    }

    // Pintamos los numeros en pantalla
    private void btn0() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                numberPressed("0");
            }
        };
        btn0.addActionListener(listener);
    }

    private void btn1() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                numberPressed("1");
            }
        };
        btn1.addActionListener(listener);
    }

    private void btn2() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                numberPressed("2");
            }
        };
        btn2.addActionListener(listener);
    }

    private void btn3() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                numberPressed("3");
            }
        };
        btn3.addActionListener(listener);
    }

    private void btn4() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                numberPressed("4");
            }
        };
        btn4.addActionListener(listener);
    }

    private void btn5() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                numberPressed("5");
            }
        };
        btn5.addActionListener(listener);
    }

    private void btn6() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                numberPressed("6");
            }
        };
        btn6.addActionListener(listener);
    }

    private void btn7() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                numberPressed("7");
            }
        };
        btn7.addActionListener(listener);
    }

    private void btn8() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                numberPressed("8");
            }
        };
        btn8.addActionListener(listener);
    }

    private void btn9() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                numberPressed("9");
            }
        };
        btn9.addActionListener(listener);
    }

    // Operaciones de los botones
    private void btnClean() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    servidor.cleanGobalVariables();
                    
                    clearCalculatorHistory();
                    taPantalla.setText("");

                } catch (RemoteException e) {
                    
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
                }
            }
        };
        btnClean.addActionListener(listener);
    }

    private void btnMas() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                
                operationPressed("+");

                try {
                    calculatorHistory = servidor.saveOpetation(calculatorHistory);
                    updateInputOutputScreens();

                } catch (RemoteException e) {
                    
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
                }
            }
        };
        btnMas.addActionListener(listener);
    }

    private void btnMenos() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                operationPressed("-");
                
                try {
                    calculatorHistory = servidor.saveOpetation(calculatorHistory);
                    updateInputOutputScreens();
                    
                } catch (RemoteException e) {
                    
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
                }
            }
        };
        btnMenos.addActionListener(listener);
    }

    private void btnMultiplpicacion() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                operationPressed("*");
                
                try {
                    calculatorHistory = servidor.saveOpetation(calculatorHistory);
                    updateInputOutputScreens();
                    
                } catch (RemoteException e) {
                    
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
                }
            }
        };
        btnMultiplpicacion.addActionListener(listener);
    }

    private void btnDivision() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                operationPressed("/");
                
                try {
                    calculatorHistory = servidor.saveOpetation(calculatorHistory);
                    updateInputOutputScreens();
                    
                } catch (RemoteException e) {
                    
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
                }
            }
        };
        btnDivision.addActionListener(listener);
    }

    private void btnIgual() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                doCalculation();
            }
        };
        btnIgual.addActionListener(listener);
    }

    private void clearCalculatorHistory() {
        calculatorHistory = new ArrayList<String>();
    }

    private void operationPressed(String operation) {
        if (calculatorHistory.isEmpty()) {
            return;
        } else {

            int size = calculatorHistory.size();
            int lastIndex = size - 1;
            String recent = calculatorHistory.get(lastIndex);

            if (recent.equals("+") || recent.equals("-") || recent.equals("*") || recent.equals("/")) {
                calculatorHistory.set(lastIndex, operation);
            } else {
                calculatorHistory.add(operation);
            }
        };

        updateInputOutputScreens();
    }

    private void updateInputOutputScreens() {
        String resultString = "";
        for (String s : calculatorHistory) {
            resultString += s + " ";
        }

        taPantalla.setText(resultString);
        taPantallaSalida.append("-> " + resultString + "\n");

    }

    private void updateInputOutputScreens(String resultString) {
        taPantalla.setText(resultString);
        taPantallaSalida.append(resultString + "\n");
    }

    private void numberPressed(String number) {

        if (calculatorHistory.isEmpty()) {
            calculatorHistory.add(number);
        } else {

            int size = calculatorHistory.size();
            int lastIndex = size - 1;
            String recent = calculatorHistory.get(lastIndex);

            if (recent.equals("+") || recent.equals("-") || recent.equals("*") || recent.equals("/")) {
                calculatorHistory.add(number);
            } else {
                calculatorHistory.set(lastIndex, recent + "" + number);
            }
        };

        updateInputOutputScreens();
    }

    private void doCalculation() {

        ArrayList<String> _calculatorHistory = (ArrayList<String>) calculatorHistory.clone();

        if (_calculatorHistory.size() == 0) {
            taPantallaSalida.append("No input given\n");
            return;
        };

        try {
            // MDAS (Multiply, divide, addition, subtract)
            String[] operations = {"*", "/", "+", "-"};

            for (int i = 0; i < operations.length; i++) {
                String currentOperation = operations[i];
                int nextIndex = _calculatorHistory.indexOf(currentOperation);

                while (nextIndex != -1) {

                    // Get the two numbers for the operation (operation - 1, operation + 1)
                    if (nextIndex != _calculatorHistory.size() - 1) {
                        float num1 = Float.parseFloat(_calculatorHistory.get(nextIndex - 1));
                        float num2 = Float.parseFloat(_calculatorHistory.get(nextIndex + 1));
                        float result = 0;


                        // Perform appropriate calculation
                        switch (currentOperation) {
                            case "*":
                                result = calculatorInterfaz.multiply(num1, num2);
                                break;

                            case "/":
                                result = calculatorInterfaz.divide(num1, num2);
                                break;

                            case "+":
                                result = calculatorInterfaz.add(num1, num2);
                                break;

                            case "-":
                                result = calculatorInterfaz.minus(num1, num2);
                                break;
                        }

                        // Replace with resulting value
                        _calculatorHistory.remove(nextIndex + 1);
                        _calculatorHistory.remove(nextIndex);
                        _calculatorHistory.set(nextIndex - 1, Float.toString(result));
                    } else {
                        _calculatorHistory.remove(nextIndex);
                    };

                    nextIndex = _calculatorHistory.indexOf(currentOperation);
                }
            }

            updateInputOutputScreens(_calculatorHistory.get(0));
            clearCalculatorHistory();
        } catch (RemoteException e) {
            System.out.println("Client error: " + e);
        }
    }

    // Funcion para ordenar y dar estilo a los botones
    public void ordenarBotones() {

        btn0 = new JButton();
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btnMas = new JButton();
        btnMenos = new JButton();
        btnMultiplpicacion = new JButton();
        btnDivision = new JButton();
        btnIgual = new JButton();
        btnClean = new JButton();

        btn0.setText("0");
        btn1.setText("1");
        btn2.setText("2");
        btn3.setText("3");
        btn4.setText("4");
        btn5.setText("5");
        btn6.setText("6");
        btn7.setText("7");
        btn8.setText("8");
        btn9.setText("9");
        btnMas.setText("+");
        btnMenos.setText("-");
        btnMultiplpicacion.setText("x");
        btnDivision.setText("/");
        btnIgual.setText("=");
        btnClean.setText("C");

        btnClean.setBounds(205, 210, 60, 40);
        btnDivision.setBounds(10, 90, 60, 40);

        btn7.setBounds(75, 90, 60, 40);
        btn8.setBounds(140, 90, 60, 40);
        btn9.setBounds(205, 90, 60, 40);
        btnMultiplpicacion.setBounds(10, 130, 60, 40);

        btn4.setBounds(75, 130, 60, 40);
        btn5.setBounds(140, 130, 60, 40);
        btn6.setBounds(205, 130, 60, 40);
        btnMenos.setBounds(10, 170, 60, 40);

        btn1.setBounds(75, 170, 60, 40);
        btn2.setBounds(140, 170, 60, 40);
        btn3.setBounds(205, 170, 60, 40);
        btnMas.setBounds(10, 210, 60, 40);

        btn0.setBounds(75, 210, 60, 40);
        btnIgual.setBounds(140, 210, 60, 40);

        panel.add(btnClean);
        panel.add(btnDivision);

        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btnMultiplpicacion);

        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btnMenos);
        
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btnMas);

        panel.add(btn0);
        panel.add(btnIgual);
    }
}
