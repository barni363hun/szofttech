package classes.file;
import java.util.*;
import java.io.*;

class ReadFile {
    static final String token = ",";
    static final String filePath = "../data/database.";
    static final String fileExtension = ".csv";
    LinkedList<String> lineList = new LinkedList<String>();

public FileWrite(String filename){
try{
FileWriter writer = new FileWriter(this.filePath+filename+this.fileExtension);
writer.write();
writer.close();}
catch{e.printStackTrace();}
}
}