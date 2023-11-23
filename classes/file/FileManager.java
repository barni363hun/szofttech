package classes.file;
import java.util.*;
import java.io.*;

class FileManager implements FileRead, FileWrite {
    public LinkedList<String> getUsers(String filename) {
        FileRead list = new FileRead(filename);
        list.getList();
        return list;
    }

    setUsers(){
        
    }
}