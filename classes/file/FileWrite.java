package classes.file;
import java.io.*;
import java.util.*;

public class FileWrite {
static final String token=",";
static final String filePath="../data/database.";
static final String fileExtension=".csv";

public FileWrite(LinkedList listToWrite){
//LinkedList<String>lineList=new LinkedList<String>();
try{
FileWriter writer = new FileWriter(this.filePath+filename+this.fileExtension);
for(int i=0;i<classToWrite.size();i++){
writer.write(listToWrite);}
writer.close();}
catch{e.printStackTrace();}
}
}