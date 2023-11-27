package classes.roles;

import java.util.LinkedList;
import java.util.Scanner;

import classes.Order;
import classes.classes_from_data.User;

public class Courier extends User {
    
    public LinkedList<Order> orders;
    public Courier(User u) {
        super(u);
        // TODO Auto-generated constructor stub
    }
}
