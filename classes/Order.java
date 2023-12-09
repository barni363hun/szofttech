package classes;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import classes.file.JsonHandler;


public class Order {
    public int id;
    public int keeperId;
    public int receiverId;
    public int[] itemIds;

    static Scanner sc = new Scanner(System.in);
    
    public Order(Object[] objectArray) {
        this.id = (int) objectArray[0];
        this.keeperId = (int) objectArray[1];
        this.receiverId = (int) objectArray[2];
        itemIds = (int[]) objectArray[3];
    }

    static void printOutOrders(List<Order> orders){
        for (Order order : orders) {
            System.out.print("Order ID: " + order.id);
            System.out.print(" | Keeper ID: " + order.keeperId);
            System.out.print(" | Receiver ID: " + order.receiverId);
            System.out.print(" | Item IDs: ");
        for (int itemId : order.itemIds) {
            System.out.print(itemId + " ");
        }
        System.out.println("\n-------------------------");
    }
    }
    
    public Order(int id, int keeperId, int receiverId, int[] itemIds) {
        this.id = id;
        this.keeperId = keeperId;
        this.receiverId = receiverId;
        this.itemIds = itemIds;
    }

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



    /**
     * 
     * Leszűri az adott user melyik orderek keeper-je.
     * 
     * @param user
     * @return LinkedList of OrderModels
     */
    public LinkedList<Order> getOrdersOfKeeper(User user){
        LinkedList<Order> selected = new LinkedList<Order>();
        for (int i = 0; i< orders.size(); i++){
            Order temp = orders.get(i);
            
            if(temp.keeper.getUserName() == user.getUserName()){
                selected.add(temp);
            }
        }
        return selected;
    }

    
    /**
     * 
     * list the orders of the keeper, then select one from it.
     * 
     * @param orderController
     * @param user
     * @return
     */
    public Order getOrderFromUserOfKeeper(User user) {
        LinkedList<Order> ordersOfKeeper = orderController.getOrdersOfKeeper(user);
        return getOrderFromUser(ordersOfKeeper);
    } 

    public Order getOrderFromUser(LinkedList<Order> orders){
        LinkedList<Order> temp = orders;
        ViewUtils.printMenu("Orderek", Map.of());
        for (int i = 0; i< temp.size(); i++){
           System.out.println("Id: "+temp.get(i).id +" - "+temp.get(i).receiver.getCustomerFirstName() + " " + temp.get(i).receiver.getCustomerLastName());
        }
            System.out.print("\nKérem az id-t: ");
            String tempId = sc.next();

        for (int i = 0; i< temp.size(); i++){
            
           if (tempId == Integer.toString(temp.get(i).id)) {
            return temp.get(i);
           }
        }    
        return null;
    }

    // public LinkedList<OrderModel> getOrdersByDepot(DepotModel depot){
    //     //TODO
    //     return orders;
    // }

    // public OrderModel(int id, DepotModel keeper, CustomerModel receiver, LinkedList<ItemModel> items) {
    //     this.id = id;
    //     this.keeper = keeper;
    //     this.receiver = receiver;
    //     this.items = items;
    // }
    // public OrderModel(int id, CourierModel keeper, CustomerModel receiver, LinkedList<ItemModel> items) {
    //     this.id = id;
    //     this.keeper = keeper;
    //     this.receiver = receiver;
    //     this.items = items;
    // }
    // public OrderModel(int id, CustomerModel keeper, CustomerModel receiver, LinkedList<ItemModel> items) {
    //     this.id = id;
    //     this.keeper = keeper;
    //     this.receiver = receiver;
    //     this.items = items;
    // }

}