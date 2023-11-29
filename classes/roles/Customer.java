package classes.roles;

import java.util.LinkedList;
import classes.Item;
import classes.Order;
import classes.classes_from_data.User;

public class Customer extends User{
    
    public LinkedList<Item> cart = new LinkedList<Item>(); 

    public Customer(User u) {
        super(u);
    }
}