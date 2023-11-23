import java.util.Scanner;
import classes.users.*;

public class TransportApp {
    
    Scanner sc;
    Customer[] customerList;
    Depot[] depotList;
    User user;
    FileManager fileManager;
    // customerList
    // User currentUser=null;

    public TransportApp() {
        sc = new Scanner(System.in);
    }

    public TransportApp(FileManager fileManager) {
        this.fileManager = fileManager;
        fileManager.getUsers();
        customerList = fileManager.getCustomers();
    }

    public void startMenu(){

    fileManager.saveData(Customer[] customerList, Depot[] depotList);

    // select your role...
    // Enter your User Name:
    // ha kell akkor pwd
    System.out.print("Type in your role:");    
    System.out.print("c / a / u / d");

    user = fileManager.login();
    String role = sc.nextLine();
    if (roleCheck(role)) {
        if(role != "customer"){
            System.out.print("Input your username");
            String username = sc.nextLine();
            // fileManager.login() -> User | UserNotFoundException
            if (login(username)) {
                switch (role) {
                    case "c": //courier
                       courierMenu();
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
                        break;
                }
            }

        } else {
            customerMenu();
        }
    } else {
        System.out.println("User found!");
    }
    System.out.print("Enter your User Name: ");

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
        //- list items
        System.out.println("=====Customer=====");
        System.out.println("1. Csomagkovetes");
        System.out.println("2. Rendeles");
        int menupont = Integer.parseInt(sc.nextLine());
        switch (menupont) {
            case 1:
                //listMegrendelesek();
                break;
            case 2:
                //getItems();
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
        int csomagAzon = Integer.parseInt(sc.nextLine());
        //setKeeper(csomagAzon, "Futar");
        //getCsomagById();

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
        int menupont = Integer.parseInt(sc.nextLine());
        switch (menupont) {
            case 1:
                //listMegrendelesek();
                break;
            case 2:
                //getItems();
                break;
            case 3:
                //addItem();
                break;
            case 4:
                //removeItem();
                break;
            default:
                break;
        }
    }
}
