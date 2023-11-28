import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import classes.file.*;
import classes.roles.*;
import classes.Item;
import classes.Order;
import classes.classes_from_data.User;

public class TransportApp {

    // LinkedList<Customer> customers;
    LinkedList<Item> items = new LinkedList<Item>();
    LinkedList<Order> orders = new LinkedList<Order>();
    LinkedList<Courier> couriers = new LinkedList<Courier>();
    LinkedList<Depot> depots = new LinkedList<Depot>();
    LinkedList<Customer> customers = new LinkedList<Customer>();
    Random random = new Random();

    // Message message;
    Scanner sc;
    // Admin admin = new Admin();

    public TransportApp() {
        // LinkedList<User> users = new LinkedList<User>();
        // users.add(new User(3,"Barnabás"));

        // ---Itemek
        LinkedList<Item> item1 = new LinkedList<Item>();
        LinkedList<Item> item2 = new LinkedList<Item>();
        LinkedList<Item> item3 = new LinkedList<Item>();

        Item itemA = new Item(1, "Asztal", 1000);
        Item itemB = new Item(2, "Szek", 4000);
        Item itemC = new Item(3, "Terito", 2000);

        Item itemE = new Item(4, "Terito", 888);
        Item itemF = new Item(5, "Vaza", 444);
        Item itemG = new Item(6, "Nagyvaza", 1999);

        Item itemH = new Item(7, "Konyv", 3567);
        Item itemI = new Item(8, "Konyv2", 3990);
        Item itemJ = new Item(9, "NemKonyv", 2990);

        item1.add(itemA);
        item1.add(itemB);
        item1.add(itemC);

        item2.add(itemE);
        item2.add(itemF);
        item2.add(itemG);

        item3.add(itemH);
        item3.add(itemI);
        item3.add(itemJ);

        items.add(itemA);
        items.add(itemB);
        items.add(itemC);
        items.add(itemE);
        items.add(itemF);
        items.add(itemG);
        items.add(itemH);
        items.add(itemI);
        items.add(itemJ);

        Customer r1 = new Customer(new User(1, "Andras"));
        Customer r2 = new Customer(new User(2, "Gabor"));
        Customer r3 = new Customer(new User(3, "Feri"));
        customers.add(r1);
        customers.add(r2);
        customers.add(r3);


        Depot d1 = new Depot(new User(4, "Depo1"));
        Courier c1 = new Courier(new User(5, "Futar1"));

        // ---Order Order(int id, User keeper, Customer receiver, LinkedList<Item>
        // items)
        Order order1 = new Order(100, d1, r1, item1);
        Order order2 = new Order(101, c1, r2, item2);
        Order order3 = new Order(102, c1, r3, item3);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        couriers.add(new Courier(new User(1, "Andras")));
        depots.add(new Depot(new User(2, "Balazs")));
        // orders.add(new Order()); // todo custom constructor-ok
        // items.add(new Item());

        // ezek azok a class-ok amikbe belemennek a file-ok
        // FileRead customerList = new FileRead("customer");
        // LinkedList<Customer> customers = new LinkedList<>();
        // for (int i = 1; i < customerList.getListSize(); i++) {
        // customers.add(new Customer(customerList.splitLine(i, customerList.token)));
        // }
        // // Customer[] customers;
        // FileRead itemList = new FileRead("item");
        // // Item[] items;
        // FileRead orderList = new FileRead("order");
        // // Order[] orders;
        // FileRead users = new FileRead("user");
        sc = new Scanner(System.in);
    }

    private char getChar() {
        while (true) {
            System.out.println("Adj meg egy karatert!");
            String input = sc.next();
            if (input.length() == 1) {
                return input.charAt(0);
            } else {
                System.out.println("Ez nem egy karakter!");
            }
        }
    }

    private void printMenu(String title, Map<String, String> menupoints) {
        System.out.println("====" + title + "====");
        if (menupoints.size() > 0) {
            for (Map.Entry<String, String> entry : menupoints.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            System.out.println("");
        }
    }

    public void startMenu() {
        boolean exit = false;
        while (!exit) {
            printMenu("Főmenü", Map.of(
                    "c", "Futár",
                    "d", "Depo",
                    // "a", "Admin",
                    "w", "Raktár",
                    "v", "Vevő",
                    "k", "Kilépés"));
            char c = getChar();
            // if ("cdvk".contains(String.valueOf(c))) {
            //     // User u = login();
                switch (c) {
                    case 'c':
                        courierMenu(findInCouriers());
                        break;
                    case 'd':
                        depotMenu(findInDepot());
                        break;
                    case 'v':
                        customerMenu(findInCustomers());
                        break;
                    case 'k':
                        exit = true;
                        break;
                    default:
                        System.out.println("Nincs ilyen menüpont!");
                        break;
                }
            // } else if (c == 'v') {
            //     // TODO bekérni a felhasználónevet és átadni
            // } else if (c == 'k') {
            // } else {
            // }
        }
    }

    private void customerMenu(Customer c) {
        boolean exit = false;
        while (!exit) {
            printMenu("Customer", Map.of(
                    // "1", "Csomaghoz tartozó üzenetek lekérdezése",
                    "2", "Termék kosárba rakása",
                    // "3", "Termék törlése a kosárból",
                    "4", "Kosár tartalmának megtekintése",
                    "5", "Kosár tartalmának megrendelése",
                    "k", "Kilépés"));
            switch (getChar()) {
                case '2':
                    printMenu("Termék kosárba rakása", Map.of("hibás azonosító", "Kilépés"));
                    c.cart.add(getItemById());
                    System.out.println("A kosárban "+ c.cart.size() + " termék van");
                    break;
                // case '3':
                //     printMenu("Termék törlése a kosárból", Map.of("k", "Kilépés"));
                //     //TODO
                //     c.cart.remove();
                //     break;
                case '4':
                    printMenu("Kosár tartalmának megtekintése", Map.of());
                    for (Item item : c.cart) {
                        item.printData();
                    }
                    break;
                case '5':
                    printMenu("Kosár tartalmának megrendelése", Map.of());
                    orders.add(new Order(random.nextInt(1000,Integer.MAX_VALUE), depots.getFirst(), c, c.cart));
                    c.cart.removeAll(c.cart);
                    System.out.println("Megrendelés leadva, kosár ürítve!");
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

    private void courierMenu(Courier currentCourier) {
        printOrders();
        Order currentOrder = getOrderById();
        boolean exit = false;
        while (!exit) {
            printMenu("Courier", Map.of(
                    "1", "Csomag felvétele a raktárból",
                    "2", "Csomag kiszállítva",
                    "3", "Csomag kiszállítása sikertelen",
                    "k", "Kilépés"));
            switch (getChar()) {
                case '1':
                    printMenu("Csomag felvéve", Map.of());
                    currentOrder.keeper = currentCourier;
                    break;
                case '2':
                    printMenu("Sikeres kézbesítés", Map.of());
                    currentOrder.keeper = currentOrder.receiver;
                    break;
                case '3':
                    printMenu("Sikertelen kézbesítés", Map.of());
                    currentOrder.keeper = depots.getFirst();
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

    private void depotMenu(Depot depo) {
        boolean exit = false;
        while (!exit) {
            printMenu("Depo", Map.of(
                    "1", "Csomag átvétele",
                    "k", "Kilépés"));
            switch (getChar()) {
                case '1':
                    printMenu("Csomag felvéve", Map.of());
                    Order currentOrder = getOrderById();
                    if (currentOrder.keeper instanceof Courier) {
                        currentOrder.keeper = depo;
                    } else {
                        System.out.println("Ez a csomag nem futárnál van!");
                    }
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
    
    private Customer findInCustomers() {
        // eze undorító
        System.out.println("Kerem a vevo nevet: ");
        String name = sc.next();
        Boolean exit = false;
        while (!exit) {
            for (Customer e : customers) {
                if (e.userName.equals(name)) {
                    exit = true;
                    return  e;
                }
            }
            System.out.println("\nNincs talalat!\nKerem a vevo nevet: ");
            name = sc.next();
        }
        return null;
    }

    private Courier findInCouriers() {
        System.out.println("Kerem a futar nevet: ");
        String name = sc.next();
        Boolean exit = false;
        while (!exit) {
            for (Courier e : couriers) {
                if (e.userName.equals(name)) {
                    exit = true;
                    return  e;
                }
            }
            System.out.println("\nNincs talalat!\nKerem a futar nevet: ");
            name = sc.next();
        }
        return null;
    }

    private Depot findInDepot() {
        System.out.println("Kerem a depo nevet: ");
        String name = sc.next();
        Boolean exit = false;
        while (!exit) {
            for (Depot e : depots) {
                if (e.userName.equals(name)) {
                    exit = true;
                    return  e;
                }
            }
            System.out.println("\nNincs talalat!\nKerem a depo nevet: ");
            name = sc.next();
        }
        return null;
    }

    private void printItems() {
        for (Item item : items) {
            item.printData();
        }
    }

    private void printOrders() {
        for (Order order : orders) {
            order.printData();
        }
    }

    // private void printCustomers() {
    //     for (Customer customer : customers) {
    //         customer.printData();
    //     }
    // }

    private Item getItemById() {
        printItems();
        Item ret = null;
        Boolean exit = false;
        while (!exit) {
            System.out.println("Kerem az item id-t: ");
            try {
                int itemId = Integer.parseInt(sc.next());
                for (Item e : items) {
                    if (e.id == itemId) {
                        ret = e;
                        exit = true;
                    }
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("\nHibas azonosito!\n");
        }
        return ret;

    }

    private Order getOrderById() {
        printOrders();
        Order ret = null;
        Boolean exit = false;
        while (!exit) {
            System.out.println("Kerem a rendeles id-t: ");
            try {
                int orderId = Integer.parseInt(sc.next());
                for (Order e : orders) {
                    if (e.id == orderId) {
                        ret = e;
                        exit = true;
                    }
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("\nHibas azonosito!\n");
        }
        return ret;

    }

    private Order getCustomerById() {
        printOrders();
        Order ret = null;
        Boolean exit = false;
        while (!exit) {
            System.out.println("Kerem a rendeles id-t: ");
            try {
                int orderId = Integer.parseInt(sc.next());
                for (Order e : orders) {
                    if (e.id == orderId) {
                        ret = e;
                        exit = true;
                    }
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("\nHibas azonosito!\n");
        }
        return ret;

    }
}
