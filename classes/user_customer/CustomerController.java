package classes.roles.customer;

import classes.classes_from_data.User;
import classes.file.FileRead;
import classes.order.Order;

import java.util.LinkedList;

import classes.*;

public class CustomerController {

    
    CustomerModel customer = null;
    
    OrderController OrderController = null;
    
    LinkedList<CustomerModel> customers = new LinkedList<CustomerModel>();


    // FileRead customerList = new FileRead("customer");

    public CustomerController(User user, OrderController o) {
        customer = new CustomerModel(user);
                
        customers = new LinkedList<CustomerModel>();
        FileRead customerList = new FileRead("customer");

        for (int i = 1; i < customerList.getListSize(); i++) {
                    String temp[] = customerList.splitLine(i);
        }

    }

    public void addToCart() {
        customer.cart.add(Item i);

    }
    public void listCart() {
        customer.cart.list(Item i);
    }
    public void removeFromCart(){
        customer.cart.list(Item i);
    }
    public void sendOrder(){
        
    }

    public void setKeeperToMe() {
        Order o = orderController.orders.get(where customer = customer)
        o.setKeeoper(customer)
        orderController.orders.set(where customer = customer,o)

    }


    
}
