class hola extends Thread {

     private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hola Mundo");
            try {
                Thread.sleep(1000); // Esperar 1 segundo entre cada impresión
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}}