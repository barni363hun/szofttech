import java.io.*;
import java.util.*;

import classes.Courier;
import classes.Depot;
import classes.User;
import classes.file.FileRead;
import classes.file.JsonHandler;
import classes.file.Login;


public class TransportApp {
    // LinkedList<OrderM> orders = new LinkedList<Order>();
    // LinkedList<Courier> couriers = new LinkedList<Courier>();
	private FileRead userList = new FileRead("user");
    private static Random r = new Random();
    

    public TransportApp() {
        
        JsonHandler userHandler = new JsonHandler("users.json");
        JsonHandler orderHandler = new JsonHandler("orders.json");
        JsonHandler itemHandler = new JsonHandler("items.json");
        JsonHandler customerHandler = new JsonHandler("customers.json");
        
        Login login = new Login();
		login.setUserNameTyped(userList.getRow(0));
		login.setUserPasswordTyped(userList.getRow(1)[login.line]);

		User user = new User(userList.splitLine(login.line));

        System.out.println("asd");

        switch (user.getUserType()) {
            case 'C': // futar
            Courier c = new Courier(user);
            c
                break;
            case 'D': // Depo
            Depot d = new Depot(user,userHandler);
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