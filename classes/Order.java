package classes;
import java.util.LinkedList;
import classes.classes_from_data.User;
import classes.roles.*;


public class Order {
    public int id;
    public User keeper;
    public Customer receiver;
    public LinkedList<Item> items;
	
    public void printData() {
        StringBuilder dataString = new StringBuilder("Order ID: " + id);

        if (keeper != null) {
            dataString.append(", Keeper: ").append(keeper.getUserName());
        } else {
            dataString.append(", Keeper: Not assigned");
        }

        if (receiver != null) {
            dataString.append(", Receiver: ").append(receiver.getUserName());
        } else {
            dataString.append(", Receiver: Not assigned");
        }

        dataString.append(", Items: ");
        for (Item item : items) {
            dataString.append(item.name).append("), ");
        }

        // Remove the trailing comma and space
        if (!items.isEmpty()) {
            dataString.setLength(dataString.length() - 2);
        }

        System.out.println(dataString.toString());
    }


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

}