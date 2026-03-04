package jarvis;

import java.io.FileWriter;

public class MemoryManager {

    private static final String FILE = "memory.json";

    public static void save(String data) {

        try(FileWriter writer = new FileWriter(FILE,true)){
            writer.write(data + "\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
