import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;

public class ImplementacionBuscador extends UnicastRemoteObject implements buscadorServidor {
    public ArrayList<salidaCliente> clientes;
    public int contador = 0;
    public ArrayList<String> operacionesUsuarios = new ArrayList<String>();
    public String texto;
    public String textoUnido = "";
    public String textoAnidado = "";
    public String textoUsuarios = "";

    ArrayList<String> textoA;
    ArrayList<String> textoB;

    public ImplementacionBuscador() throws RemoteException {

        clientes = new ArrayList<salidaCliente>();
    }

    public void escrito(String texto) throws RemoteException {
        int a = 0;
        while (a < clientes.size()) {
            clientes.get(a++).agregadoCliente(texto);
        }
    }

    public void registroCliente(salidaCliente cliente) throws RemoteException {
        clientes.add(cliente);
    }

    public void imprimirTextoUnido() throws RemoteException {
        System.out.println(textoUnido);
    }

    public void limpiarVariables() throws RemoteException {
        contador = 0;
        texto = "";
        textoUnido = "";
        contador = 0;
        operacionesUsuarios = null;
        textoAnidado = null;
        textoUsuarios = null;
    }

    public ArrayList<String> separarPalabras(String texto) {
        String[] palabrasArray = texto.split(" ");
        ArrayList<String> palabrasList = new ArrayList<>(Arrays.asList(palabrasArray));
        return palabrasList;
    }

    public boolean esPalabra(String str) {
        return !str.isEmpty();
    }

    public String saveText(ArrayList<String> texto) throws RemoteException {
        contador++;

        String bandera = "";
        boolean esperarEscrito = true;

        if (contador == 1) {
            bandera = "A";
            textoUsuarios = String.join(" ", texto);
            // textoUnido = String.join("", texto);
        } else if (contador == 2) {
            bandera = "B";
            // textoUnido += String.join("", texto);
            textoUsuarios += " " + String.join(" ", texto);
        }

        while (esperarEscrito) {
            System.out.println("Input: " + bandera + " Texto unido: " + textoUsuarios);

            if (contador == 2) {

                /*for (String listaPalabras : operacionesUsuarios) {
                    textoAnidado += listaPalabras;
                }
                ArrayList<String> palabras = separarPalabras(textoAnidado);*/

                if (bandera.equals("A")) {
                    // textoA = palabras;
                    System.out.println("Input " + bandera + ": " + textoUsuarios);
                    return textoUsuarios;
                }

                if (bandera.equals("B")) {
                    // textoB = textoA;
                    System.out.println("Input " + bandera + ": " + textoUsuarios);
                    return textoUsuarios;
                }

                contador = 0;
                esperarEscrito = false;

            }
        }

        return textoUsuarios;
    }
}