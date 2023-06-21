import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
           System.setProperty("java.rmi.server.hostname", "192.168.100.9");
            Registry rm1 = LocateRegistry.createRegistry(2010);

            rm1.rebind("Buscador", (Remote) new ImplementacionBuscador());
            System.out.println("Servidor Activo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
