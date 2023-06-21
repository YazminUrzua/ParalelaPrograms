import java.rmi.Remote;
import java.rmi.RemoteException;

public interface salidaCliente extends Remote {
    
    void agregadoCliente(String mensaje) throws RemoteException;
}
