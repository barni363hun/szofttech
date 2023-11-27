import java.util.*;
import classes.file.*;
import classes.roles.*;
import classes.classes_from_data.*;

public class TransportApp {

//ezek azok a class-ok amikbe belemennek a file-ok
	FileRead customerList = new FileRead("customer");
    LinkedList<Customer> customers = new LinkedList<>();
    for(int i=1;i<customerList.getListSize();i++){
    customers.add(new Customer(customerList.splitLine(i, customerList.token)));
    }
    //Customer[] customers;
	FileRead itemList = new FileRead("item");
    //Item[] items;
    FileRead orderList = new FileRead("order");
    //Order[] orders;
    FileRead userList = new FileRead("user");
    User user;

//Ezek a szerep class-ok
    Admin admin;
    Courier courier;
    User_Customer customer;
    Depot depot;
    Warehouse warehouse;

    public void loginMenu(){
        Login login=new Login();
	    login.setUserNameTyped(userList.getRow(userList.token,0));
	    login.setUserPasswordTyped(userList.getRow(userList.token,1)[login.line]);
        User user=new User(userList.splitLine(login.line, userList.token));
    }

    public void startMenu(){
/*
    System.out.println("Szerepkor:");    
    System.out.println("c - Futar");
    System.out.println("d - Depo");    
    System.out.println("a - Admin");     
    System.out.println("w - Raktar");    
    System.out.println("Enter - Felhasznalo");
    System.out.println("");
*/

                    switch (user.getUserType()) {
                    case 'c': //courier
                        Courier.Menu();
                        break;   
                    case 'a': //admin 
                        // currentUser = ...
                        //adminMenu();
                        break;
                    case 'd': //Depo 
                        //depoMenu();
                        break;
                    case 'w': //Depo 
                        //warehouseMenu();
                        break;
                    default:
                        //customerMenu();
                        break;
                }
    }

}
