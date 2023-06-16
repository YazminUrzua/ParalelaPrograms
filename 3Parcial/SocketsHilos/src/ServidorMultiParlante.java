import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServidorMultiParlante extends Thread{
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSession;
    
    public ServidorMultiParlante(Socket socket, int id){
        this.socket = socket;
        this.idSession = id;
        try{
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch(IOException e){
            System.out.println("Exception: " + e);
        }
    }
    
    public void desconectar(){
        try{
            socket.close();
        } catch(IOException e){
            System.out.println("Exception: " + e);
        }
    }
    
    @Override
    public void run(){
        String accion = "";
        try{
            accion = dis.readUTF();
            if(accion.equals("hola")){
                System.out.println("El cliente con idSession: " + this.idSession + " saluda");
                dos.writeUTF("adios");
            }
        } catch(IOException e){
            System.out.println("Exception: " + e);
        }
        desconectar();
    }
}
