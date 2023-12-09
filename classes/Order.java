package classes;
import java.util.LinkedList;
import java.util.Map;

import classes.item.ItemModel;
import classes.user_customer.*;


public class Order {
    //public CustomerModel sender; hátha kell majd 
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


    public Order(int id, User keeper, Customer receiver, LinkedList<ItemModel> items) {
        this.id = id;
        this.keeper = keeper;
        this.receiver = receiver;
        this.items = items;
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