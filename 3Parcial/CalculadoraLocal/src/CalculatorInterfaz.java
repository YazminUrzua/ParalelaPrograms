import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface CalculatorInterfaz extends Remote {
    float add(float num1, float num2) throws RemoteException;
    float minus(float num1, float num2) throws RemoteException;
    float multiply(float num1, float num2) throws RemoteException;
    float divide(float num1, float num2) throws RemoteException;
}
