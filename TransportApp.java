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
    LinkedList<Courier> couriers;

    Message message;
    Scanner sc;
    Order order;

    public TransportApp() {
        
        customers.add(new Customer([""]))
        // ezek azok a class-ok amikbe belemennek a file-ok
        // FileRead customerList = new FileRead("customer");
        // LinkedList<Customer> customers = new LinkedList<>();
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
        if(menupoints.size() > 0){
            for (Map.Entry<String, String> entry : menupoints.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            System.out.println("");
        }
    } 
    

    public void startMenu() {
        printMenu("Főmenü",Map.of(
            "c", "Futár",
            "d", "Depo",
            "a", "Admin",
            "w", "Raktár",
            "v", "Vevő",
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
            char c = getChar();
            if ("cdaw".contains(String.valueOf(c))) {
                User u = login();
                switch (c) {
                    case 'c':
                        //TODO Courier currentUser = courierList.get()
                        Courier currentCourier = new Courier(u);
                        courierMenu(currentCourier);
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
                }
            }
            else if(c == 'v'){
                customerMenu();
            }
            else if(c == 'k'){
                exit = true;
            }
            else{
                    System.out.println("Nincs ilyen menüpont!");
            }
        }
    }

    private User login() {       
                             
        // List<String> userInfoList = new ArrayList<>();
        // System.out.println("username:");
        // userInfoList.add(sc.nextLine());
        // System.out.println("password:");
        // userInfoList.add(sc.nextLine());
        // System.out.println("password:");
        // userInfoList.add(sc.nextLine());

        String[] userInfo = new String[] {"barni","asd","a","5"};

        return new User(userInfo);
    }
    
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
            "5", "Kosár tartalmának megrendelése",
            "k", "Kilépés"
        ));
        
        boolean exit = false;
        while(!exit){
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
                    printMenu("Megérkezett rendelés visszaigazolása",Map.of());
                    System.out.print("Csomagazonosito: ");
                case '2':
                    printMenu("Termék kosárba rakása",Map.of());
                    for (Item item : items) {
                        item.printData();
                    }
                case '3':
                    printMenu("Termék kosárba rakása",Map.of(
                    ));
                    Item.listItems(); //TODO
                    break;
                case '4':
                    printMenu("Kosár tartalmának megtekintése",Map.of(
                    ));
                    Item.listCart(); 
                    break; 
                default:
                    System.out.println("Nincs ilyen menüpont!");
                break;
                case 'k':
                    exit = true;
                    break;
                    
                    
            }
        }
    }

    private void courierMenu(Courier currentCourier){
       
        System.out.print("Csomagazonosito: ");
        String csomagAzon = sc.nextLine();
        //menüpontok:
        //- megrendelés lekérdezés
        //  |- Sikeres / sikertelen kézbesítés
                    // System.out.println("=====Courier=====");
                    // System.out.println("r - Raktárhoz megérkeztem, csomag felvétele");
                    // System.out.println("y - Csomagot kiszállítottam");
                    // System.out.println("n - Csomagot nem sikerült kiszállítani");
                    // System.out.print("k - kilépés: ");
        printMenu("Courier",Map.of(
            "1", "Csomag felvétele a raktárból",
            "2", "Csomag kiszállítva",
            "3", "Csomag kiszállítása sikertelen",
            "k", "Kilépés"
            ));
            
            boolean exit = false;
        while(!exit){
        switch (getChar()) {
            case '1':
                printMenu("Csomag felvéve",Map.of());
                order.keeper = currentCourier;
            break;
            case '2':
                printMenu("Sikeres kézbesítés",Map.of());//         order.track(csomagAzon,"Kezbesitve");
                
            break;
            case '3':
                printMenu("Sikertelen kézbesítés",Map.of());


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
        printMenu("admin",Map.of(
            "1", "Megrendelések",
            "2", "Terméklista",
            "3", "Termék hozzáadása",
            "4", "Termék törlése",
            "k", "Kilépés"
        ));
         boolean exit = false;
        while(!exit){
        switch (getChar()) {
            case '1':
                order.listOrders();
                break;
            case '2':
                i.listItems();
                break;
            case '3':
                i.addItem();
                break;
            case '4':
                System.out.print("IemId: ");
                int itemId = Integer.parseInt(sc.nextLine());
                //removeItem(itemId);
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

}
