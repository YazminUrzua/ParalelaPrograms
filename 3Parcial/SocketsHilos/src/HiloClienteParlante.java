
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloClienteParlante extends Thread{
    protected Socket sk;
    protected DataInputStream dis;
    protected DataOutputStream dos;
    private int id;
    
    public HiloClienteParlante(int id){
        this.id = id;
    }
    
    @Override
    public void run(){
        try{
            sk = new Socket("127.0.0.1",8080);
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());
            System.out.println(id + " envia saludos");
            dos.writeUTF("hola");
            String res = " ";
            res = dis.readUTF();
            System.out.println(id + " Servidor devuelve saludo: " + res);
            dis.close();
            dos.close();
            sk.close();
        } catch(IOException e){
            System.out.println("Exception: " + e);
        }
    }
}
