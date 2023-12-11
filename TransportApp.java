import java.util.*;

import classes.*;

public class TransportApp {
    public TransportApp() {
        
        UserHandler userHandler = new UserHandler("users.json");
        // JsonHandler<Order> orderHandler = new JsonHandler<Order>("orders.json");
        // JsonHandler<Item> itemHandler = new JsonHandler<Item>("items.json");
        // userHandler.add(new User(0,"admin","admin",'A'));
        // userHandler.printItems();
        
        Login login = new Login(userHandler);
		login.getUserNameFromUser();
		User user = login.getPasswordFromUser();
        
        // switch (user.getUserType()) {
        //     case 'C': // futar
        //         Courier courier = new Courier(user);
        //         for (Order order : orderHandler.list) {
        //             if (order.keeperId == courier.getId()) {
        //                 courier.addOrder(order);
        //             }
        //         }
        //         courier.CourierMenu();
        //         break;
        //     case 'D': // depo
        //         Depot d = new Depot(user);
        //         d.DepotMenu(orderHandler);
        //         break;
        //     case 'V': // vevo
        //         Customer customer = new Customer(user);
        //         customer.CustomerMenu(itemHandler, orderHandler, userHandler);
        //         break;
        //     case 'A': // admin
        //         Admin admin = new Admin(user);
        //         admin.AdminMenu(itemHandler, orderHandler, userHandler);
        //         break;
        //     default:
        //         break;
        // }
    }
}