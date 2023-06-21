import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI {
    
    public static void main(String[] args) {

        try {
            
          
            // String nombre = JOptionPane.showInputDialog("ingresa tu nombre");
            Registry rmi1 = LocateRegistry.getRegistry("192.168.100.9", 2010);

            buscadorServidor servidor = (buscadorServidor) rmi1.lookup("Buscador");
           // Calculadora calculadora = new Calculadora(servidor);
            Principal principal1 =  new Principal(servidor);
            principal1.setVisible(true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
