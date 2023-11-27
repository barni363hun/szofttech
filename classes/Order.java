package classes;
import java.util.LinkedList;
import classes.classes_from_data.User;
import classes.roles.*;


public class Order {
    public int id;
    public User keeper;
    public Customer receiver;
    public LinkedList<Item> items;

    public Order(int id, User keeper, Customer receiver, LinkedList<Item> items) {
        this.id = id;
        this.keeper = keeper;
        this.receiver = receiver;
        this.items = items;
    }
    public Order(int id, Depot keeper, Customer receiver, LinkedList<Item> items) {
        this.id = id;
        this.keeper = keeper;
        this.receiver = receiver;
        this.items = items;
    }
    public Order(int id, Courier keeper, Customer receiver, LinkedList<Item> items) {
        this.id = id;
        this.keeper = keeper;
        this.receiver = receiver;
        this.items = items;
    }
    public Order(int id, Customer keeper, Customer receiver, LinkedList<Item> items) {
        this.id = id;
        this.keeper = keeper;
        this.receiver = receiver;
        this.items = items;
    }
	public void printData() {
	}

}