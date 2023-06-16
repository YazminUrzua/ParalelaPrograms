import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class implementacionClienteCalculadora extends UnicastRemoteObject implements salidaCliente, Runnable {
    
    calculadoraServidor servidor;
    public String nombre = null;

    implementacionClienteCalculadora(String nombre, calculadoraServidor servidor) throws RemoteException {

        this.nombre = nombre;
        this.servidor = servidor;
        servidor.registro(this);
    }

    @Override
    public void operacionCliente(String operacion) throws RemoteException {

        System.err.println(operacion);
    }

    @Override
    public void run() {

        /*while(true) {
            String operacionCliente = calculadora.getPantallaString();

            if(calculadora.isEnterClick()) {

                try {
                    // servidor.mensaje(nombre + ": " + operacionCliente);
                    System.out.println(nombre + ": " + operacionCliente);
                    calculadora.setEnterClick(false);

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Al parecer hubo un error: " + e.getMessage());
                }
            }
        }*/
    }
}
