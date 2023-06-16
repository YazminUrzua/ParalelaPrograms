public class hilo {
    
    public static void main(String[] args) {
        hola hilo = new hola();
        hilo.start();

        // Ejecutar el hilo durante 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}