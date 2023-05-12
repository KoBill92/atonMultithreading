import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {

        Thread chandler = new Thread(new ActorThread("Chandler"));
        Thread Joey = new Thread(new ActorThread("Joey"));
        Thread Monica = new Thread(new ActorThread("Monica"));
        Thread Phoebe = new Thread(new ActorThread("Phoebe"));
        Thread Rachel = new Thread(new ActorThread("Rachel"));
        Thread Ross = new Thread(new ActorThread("Ross"));

        chandler.start();
        Joey.start();
        Monica.start();
        Phoebe.start();
        Rachel.start();
        Ross.start();

    }
}
