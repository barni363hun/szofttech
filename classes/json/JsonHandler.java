package classes.json;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class JsonHandler<T extends JsonDataClass>{
    public LinkedList<T> list = new LinkedList<T>();
    protected String fileName;

    //delete:
    // list.removeIf(item -> item.id == id);

    public JsonHandler(String fileName) {
        this.fileName = fileName;
        loadFromJsonFile();
    }
    
    protected void loadFromJsonFile(){};

    public int getBiggestId(){
        int max = 0;
        for (T t : list) {
            if (t.id > max) {
                max = t.id;
            }
        }
        return max;
    }

    public void writeAllToJsonFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<List<Object>> transformedList = transformList(list);
            String json = gson.toJson(transformedList);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<List<Object>> transformList(List<T> TList) {
        List<List<Object>> transformedList = new ArrayList<>();
        for (T t : TList) {
            transformedList.add(t.getArrayList());
        }
        return transformedList;
    }
    
    public void printItems() {
        System.out.println("All items:");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);

        System.out.println(json);
    }
    
}
