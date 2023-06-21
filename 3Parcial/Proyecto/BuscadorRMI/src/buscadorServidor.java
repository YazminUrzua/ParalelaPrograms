import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface buscadorServidor extends Remote{
    void escrito(String texto) throws RemoteException;
    void registroCliente(salidaCliente cliente) throws RemoteException;
    void imprimirTextoUnido() throws RemoteException;
    void limpiarVariables() throws RemoteException;
    //String[] separarPalabras(String texto) throws RemoteException;
    boolean esPalabra(String str) throws RemoteException;
    public ArrayList<String> separarPalabras(String texto) throws RemoteException;
    public String saveText(ArrayList<String> buscadorHistory) throws RemoteException;
    
}
