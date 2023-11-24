package classes.file;
import java.util.*;
import java.io.*;

class ReadFile {
    static final String token = ",";
    static final String filePath = "../data/database.";
    static final String fileExtension = ".csv";
    LinkedList<String> lineList = new LinkedList<String>();

    public void FileWrite() {

    }

    public void writeToFile(String filename, String content){
        try{
            FileWriter writer = new FileWriter(this.filePath+filename+this.fileExtension);
            writer.write(content);
            writer.close();
        }
        catch (Exception e) { e.printStackTrace(); }
    }
}