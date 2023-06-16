import java.rmi.Remote;
import java.rmi.RemoteException;

public interface salidaCliente extends Remote {
    
    void operacionCliente(String mensaje) throws RemoteException;
}
