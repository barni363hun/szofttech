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
    // Ezek a szerep class-ok
    Admin admin;
    Courier courier;
    User_Customer customer;
    Depot depot;
    Warehouse warehouse;

    Scanner sc = new Scanner(System.in);

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
        User user;
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

}
