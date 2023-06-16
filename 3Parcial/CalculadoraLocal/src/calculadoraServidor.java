import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface calculadoraServidor extends Remote {
    
    void registro(salidaCliente cliente) throws RemoteException;
    void operacion(String operacion) throws RemoteException;
    void imprimirOperacion(String operacion) throws RemoteException;

    ArrayList<String> saveOpetation(ArrayList<String> calculatorHistory) throws RemoteException;
    void cleanGobalVariables() throws RemoteException; 
    String[] separarNumeros(ArrayList<String> operacion) throws RemoteException;
    String[] separarOperadores(ArrayList<String> operacion) throws RemoteException;
    boolean esNumero(String str) throws RemoteException;
    boolean esOperador(String str) throws RemoteException;
}
