package classes;
import classes.users.*;

import java.io.FileReader;

import classes.*;
import classes.file.*;


public class Item {
    public void listItems(){
        FileRead fileread = new FileRead("item");
        int listahossz = fileread.getListSize();

        for (int i = 0; i < listahossz; i++){
            String tempLine = fileread.getLine(i);
            System.out.println(tempLine);
        }

    }
}
