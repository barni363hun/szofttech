package classes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class JsonHandler<T extends JsonDataClass> implements AutoCloseable {
    public LinkedList<T> list = new LinkedList<T>();
    protected String fileName;

    //delete:
    // list.removeIf(item -> item.id == id);

    public JsonHandler(String fileName) {
        this.fileName = fileName;
        loadFromJsonFile();
    }
    
    protected void loadFromJsonFile(){};

    @Override
    public void close() {
        writeAllToJsonFile();
    }

    private void writeAllToJsonFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(list);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void updateById(int id) {
    //     T t = items.set(id,);
    //     t = 
    //             items.add(t);
    //             writeAllToJsonFile();
    //         }
    //     }
    //     System.out.println("Item with ID " + id + " not found.");
    //     // TODO exception
    // }
    
    public void printItems() {
        System.out.println("All items:");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);

        System.out.println(json);
    }
    
}
