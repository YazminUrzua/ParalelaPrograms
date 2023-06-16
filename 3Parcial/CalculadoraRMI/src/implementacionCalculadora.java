import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class implementacionCalculadora extends UnicastRemoteObject implements calculadoraServidor {
    
    public ArrayList<salidaCliente> clientes;
    public int contador = 0;
    public ArrayList<String> operacionesUsuarios = new ArrayList<String>();
    public String[] numeros;
    public String[] operaciones;
    public String operacionCompleta = "";

    public CalculatorInterfaz calculatorInterfaz = new CalculatorC();

    public implementacionCalculadora() throws RemoteException {

        clientes = new ArrayList<salidaCliente>();
    }

    @Override
    public void operacion(String operacion) throws RemoteException {
        int a = 0;
        while(a < clientes.size()) {
            clientes.get(a++).operacionCliente(operacion);
        }
    }

    @Override
    public void registro(salidaCliente cliente) throws RemoteException {
        this.clientes.add(cliente);
    }

    @Override
    public void imprimirOperacion(String operacion) throws RemoteException {
        
        System.out.println(operacion);
    }

    @Override
    public ArrayList<String> saveOpetation(ArrayList<String> operacion) throws RemoteException {
        
        contador++;

        String bandera = "";
        boolean esperarOperacion = true;

        if(contador == 1) {

            bandera = "A";
            // System.out.println("Cliente " + bandera + ": " + operacion);
            operacionesUsuarios = operacion;
            
        } else if(contador == 2) {

            bandera = "B";
            // System.out.println("Cliente " + bandera + ": " + operacion);
            operacionesUsuarios.addAll(operacion);
        }

        // System.out.println("Cliente: " + bandera + " Operacion actualizada: " + operacionesUsuarios);
        // System.out.println("Contador: " + contador);



        while(esperarOperacion) {

            System.out.println("Input: " + bandera + " ArrayList: " + operacionesUsuarios);

            // System.out.println("Tamaño Array numeros: " + numeros.length);
            // System.out.println("Tamaño Array operaciones: " + operaciones.length);

            if(contador == 2) {
                
                separarNumeros(operacionesUsuarios);
                operaciones = separarOperadores(operacionesUsuarios);

                if(bandera == "A") {
                    
                    System.out.println("Input " + bandera + ": " + numeros[0] + operaciones[0] + numeros[1]);
                    ArrayList<String> operacionA = new ArrayList<String>();
                    operacionA.add(numeros[0]);
                    operacionA.add(operaciones[0]);
                    operacionA.add(numeros[1]);
                    return operacionA;
                }
    
                if(bandera == "B") {

                    System.out.println("Input " + bandera + ": " + numeros[0] + operaciones[1] + numeros[1]);
                    ArrayList<String> operacionB = new ArrayList<String>();
                    operacionB.add(numeros[0]);
                    operacionB.add(operaciones[1]);
                    operacionB.add(numeros[1]);
                    return operacionB;
                }

                esperarOperacion = false;
                contador=0;
            }
        } 

        return new ArrayList<String>();
    }

    @Override
    public void cleanGobalVariables() throws RemoteException {

        contador = 0;
        operacionesUsuarios = null;
        numeros = null;
        operaciones = null;
        operacionCompleta = null;
    }

    @Override
    public String[] separarNumeros(ArrayList<String> operacion) {
        ArrayList<String> numeros = new ArrayList<>();

        for (String elemento : operacion) {
            if (esNumero(elemento)) {
                numeros.add(elemento);
            }
        }

        String[] arrayNum = numeros.toArray(new String[0]);
        return arrayNum;
    }

    @Override
    public boolean esNumero(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String[] separarOperadores(ArrayList<String> lista) {
        ArrayList<String> operadores = new ArrayList<>();

        for (String elemento : lista) {
            if (esOperador(elemento)) {
                operadores.add(elemento);
            }
        }

        String[] arrayOperadores = operadores.toArray(new String[0]);
        return arrayOperadores;
    }

    @Override
    public boolean esOperador(String str) {
        return str.matches("[+\\-*/]");
    }
}
