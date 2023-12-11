import java.util.*;

import classes.*;
import classes.json.ItemHandler;
import classes.json.JsonHandler;
import classes.json.OrderHandler;
import classes.json.UserHandler;

public class TransportApp {
    public TransportApp() {
        
        UserHandler userHandler = new UserHandler("users.json");
        OrderHandler orderHandler = new OrderHandler("orders.json");
        ItemHandler itemHandler = new ItemHandler("items.json");
        
        Login login = new Login(userHandler);
		login.getUserNameFromUser();
		User user = login.getPasswordFromUser();
        
        switch (user.getUserType()) {
            case 'C': // futar
                Courier courier = new Courier(user);
                for (Order order : orderHandler.list) {
                    if (order.keeperId == courier.getId()) {
                        courier.addOrder(order);
                    }
                }
                courier.CourierMenu();
                break;
            case 'D': // depo
                Depot d = new Depot(user);
                d.DepotMenu(orderHandler);
                break;
            case 'V': // vevo
                Customer customer = new Customer(user);
                customer.CustomerMenu(itemHandler, orderHandler, userHandler);
                break;
            case 'A': // admin
                Admin admin = new Admin(user);
                admin.AdminMenu(itemHandler, orderHandler, userHandler);
                break;
            default:
                break;
        }
    }
}