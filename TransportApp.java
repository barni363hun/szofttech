import java.io.*;
import java.util.*;

import classes.user.*;
import classes.file.*;
import classes.item.ItemController;
import classes.item.ItemModel;
import classes.order.*;
import classes.user_depot.*;
import classes.user_courier.*;
import classes.*;

public class TransportApp {
    // LinkedList<OrderM> orders = new LinkedList<Order>();
    // LinkedList<Courier> couriers = new LinkedList<Courier>();
    LinkedList<DepotModel> depot = new LinkedList<DepotModel>();
    LinkedList<CustomerModel> customers;
    CustomerView customerView = new CustomerView();
    
    DepotController depotController = new DepotController();
    CourierController courierController = new CourierController();

    FileRead customerList = new FileRead("customer");
	FileRead itemList = new FileRead("item");
	FileRead orderList = new FileRead("order");
	FileRead userList = new FileRead("user");
    User user;
    Random random = new Random();

    // Message message;
    Scanner sc;
    // Admin admin = new Admin();

    public TransportApp() {
        
        // LinkedList<User> users = new LinkedList<User>();
        // users.add(new User(3,"Barnabás"));

        //Depo-courier load
		for (int i = 1; i < userList.getListSize(); i++) {
            String temp[] = userList.splitLine(i);
            
            switch (temp[2]) {
                case "C":
                    courierController.addToCourier(new CourierModel(new User(temp)));
                    break;
                case "D":
                    depotController.addToDepot(new DepotModel(new User(temp)));
                    break;
                default:
                    break;
            }
		}


        //Order lista feltolt
        for (int i = 1; i < orderList.getListSize(); i++) {
			// orders.add(new Order(orderList.splitLine(i)));
        }


		for (int i = 1; i < customerList.getListSize(); i++) {
            //Szállítási adatok, elérhetőségek, stb
			//customers.add(new Customer(customerList.splitLine(i)));
        }
        Login login = new Login();
		login.setUserNameTyped(userList.getRow(0));
		login.setUserPasswordTyped(userList.getRow(1)[login.line]);
		user = new User(userList.splitLine(login.line));

        switch (user.getUserType()) {
            case 'C': // futar
                // CourierView c = new CourierView(user);
                break;
            case 'D': // Depo
                new DepotView().depotMenu(
                    new DepotController(user),
                    new OrderController());
                break;
            case 'V': // vevo
                new CustomerView().customerMenu(
                    new CustomerController(user),
                    new ItemController(),
                    new OrderController(),
                    new DepotController());
                break;
            default:
                break;
        }
        
    }


    public void startMenu() {
        //System.out.println("=====\n" + user.getUserType() + "\n=====" );
        



        // boolean exit = false;
        // while (!exit) {
        //     printMenu("Fomenu", Map.of(
        //             "c", "Futar",
        //             "d", "Depo",
        //             // "a", "Admin",
        //             "w", "Raktar",
        //             "v", "Vevo",
        //             "k", "Kilépes"));
        //     char c = getChar();
        //     // if ("cdvk".contains(String.valueOf(c))) {
        //     //     // User u = login();
        //         switch (c) {
        //             case 'c':
        //                 courierMenu(findInCouriers());
        //                 break;
        //             case 'd':
        //                 depotMenu(findInDepot());
        //                 break;
        //             case 'v':
        //                 customerMenu(findInCustomers());
        //                 break;
        //             case 'k':
        //                 exit = true;
        //                 break;
        //             default:
        //                 System.out.println("Nincs ilyen menüpont!");
        //                 break;
        //         }
            // } else if (c == 'v') {
            //     // TODO bekérni a felhasználónevet és átadni
            // } else if (c == 'k') {
            // } else {
            // }
        //}
    }

    //private void customerMenu(Customer c) {
    //private void customerMenu(CustomerModel c) {
        // boolean exit = false;
        // while (!exit) {
        //     printMenu("Customer", Map.of(
        //             // "1", "Csomaghoz tartozó üzenetek lekérdezése",
        //             "2", "Termék kosárba rakása",
        //             "3", "Termék törlése a kosárból",
        //             "4", "Kosár tartalmának megtekintése",
        //             "5", "Kosár tartalmának megrendelése",
        //             "k", "Kilépés"));
        //     switch (getChar()) {
        //         case '2':
        //             printMenu("Termék kosárba rakása", Map.of("k", "Kilépés"));
        //             c.cart.add(getItemById());
        //         case '3':
        //             printMenu("Termék törlése a kosárból", Map.of("k", "Kilépés"));
        //             c.cart.remove(getItemById());
        //             break;
        //         case '4':
        //             printMenu("Kosár tartalmának megtekintése", Map.of());
        //             for (Item item : c.cart) {
        //                 item.printData();
        //             }
        //             break;
        //         case '5':
        //             printMenu("Kosár tartalmának megrendelése", Map.of());
        //             orders.add(new Order(random.nextInt(1000,Integer.MAX_VALUE), depots.getFirst(), c, c.cart));
        //             break;
        //         case 'k':
        //             exit = true;
        //             break;
        //         default:
        //             System.out.println("Nincs ilyen menüpont!");
        //             break;

        //     }
        // }
    //}

    //private void courierMenu(Courier currentCourier) {
    private void courierMenu(User currentCourier) {
        // printOrders();
        // Order currentOrder = getOrderById();
        // boolean exit = false;
        // while (!exit) {
        //     printMenu("Courier", Map.of(
        //             "1", "Csomag felvétele a raktárból",
        //             "2", "Csomag kiszállítva",
        //             "3", "Csomag kiszállítása sikertelen",
        //             "k", "Kilépés"));
        //     switch (getChar()) {
        //         case '1':
        //             printMenu("Csomag felvéve", Map.of());
        //             currentOrder.keeper = currentCourier;
        //             break;
        //         case '2':
        //             printMenu("Sikeres kézbesítés", Map.of());
        //             currentOrder.keeper = currentOrder.receiver;
        //             break;
        //         case '3':
        //             printMenu("Sikertelen kézbesítés", Map.of());
        //             currentOrder.keeper = depots.getFirst();
        //             break;
        //         case 'k':
        //             exit = true;
        //             break;
        //         default:
        //             System.out.println("Nincs ilyen menüpont!");
        //             break;
        //     }
        // }
    }

       // private void depotMenu(Depot depo) {
    //     private void depotMenu(User depo) {
    //     boolean exit = false;
    //     while (!exit) {
    //         printMenu("Depo", Map.of(
    //                 "1", "Csomag átvétele",
    //                 "k", "Kilépés"));
    //         switch (getChar()) {
    //             case '1':
    //                 printMenu("Csomag felvéve", Map.of());
    //                 Order currentOrder = getOrderById();
    //                 if (currentOrder.keeper instanceof Courier) {
    //                     currentOrder.keeper = depo;
    //                 } else {
    //                     System.out.println("Ez a csomag nem futárnál van!");
    //                 }
    //                 break;
    //             case 'k':
    //                 exit = true;
    //                 break;
    //             default:
    //                 System.out.println("Nincs ilyen menüpont!");
    //                 break;
    //         }
    //     }
    // }
    

    private Courier findInCouriers() {
        System.out.println("Kerem a futar nevet: ");
        String name = sc.next();
        Courier ret = null;
        Boolean exit = false;
        while (!exit) {
            for (Courier e : couriers) {
                if (e.getUserName().equals(name)) {
                    ret = e;
                    exit = true;
                }
            }
            System.out.println("\nNincs talalat!\nKerem a futar nevet: ");
            name = sc.next();
        }
        return ret;
    }

    private Depot findInDepot() {
        System.out.println("Kerem a depo nevet: ");
        String name = sc.next();
        Depot ret = null;
        Boolean exit = false;
        while (!exit) {
            for (Depot e : depots) {
                if (e.getUserName().equals(name)) {
                    ret = e;
                    exit = true;
                }
            }
            System.out.println("\nNincs talalat!\nKerem a depo nevet: ");
            name = sc.next();
        }
        return ret;
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
