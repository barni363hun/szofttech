import java.util.List;
import java.util.Scanner;
import classes.users.*;
import classes.*;
import classes.file.*;

public class TransportApp {
    
    Item i = new Item();
    Order order;

    User user;
    Admin admin;
    Courier[] couriers;
    Customer[] customers;
    Depot[] depots;
    Warehouse warehouse;
    Item[] items;
    Message[] messages;
    Order[] orders;
    
    FileManager fileManager;
    Item item;
    
    Scanner sc;

    public TransportApp() {
        sc = new Scanner(System.in);
    }

    public TransportApp(FileManager _fileManager) {
        this.fileManager = _fileManager;
        
        // fileManager.getUsers();
        // customerList = fileManager.getCustomers();
    }

    public void startMenu(){
       
       //Demo

        i.listItems();
    // fileManager.saveData(Customer[] customerList, Depot[] depotList);

    // select your role...
    // Enter your User Name:
    // ha kell akkor pwd
    System.out.print("Type in your role:");    
    System.out.print("c / a / u / d");

    // user = fileManager.login();
    String role = sc.nextLine();
    //if (roleCheck(role)) {
    //    if(role != "customer"){
    //        System.out.print("Input your username");
    //        String username = sc.nextLine();
    //        // fileManager.login() -> User | UserNotFoundException
    //        if (login(username)) {
                switch (role) {
                    case "c": //courier
                        currierMenu();
                        break;
                    case "d": //depo
                        // currentUser = ...
                        // courierMenu();
                        break;    
                    case "a": //admin 
                        // currentUser = ...
                        adminMenu();
                        break;
                    default:
                    customerMenu();
                        break;
                }
        //   }

        //} else {
        //    customerMenu();
       // }
 //   } else {
  //      System.out.println("User found!");
  //  }
  //  System.out.print("Enter your User Name: ");

    }
    

    private boolean login(String username) {
        return false;
    }
    private boolean roleCheck(String role) {
        return true;
    }

    private void customerMenu(){
        //menüpontok:
        //- add to cart
        //- remove from cart
        //- list itemsa
        System.out.println("=====Customer=====");
        System.out.println("1. Csomagkovetes");
        System.out.println("2. Rendeles");
        String menupont = sc.nextLine();
        switch (menupont) {
            case "1":
                 int azon = Integer.parseInt(sc.nextLine());
                //getMegrendeles(azon);
                break;
            case "2":
                item.listItems();
                break;
            default:
                break;
        }

    }

    private void currierMenu(){
        //menüpontok:
        //- megrendelés lekérdezés
        //  |- Sikeres / sikertelen kézbesítés
        System.out.println("=====Currier=====");
        System.out.print("Csomagazonosito: ");
        String csomagAzon = sc.nextLine();
        //(csomagAzon, "Futar");
        order.track(csomagAzon,"Ceg");
        order.updateTrack();;

    }
    private void depoMenu(){
        //menüpontok:
        //- Csomaglekerdezes
        //- Statuszmodositas
        System.out.println("=====Depo=====");
        System.out.print("Csomagazonosito: ");
        int csomagAzon = Integer.parseInt(sc.nextLine());
        //setKeeper(csomagAzon, "Depo");

    }
    private void adminMenu(){
        System.out.println("=====Admin=====");
        System.out.println("1. Megrenelesek");
        System.out.println("2. Termeklista");
        System.out.println("3. Termek hozzaad");
        System.out.println("4. Termek torol");
        String menupont = sc.nextLine();
        switch (menupont) {
            case "1":
                //listMegrendelesek();
                break;
            case "2":
                i.listItems();
                break;
            case "3":
                //addItem();
                break;
            case "4":
                System.out.print("IemId: ");
                int itemId = Integer.parseInt(sc.nextLine());
                //removeItem(itemId);
                break;
            default:
                break;
        }
    }
}
