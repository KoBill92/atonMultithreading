import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActorThread implements Runnable{
    private String name;
    public  Map<Integer, Map<String,String>> map = new ConcurrentHashMap<>();
    private int lineCounter = 1;

    public ActorThread(String name) {
        this.name = name;
    }

    public Map<Integer,Map<String,String>> HashMapFromFile() {
        BufferedReader br;
        int count = 1;
        try {
            File file = new File("src/main/resources/actorsLines.txt");
            br = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = br.readLine()) != null) {
                Map<String, String> newMap = new HashMap<>();
                //split line by line
                String[] keyAndValue = line.split(":");

                String key = keyAndValue[0].trim();
                String value = keyAndValue[1].trim();

                if (!key.equals("") && !value.equals("")) {
                    newMap.put(key, value);
                    map.put(count, newMap);
                    count++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public void run() {
        while (true) {
            try {
                HashMapFromFile();
                String line = getNextLine(name);
                actorSpeech(name, line);
                Thread.sleep(1000);

            } catch (Exception e) {
                System.exit(0);
            }
        }
    }

    public synchronized void actorSpeech(String name, String line) {
        if (name != null && line != null) {
            switch (name) {
                case "Chandler":
                    System.out.println(name + ": " + line);
                    break;
                case "Joey":
                    System.out.println(name + ": " + line);
                    break;
                case "Phoebe":
                    System.out.println(name + ": " + line);
                    break;
                case "Monica":
                    System.out.println(name + ": " + line);
                    break;

            }
        }

    }

    public synchronized String getNextLine(String name) {
        Map<String, String> actorMapping = map.get(lineCounter);
        lineCounter++;
        return actorMapping.get(name);
    }
}
