import java.util.concurrent.TimeUnit;

public class SingleLaneBridgeTester
{
    public static void main(String[] args)
    {
        final Bridge bridge = new Bridge();  //constructs bridge calls semaphore from bridge
        Thread South = new Thread(new Runnable()  //constructs South bound running thread
        {
            @Override
            public void run()//method that is implemented in a Runnable interface
            {
                while(true)
                {
                    Vehicle vehicle = new Vehicle(bridge);  //constructs new vehicle from Vehicle class, sets to vehicle and uses bridge parameter
                    Thread a = new Thread(vehicle);  //vehicle object becomes thread object
                    vehicle.setName("South Vehicle: "+a.getId());  //sets vehicle name to South Vehicle and gets the thread ID
                    a.start();  //starts the thread
                    try  //try catch block
                    {    //performs a Thread sleep for a given time
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException ex)
                    {  //prints the stack trace of the Exception to System.err.  Helps diagnose Exception.
                        ex.printStackTrace();
                    }
                }
            }
        });
        Thread North = new Thread(new Runnable() //constructs North bound running thread
        {
            @Override
            public void run()//method that is implemented in a Runnable interface
            {
                while(true)
                {
                    Vehicle vehicle = new Vehicle(bridge);  //constructs new vehicle from Vehicle class, sets to vehicle and uses bridge parameter
                    Thread a = new Thread(vehicle);  //vehicle object becomes thread object
                    vehicle.setName("North Vehicle:  "+a.getId());  //sets vehicle name to North Vehicle and gets the thread ID
                    a.start();  //starts thread
                    try
                    {   //performs a Thread sleep for a given time
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException ex)
                    {  //prints the stack trace of the Exception to System.err.  Helps diagnose Exception.
                        ex.printStackTrace();        
                    }
                }
            }
        });
        South.start();  //starts south thread
        North.start();  //starts north thread
    }
}

