package classes.order;
import java.util.LinkedList;

import classes.roles.*;
import classes.roles.customer.CustomerModel;
import classes.user.User;
import classes.user_courier.CourierModel;
import classes.user_depot.DepotModel;


public class OrderModel {
    public int id;
    public User keeper;
    public CustomerModel receiver;
    public LinkedList<ItemModel> items;
	
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
        for (ItemModel item : items) {
            dataString.append(item.name).append("), ");
        }

        // Remove the trailing comma and space
        if (!items.isEmpty()) {
            dataString.setLength(dataString.length() - 2);
        }

        System.out.println(dataString.toString());
    }


    public OrderModel(int id, User keeper, CustomerModel receiver, LinkedList<ItemModel> items) {
        this.id = id;
        this.keeper = keeper;
        this.receiver = receiver;
        this.items = items;
    }
    public OrderModel(int id, DepotModel keeper, CustomerModel receiver, LinkedList<ItemModel> items) {
        this.id = id;
        this.keeper = keeper;
        this.receiver = receiver;
        this.items = items;
    }
    public OrderModel(int id, CourierModel keeper, CustomerModel receiver, LinkedList<ItemModel> items) {
        this.id = id;
        this.keeper = keeper;
        this.receiver = receiver;
        this.items = items;
    }
    public OrderModel(int id, CustomerModel keeper, CustomerModel receiver, LinkedList<ItemModel> items) {
        this.id = id;
        this.keeper = keeper;
        this.receiver = receiver;
        this.items = items;
    }

}