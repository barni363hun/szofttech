package classes.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import com.google.gson.Gson;
import classes.Message;
public class MessageHandler extends JsonHandler<Message>{

    public MessageHandler(String fileName) {
        super(fileName);
    }

    @Override
    protected void loadFromJsonFile() {
     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
    
            Gson gson = new Gson();
            LinkedList<ArrayList> a = gson.fromJson(content.toString(), LinkedList.class); // Change the type here
            // System.out.println(a);
            for (ArrayList t : a) {
                list.add(new Message(t));
            }
            // System.out.println("--------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Creating a new one.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}