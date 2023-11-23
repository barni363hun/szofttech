package classes.file;

import java.util.*;
import java.io.*;
import classes.file.FileRead;

public class FileManager{
    public LinkedList<String> getUsers(String filename) {
        FileRead list = new FileRead(filename);
        list.getList();
        return ;
    }

    void setUsers(){
        
    }
}