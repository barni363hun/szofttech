package classes.user_customer;

import classes.file.FileRead;
import classes.item.ItemModel;
import classes.user.User;

import java.util.LinkedList;
import java.util.Scanner;

import classes.*;

public class CustomerController {

    public CustomerModel customer = null;
    
    LinkedList<CustomerModel> customers = new LinkedList<CustomerModel>();

    // FileRead customerList = new FileRead("customer");

    public CustomerController(User user) {
        customer = new CustomerModel(user);
        customers = new LinkedList<CustomerModel>();
        FileRead customerList = new FileRead("customer");
        for (int i = 1; i < customerList.getListSize(); i++) {
                    String temp[] = customerList.splitLine(i);
        }

    }

    public void addToCart(ItemModel i) {
        customer.cart.add(i);

    }
    
    public void getCart(){
        
    }

    public void setKeeperToMe() {
        Order o = orderController.orders.get(where customer = customer)
        o.setKeeoper(customer)
        orderController.orders.set(where customer = customer,o)

    }

	public void removeFromCart(ItemModel selectItemFromCart) {
        // TODO
        // customer.cart.remove
	}
    

    public CustomerModel selectFromCustomers() {
        // eze undorító
        System.out.println("Kerem a vevo nevet: ");
        String name = new Scanner(System.in).next();
        Boolean exit = false;
        while (!exit) {
            for (CustomerModel e : customers) {
                if (e.getUserName().equals(name)) {
                    exit = true;
                    return  e;
                }
            }
            // if(ret == null) {
                System.out.println("\nNincs talalat!\nKerem a vevo nevet: ");
                name = sc.next();
            // }
        }
        return null; //null
    }

    
}
