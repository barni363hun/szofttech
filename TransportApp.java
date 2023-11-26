import java.util.*;
import classes.file.*;
import classes.roles.*;
import classes.classes_from_data.*;

public class TransportApp {

    FileRead userList =new FileRead("user");
	FileRead customerList =new FileRead("customer");
	FileRead itemList =new FileRead("item");
    FileRead orderList =new FileRead("order");

    User user;
//Ezek a szerep class-ok
    Admin admin;
    Courier courier;
    Customer customer;
    Depot depot;
    Warehouse warehouse;

//ezek azok a class-ok amikbe belemennek a file-ok
//customer list és role névütközés?
    Customer[] customers;
    Item[] items;
    Order[] orders;
    
 
/*
    //Message[] messages;

    Scanner sc;

    public TransportApp(FileManager _fileManager) {
        this.fileManager = _fileManager;
    }*/

    public void startMenu(){
/*
    System.out.println("Szerepkor:");    
    System.out.println("c - Futar");
    System.out.println("d - Depo");    
    System.out.println("a - Admin");     
    System.out.println("w - Raktar");    
    System.out.println("Enter - Felhasznalo");
    System.out.println("");
/*/


    Login login=new Login();
	login.setUserNameTyped(userList.getRow(userList.token,0));
	login.setUserPasswordTyped(userList.getRow(userList.token,1)[login.line]);

    User user=new User(userList.splitLine(login.line, userList.token));    String role = user.
Typre
                    switch (role) {
                    case "c": //courier
                        Courier.courierMenu();
                        break;   
                    case "a": //admin 
                        // currentUser = ...
                        //adminMenu();
                        break;
                    case "d": //Depo 
                        //depoMenu();
                        break;
                    case "w": //Depo 
                        //warehouseMenu();
                    break;
                    default:
                        //customerMenu();
                        break;
                }
    }
}
