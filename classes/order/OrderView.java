package classes.order;

import java.util.LinkedList;

import classes.user.User;
import classes.user_customer.CustomerModel;

public class OrderView {

    CustomerModel customerModel = new CustomerModel CustomerModel();

    public OrderModel getOrderOfUser(OrderController orderController, User user) {
        // TODO list the orders of the customer, then select one from it.
        LinkedList<OrderModel> orders = orderController.getOrders();

        for (int i = 0; i< orders.size(); i++){
            CustomerModel temp = orders.get(i).receiver;
            
//folyamatban...
        }

        return null;
    } 
}
