import java.util.*;

import classes.*;
import classes.json.ItemHandler;
import classes.json.MessageHandler;
import classes.json.OrderHandler;
import classes.json.UserHandler;

public class TransportApp {
    
    UserHandler userHandler = new UserHandler("users.json");
    OrderHandler orderHandler = new OrderHandler("orders.json");
    ItemHandler itemHandler = new ItemHandler("items.json");
    MessageHandler messageHandler = new MessageHandler("messages.json");
    Login login = new Login(userHandler);


    public TransportApp() {
		login.getUserNameFromUser();
		User user = login.getPasswordFromUser();
        switch (user.getUserType()) {
            case 'C': // futar
                Courier courier = new Courier(user);
                for (Order order : orderHandler.list) {
                    if (order.nextOperatorId == courier.id) {
                        courier.addOrder(order);
                    }
                }
                courier.CourierMenu(orderHandler,messageHandler);
                break;
            case 'D': // depo
                Depot d = new Depot(user);
                d.DepotMenu(orderHandler,userHandler,messageHandler);
                break;
            case 'V': // vevo
                Customer customer = new Customer(user);
                customer.CustomerMenu(itemHandler, orderHandler, userHandler,messageHandler);
                break;
            case 'A': // admin
                Admin admin = new Admin(user);
                admin.AdminMenu(itemHandler, orderHandler, userHandler);
                break;
            default:
                break;
        }
        orderHandler.writeAllToJsonFile();
        messageHandler.writeAllToJsonFile();
        itemHandler.writeAllToJsonFile();
        userHandler.writeAllToJsonFile();
    }
}