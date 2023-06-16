import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class clienteRMI {
    
    public static void main(String[] args) {

        try {
            
            // String nombre = JOptionPane.showInputDialog("ingresa tu nombre");
            Registry rmi1 = LocateRegistry.getRegistry("192.168.100.32", 3050);

            calculadoraServidor servidor = (calculadoraServidor) rmi1.lookup("Chat");
            Calculadora calculadora = new Calculadora(servidor);
            calculadora.setVisible(true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
