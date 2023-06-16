
import java.util.ArrayList;

public class ClienteHilo {
    public static final int MAX_HILOS = 10;
    public static final String host = "localhost";
    
    public static void main(String[] args) {
        ArrayList<Thread> clientes = new ArrayList<>();
        for(int i = 0;i < 5;i++){
            clientes.add(new HiloClienteParlante(i));
        }
        
        for(Thread thread: clientes){
            thread.start();
        }
    }
}
