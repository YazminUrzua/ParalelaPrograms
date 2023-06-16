
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorHilo {
    public static final int port = 8080;
    
    public static void main(String[] args) {
        ServerSocket ss;
        
        System.out.println("Inicializando...");
        try{
            ss = new ServerSocket(port);
            System.out.println("\tOK");
            int idSession = 0;
            while(true){
                Socket socket;
                socket = ss.accept();
                System.out.println("Nueva conexion entranate: " + socket);
                ((ServidorMultiParlante) new ServidorMultiParlante(socket, idSession)).start();
                idSession++;
            }
        } catch(IOException e){
            System.out.println("Exception: " + e);
        }
    }
}
