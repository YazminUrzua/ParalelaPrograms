import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidorRMI {
    
    public static void main(String[] args) {

        try {
            //Para hacerla local solo es cambiar la ip por localHost
            System.setProperty("java.rmi.server.hostname", "192.168.100.32");
            Registry rm1 = LocateRegistry.createRegistry(3050);

            rm1.rebind("Chat", (Remote) new implementacionCalculadora());
            System.out.println("Servidor Activo");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
