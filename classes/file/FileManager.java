package classes.file;
import java.util.*;
import java.io.*;

class FileManager extends FileRead, FileWrite {
    public String[][] getUsers(String filename) {
        FileRead list = new FileRead(filename);
        list.getTable();
        return list;
    }

    setUsers(){
        
    }
}
