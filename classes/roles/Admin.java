package classes.roles;

import java.util.LinkedList;
import java.util.Scanner;

import classes.Order;
import classes.classes_from_data.User;

public class Admin extends User {

    public LinkedList<Order> orders;
    public Admin(User u) {
        super(u);
        // TODO Auto-generated constructor stub
    }
}
