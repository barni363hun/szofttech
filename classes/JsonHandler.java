package classes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {
    private ArrayList<Object[]> items = new ArrayList<Object[]>();
    private String fileName;

    public JsonHandler(String fileName) {
        this.fileName = fileName;
        loadFromJsonFile();
    }

    public int size(){
        return items.size();
    }

    private void loadFromJsonFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            Gson gson = new Gson();
            items = gson.fromJson(content.toString(), ArrayList.class);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Creating a new one.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeAllToJsonFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(items);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public <T> void add(T c) {
        items.add(Utils.transformsToObjArr(c));
        writeAllToJsonFile();
    }

    public ArrayList<Object[]> readAll() {
        return items;
    }

    public Object[] readById(int id) {
        for (Object[] obj : items) {
            // Assuming the first element in each array is the ID
            int itemId = (int) obj[0];
            if (itemId == id) {
                return obj;
            }
        }
        return null;
    }

    private void updateByIdObjArr(int id, Object[] newObj) {
        for (int i = 0; i < items.size(); i++) {
            // Assuming the first element in each array is the ID
            int itemId = (int) items.get(i)[0];
            if (itemId == id) {
                items.set(i, newObj);
                writeAllToJsonFile();
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    public <T> void updateById(int id, T c) {
        updateByIdObjArr(id, Utils.transformsToObjArr(c));
    }

    public void deleteById(int id) {
        items.removeIf(obj -> (int) obj[0] == id);
        writeAllToJsonFile();
    }
    
    public void printItems() {
        System.out.println("All items:");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(items);

        System.out.println(json);
    }
    
}
