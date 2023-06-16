import java.rmi.RemoteException;

public class CalculatorC implements CalculatorInterfaz {
    public float add(float num1, float num2) throws RemoteException {
        return num1 + num2;
    }

    public float minus(float num1, float num2) throws RemoteException {
        return num1 - num2;
    }

    public float multiply(float num1, float num2) throws RemoteException {
        return num1 * num2;
    }

    public float divide(float num1, float num2) throws RemoteException {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new RemoteException("Cannot divide by zero.");
        }
    }
}
