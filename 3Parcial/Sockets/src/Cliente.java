import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static final int port = 8080;
    public static final String host = "localhost";
    
    public static void main(String[] args) throws IOException {
        System.out.println("address: " + host);
        Socket socket = new Socket(host, port);
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            salida.println("Usuario: Hola server soy tu cliente");
            String str = entrada.readLine();
            System.out.println(str);
            salida.println("FIN");
        }finally{
            System.out.println("Cerrando...");
            socket.close();
        }
    }
}
