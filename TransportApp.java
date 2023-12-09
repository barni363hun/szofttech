import java.io.*;
import java.util.*;

import classes.user.*;
import classes.file.*;
import classes.item.ItemController;
import classes.item.ItemModel;
import classes.order.*;
import classes.user_depot.*;
import classes.user_courier.*;
import classes.user_customer.*;
import classes.*;

public class TransportApp {
    // LinkedList<OrderM> orders = new LinkedList<Order>();
    // LinkedList<Courier> couriers = new LinkedList<Courier>();
    

    FileRead customerList = new FileRead("customer");
	FileRead itemList = new FileRead("item");
	FileRead orderList = new FileRead("order");
	FileRead userList = new FileRead("user");
    User user;
    Random random = new Random();

    public TransportApp() {
        
        LinkedList<CourierModel> couriersFromFile = new LinkedList<CourierModel>();
        LinkedList<DepotModel> depotsFromFile = new LinkedList<DepotModel>();
        String[] u1 = {"Futarx","1234","C","2"};
        User k1 = new User(u1);
        //Depo-courier load
		for (int i = 1; i < userList.getListSize(); i++) {
            String temp[] = userList.splitLine(i);
            
            switch (temp[2]) {
                case "C":
                    couriersFromFile.add(new CourierModel(new User(temp)));
                    break;
                case "D":
                    depotsFromFile.add(new DepotModel(new User(temp)));
                    break;
                default:
                    break;
            }
		}



        
        // ---Itemek
        ItemController itemController = new ItemController();
        LinkedList<ItemModel> item2 = new LinkedList<ItemModel>();
        LinkedList<ItemModel> item3 = new LinkedList<ItemModel>();

        ItemModel itemA = new ItemModel(1, "Asztal", 1000);
        ItemModel itemB = new ItemModel(2, "Szek", 4000);
        ItemModel itemC = new ItemModel(3, "Terito", 2000);

        ItemModel itemE = new ItemModel(4, "Terito", 888);
        ItemModel itemF = new ItemModel(5, "Vaza", 444);
        ItemModel itemG = new ItemModel(6, "Nagyvaza", 1999);

        ItemModel itemH = new ItemModel(7, "Konyv", 3567);
        ItemModel itemI = new ItemModel(8, "Konyv2", 3990);
        ItemModel itemJ = new ItemModel(9, "NemKonyv", 2990);

        itemController.addItemToList(itemA);
        itemController.addItemToList(itemB);
        itemController.addItemToList(itemC);
        itemController.addItemToList(itemE);
        itemController.addItemToList(itemF);
        itemController.addItemToList(itemG);
        item2.add(itemH);
        item3.add(itemI);
        item3.add(itemJ);

        // items.add(itemA);
        // items.add(itemB);
        // items.add(itemC);
        // items.add(itemE);
        // items.add(itemF);
        // items.add(itemG);
        // items.add(itemH);
        // items.add(itemI);
        // items.add(itemJ);

        String[] cm1 = {"Andras","Varga","8200","Veszprem","Egyetem utca","12345678","email@email.com"};
        String[] cm2 = {"Toni","Megko","8200","Veszprem","Dozsa Gyorgy ut 2","12345678","dimitrov@veb2023.com"};
        String[] cm3 = {"Zoltan","Gondolko","8200","Veszprem","Iskola utca 4","12345678","email@email.com"};

        Customer r1 = new Customer(cm1);
        Customer r2 = new Customer(cm2);
        Customer r3 = new Customer(cm3);
        // Customer r2 = new Customer(new User(2, "Gabor"));
        // Customer r3 = new Customer(new User(3, "Feri"));
        // customers.add(r1);
        // customers.add(r2);
        // customers.add(r3);


        // Depot d1 = new Depot(new User(4, "Depo1"));
        // Courier c1 = new Courier(new User(5, "Futar1"));

        // ---Order Order(int id, User keeper, Customer receiver, LinkedList<Item>
        // items)
        Order order1 = new Order(100, k1, r1, item2);
        Order order2 = new Order(101, k1, r2, item2);
        Order order3 = new Order(102, k1, r3, item3);
        OrderController orderController = new OrderController();
        orderController.addOrderToList(order1);
        orderController.addOrderToList(order2);
        orderController.addOrderToList(order3);

        
        // orders.add(order1);
        // orders.add(order2);
        // orders.add(order3);

        // couriers.add(new Courier(new User(1, "Andras")));
        // depots.add(new Depot(new User(2, "Balazs")));

        // //Order lista feltolt
        // for (int i = 1; i < orderList.getListSize(); i++) {
		// 	// orders.add(new Order(orderList.splitLine(i)));
        // }


		// for (int i = 1; i < customerList.getListSize(); i++) {
        //     //Szállítási adatok, elérhetőségek, stb
		// 	//customers.add(new Customer(customerList.splitLine(i)));
        // }
        Login login = new Login();
		login.setUserNameTyped(userList.getRow(0));
		login.setUserPasswordTyped(userList.getRow(1)[login.line]);
		User user = new User(userList.splitLine(login.line));

        System.out.println("asd");

        switch (user.getUserType()) {
            case 'C': // futar
            Courier c = new Courier(user);
            c.couriers = couriersFromFile;
                new CourierView(c,orderController);
                break;
            case 'D': // Depo
            DepotController d = new DepotController(user);
                d.depots = depotsFromFile;
                new Depot(d,orderController);
                break;
            case 'V': // vevo
                new CustomerView(new CustomerController(user),
                    itemController,
                    orderController,
                    new DepotController());
                break;
            default:
                break;
        }

        
        
    }
}