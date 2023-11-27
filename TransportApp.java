import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    Message message;
    Scanner sc;

    public TransportApp() {
        // ezek azok a class-ok amikbe belemennek a file-ok
        // FileRead customerList = new FileRead("customer");
        LinkedList<Customer> customers = new LinkedList<>();
        // for (int i = 1; i < customerList.getListSize(); i++) {
        //     customers.add(new Customer(customerList.splitLine(i, customerList.token)));
        // }
        // // Customer[] customers;
        // FileRead itemList = new FileRead("item");
        // // Item[] items;
        // FileRead orderList = new FileRead("order");
        // // Order[] orders;
        // FileRead users = new FileRead("user");
        sc = new Scanner(System.in);
    }

    // public void loginMenu() {
    //     Login login = new Login();
    //     login.setUserNameTyped(userList.getRow(userList.token, 0));
    //     login.setUserPasswordTyped(userList.getRow(userList.token, 1)[login.line]);
    //     User user = new User(userList.splitLine(login.line, userList.token));
    // }

    private char getChar(){
        while (true){
            System.out.println("Adj meg egy karatert!");
            String input = sc.next();
            if (input.length() == 1) {
                return input.charAt(0);
            }
            else{
                System.out.println("Ez nem egy karakter!");
            }
        }
    }

    private void printMenu(String title,Map<String,String> menupoints){
        System.out.println("===="+title+"====");
        for (Map.Entry<String, String> entry : menupoints.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("");
    } 
    

    public void startMenu() {
        printMenu("Főmenü",Map.of(
            "c", "Futár",
            "d", "Depo",
            "a", "Admin",
            "w", "Raktár",
            "f", "Felhhasználó",
            "k", "Kilépés"
        ));
        // user = fileManager.login();
        //if (roleCheck(role)) {
        //    if(role != "customer"){
        //        System.out.print("Input your username");
        //        String username = sc.nextLine();
        //        // fileManager.login() -> User | UserNotFoundException
        //        if (login(username)) {
        boolean exit = false;
        while(!exit){
            switch (getChar()) {
                case 'c':
                    currierMenu();
                    break;
                case 'a':
                    adminMenu();
                    break;
                case 'd':
                    depoMenu();
                    break;
                case 'w':
                    // warehouseMenu();
                    break;
                case 'f':
                    customerMenu();
                    break;
                case 'k':
                    exit = true;
                    break;
                default:
                    System.out.println("Nincs ilyen menüpont!");
                    break;
            }
        }
    }
    

    // private boolean login(String username) {
    //     return false;
    // }
    // private boolean roleCheck(String role) {
    //     return true;
    // }

    private void customerMenu(){
        printMenu("Customer",Map.of(
            // "1", "Csomaghoz tartozó üzenetek lekérdezése",
            "1", "Megérkezett rendelés visszaigazolása",
            "2", "Termék kosárba rakása",
            "3", "Termék törlése a kosárból",
            "4", "Kosár tartalmának megtekintése",
            "5", "Kosár tartalmának megrendelése"
        ));
        switch (getChar()) {
            // félrerakva továbbiakig
            // case '1':
            //     printMenu("Csomaghoz tartozó üzenetek lekérdezése",Map.of(
            //     ));
            //     System.out.print("Csomagazonosito: ");
            //     String csomagAzon = sc.nextLine();
            //     message.getMessage(csomagAzon); //TODO
            //     break;
            case '1':
                printMenu("Megérkezett rendelés visszaigazolása",Map.of(
                ));
                System.out.print("Csomagazonosito: ");
                Item.listItems(); //TODO
                switch (getChar()) { 
                }
            case '2':
                printMenu("Termék kosárba rakása",Map.of(
                ));
                Item.listItems(); //TODO
                switch (getChar()) { 
                }
            case '3':
                printMenu("Termék kosárba rakása",Map.of(
                ));
                Item.listItems(); //TODO
                break;
            default:

            case '4':
                printMenu("Kosár tartalmának megtekintése",Map.of(
                ));
                Item.listCart(); /
                break;                break;
        }

    }

    private void currierMenu(){
        System.out.print("Csomagazonosito: ");
        String csomagAzon = sc.nextLine();
        printMenu("currier",Map.of(
            "1", "Csomag felvétele",
            "2", "Csomag kiszállítva",
            "3", "Csomag kiszállítása sikertelen",
            "4", "Kosár tartalmának megtekintése",
            "5", "Kosár tartalmának megrendelése",
            "6", "Megérkezett rendelés visszaigazolása"
        ));
        //menüpontok:
        //- megrendelés lekérdezés
        //  |- Sikeres / sikertelen kézbesítés
                    // System.out.println("=====Courier=====");
                    // System.out.println("r - Raktárhoz megérkeztem, csomag felvétele");
                    // System.out.println("y - Csomagot kiszállítottam");
                    // System.out.println("n - Csomagot nem sikerült kiszállítani");
                    // System.out.print("k - kilépés: ");
        System.out.println("\n\n=====Currier=====");
        
        System.out.println("1. Csomagkezeles");
        System.out.println("2. Kezbesitve");
        String menupont = sc.nextLine();
        // switch (menupont) {
        //     case "1":
                
        //         order.track(csomagAzon,"Futar");
        //         order.updateTrack();
        //     break;
        //     case "2":
        //         order.track(csomagAzon,"Kezbesitve");
        //         order.updateTrack();
        //     break;
        // }

    }
    private void depoMenu(){
        System.out.println("\n\n=====Depo=====");
        System.out.print("Csomagazonosito: ");
        String csomagAzon = sc.nextLine();
        order.getState(csomagAzon);
        // order.track(csomagAzon,"Depo");
        // order.updateTrack();

    }
    private void adminMenu(){
                    // System.out.println("=====Admin=====");
                    // System.out.println("f - futár felvétele");
                    // System.out.println("r - raktár felvétele");
                    // System.out.println("t - termék módosítás");
        System.out.println("\n\n=====Admin=====");
        System.out.println("1. Megrenelesek");
        System.out.println("2. Termeklista");
        System.out.println("3. Termek hozzaad");
        System.out.println("4. Termek torol");
        String menupont = sc.nextLine();
        // switch (menupont) {
        //     case "1":
        //         order.listOrders();
        //         break;
        //     case "2":
        //         i.listItems();
        //         break;
        //     case "3":
        //         i.addItem();
        //         break;
        //     case "4":
        //         System.out.print("IemId: ");
        //         int itemId = Integer.parseInt(sc.nextLine());
        //         //removeItem(itemId);
        //         break;
        //     default:
        //         break;
        // }
    }


}
