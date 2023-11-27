import java.util.*;
import classes.file.*;
import classes.roles.*;
import classes.Order;
import classes.classes_from_data.*;

public class TransportApp {

    LinkedList<Customer> customers;
    LinkedList<Item> items;
    LinkedList<Order> orders;
    LinkedList<User> users;

    Scanner sc;

    public TransportApp() {
        // ezek azok a class-ok amikbe belemennek a file-ok
        FileRead customerList = new FileRead("customer");
        LinkedList<Customer> customers = new LinkedList<>();
        for (int i = 1; i < customerList.getListSize(); i++) {
            customers.add(new Customer(customerList.splitLine(i, customerList.token)));
        }
        // Customer[] customers;
        FileRead itemList = new FileRead("item");
        // Item[] items;
        FileRead orderList = new FileRead("order");
        // Order[] orders;
        FileRead users = new FileRead("user");
        sc = new Scanner(System.in);
    }

    public void loginMenu() {
        Login login = new Login();
        login.setUserNameTyped(userList.getRow(userList.token, 0));
        login.setUserPasswordTyped(userList.getRow(userList.token, 1)[login.line]);
        User user = new User(userList.splitLine(login.line, userList.token));
    }

    public void startMenu() {
        /*
         * System.out.println("=====Főmenü=====");
         * System.out.println("Szerepkor:");
         * System.out.println("c - Futar");
         * System.out.println("d - Depo");
         * System.out.println("a - Admin");
         * System.out.println("w - Raktar");
         * System.out.println("Enter - Felhasznalo");
         * System.out.println("");
         */

        String input = sc.next();
        if (input.length() > 0) {
            char character = input.charAt(0);

            switch (character) {
                case 'c':
                    System.out.println("=====Courier=====");
                    System.out.println("r - Raktárhoz megérkeztem, csomag felvétele");
                    System.out.println("y - Csomagot kiszállítottam");
                    System.out.println("n - Csomagot nem sikerült kiszállítani");
                    System.out.print("k - kilépés: ");
                    break;
                case 'a':
                    System.out.println("=====Admin=====");
                    System.out.println("f - futár felvétele");
                    System.out.println("r - raktár felvétele");
                    System.out.println("t - termék módosítás");
                    break;
                case 'd': // Depo
                    // depoMenu();
                    break;
                case 'w': // Depo
                    // warehouseMenu();
                    break;
                default:
                    // customerMenu();
                    break;
            }
        } else {
            // TODO throw exception
            System.out.println("No character entered.");
        }

    }
    
    public void startMenu(){
       
       //Demo

        i.listItems();
    // fileManager.saveData(Customer[] customerList, Depot[] depotList);

    // select your role...
    // Enter your User Name:
    // ha kell akkor pwd
    System.out.println("Szerepkor:");    
    System.out.println("c - Futar");
    System.out.println("d - Depo");    
    System.out.println("a - Admin");     
    System.out.println("w- Raktar");    
    System.out.println("Enter - Felhasznalo");
    System.out.println("");    

   

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
                    case "a": //admin 
                        // currentUser = ...
                        adminMenu();
                        break;
                    case "d": //Depo 
                        depoMenu();
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
                 
        //(csomagAzon, "Futar");
                System.out.print("Csomagazonosito: ");
                String csomagAzon = sc.nextLine();
                order.track(csomagAzon,"user");

                break;
            case "2":
                //item.listItems();
                System.out.println("=====Szallitasi adatok=====");
                System.out.print("Nev: ");
                String nev = sc.nextLine();
                System.out.print("Cim ");
                String cim = sc.nextLine();
                System.out.print("Telefonszam: ");
                String tel = sc.nextLine();
                order.makeTrackNum(nev, cim, tel);
                break;
            default:
                break;
        }

    }

    private void currierMenu(){
        //menüpontok:
        //- megrendelés lekérdezés
        //  |- Sikeres / sikertelen kézbesítés
        System.out.println("\n\n=====Currier=====");
        System.out.print("Csomagazonosito: ");
        String csomagAzon = sc.nextLine();
        System.out.println("1. Csomagkezeles");
        System.out.println("2. Kezbesitve");
        String menupont = sc.nextLine();
        switch (menupont) {
            case "1":
                
                order.track(csomagAzon,"Futar");
                order.updateTrack();
            break;
            case "2":
                order.track(csomagAzon,"Kezbesitve");
                order.updateTrack();
            break;
        }

    }
    private void depoMenu(){
        //menüpontok:
        //- Csomaglekerdezes
        //- Statuszmodositas
        System.out.println("\n\n=====Depo=====");
        System.out.print("Csomagazonosito: ");
        String csomagAzon = sc.nextLine();
        //(csomagAzon, "Futar");
        order.track(csomagAzon,"Depo");
        order.updateTrack();

    }
    private void adminMenu(){
        System.out.println("\n\n=====Admin=====");
        System.out.println("1. Megrenelesek");
        System.out.println("2. Termeklista");
        System.out.println("3. Termek hozzaad");
        System.out.println("4. Termek torol");
        String menupont = sc.nextLine();
        switch (menupont) {
            case "1":
                order.listOrders();
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
