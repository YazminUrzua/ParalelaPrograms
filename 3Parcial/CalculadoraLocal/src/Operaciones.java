import java.util.Arrays;

import javax.swing.JOptionPane;

public class Operaciones implements InterfazOperaciones {
    
    @Override
    public String operacion(String operacion) {

        String salidaPantalla = operacion;
        String[] numeros = separarNumeros(operacion);
        String[] operadores = separarOperadores(operacion);

        return hacerOperacion(numeros, operadores);
    }

    public String[] separarNumeros(String operacion) {

        String[] numeros = operacion.split("[+\\-x/]");
        return numeros;
    }

    public String[] separarOperadores(String operacion) {
        
        String[] operadores = operacion.split("\\d+");
        
        // Eliminamos los elementos vacíos generados por la separación de números
        operadores = Arrays.stream(operadores)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        return operadores;
    }

    @Override
    public String hacerOperacion(String[] numeros, String[] operaciones) {
        
        int cantidadNumeros = numeros.length;
        double resultadoOperacion = 0;

        for(int i = 0; i < cantidadNumeros; i++) {

            try {
                
                if(i == 0) {    // Establesemos el primer valor de la operacion
                    resultadoOperacion = Double.parseDouble(numeros[i]);
                }

                else if(i <= cantidadNumeros - 1) {
                    switch(operaciones[i - 1]) {
                        case "+":
                            resultadoOperacion += Double.parseDouble(numeros[i]);
                            break;

                        case "-":
                            resultadoOperacion -= Double.parseDouble(numeros[i]);
                            break;

                        case "x":
                            resultadoOperacion *= Double.parseDouble(numeros[i]);
                            break;

                        case "/":
                            resultadoOperacion /= Double.parseDouble(numeros[i]);
                            break;

                        default:
                            break;
                    }
                }
            } 
            catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Surgio un error en la operacion, error: " + e.getMessage());
                return "Syntax Error";
            }
        }

        return " = " + resultadoOperacion;
    }
}
