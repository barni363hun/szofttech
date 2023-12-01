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
		User user = new User(userList.splitLine(login.line));

        System.out.println("asd");

        switch (user.getUserType()) {
            case 'C': // futar
            CourierController c = new CourierController(user);
            c.couriers = couriersFromFile;
                new CourierView().courierMenu(c,new OrderController());
                break;
            case 'D': // Depo
            DepotController d = new DepotController(user);
                d.depots = depotsFromFile;
                new DepotView().depotMenu(d,new OrderController());
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
}