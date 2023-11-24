package classes.file;

import java.util.*;
import java.io.File;
import java.io.*;
import classes.file.*;

// public class FileManager extends FileRead, FileWrite {


//     public String[][] getUsers(String filename) {
//         FileRead list = new FileRead(filename);
//         list.getTable();
//         return list;
//     }

//     void setUsers(){
        
//     }
// }


public class FileManager extends FileRead {

    private FileWrite fileWrite;

    public FileManager(FileWrite fileWrite) {
        this.fileWrite = fileWrite;
    }

    public String[][] getUsers(String filename) {
        FileRead list = new FileRead(filename);
        list.getTable();
        return list;
    }

    void setUsers(){
        // Use fileWriter here
    }
}