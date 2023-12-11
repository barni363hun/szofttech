package classes;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
// import java.util.LinkedList;
// import java.util.Map;
// import java.util.Scanner;
// import java.lang.reflect.Field;

import classes.json.JsonDataClass;


public class Order extends JsonDataClass {
    public int keeperId;
    public int nextOperatorId;
    public int receiverId;
    public int[] itemIds;
    
    @Override
    public List<Object> getArrayList() {
        List<Object> itemData = new ArrayList<>();
        itemData.add(id);
        itemData.add(keeperId);
        itemData.add(receiverId);
        itemData.add(nextOperatorId);
        itemData.add(itemIds);
        return itemData;
    }

    static public List<Order> getOrdersAddressedToThisOperator(List<Order> orders,User user){
        List<Order> res = new ArrayList<Order>();
        for (Order order : orders) {
            if (order.nextOperatorId == user.id) {
                res.add(order);
            }
        }
        return res;
    }

    // static public List<Order> getOrdersByRole(List<Order> orders,String role) {
    //     
    //     orders.get(0).
    //     return orders;
    // }
    

    static public void printOutOrders(List<Order> orders){
        for (Order order : orders) {
            System.out.print("Order ID: " + order.id);
            System.out.print(" | Keeper ID: " + order.keeperId);
            System.out.print(" | Receiver ID: " + order.receiverId);
            System.out.print(" | nextOperator ID: " + order.nextOperatorId);
            System.out.print(" | Item IDs: ");
            for (int itemId : order.itemIds) {
                System.out.print(itemId + " ");
            }
            System.out.println("\n-------------------------");
        }
    }
    
    static public Order selectOrderFromList(List<Order> orders) {
        Order.printOutOrders(orders);
        int input;
        Order res = null;
        while (res == null) {
            System.out.println("Adj meg egy id-t");
            input = Utils.sc.nextInt();
            for (Order order : orders) {
                if (order.id == input) {
                    res = order;
                } 
            }
        }
       return res;
    }
    
    public Order(int id, int keeperId, int receiverId,int nextOperatorId, int[] itemIds) {
        this.id = id;
        this.keeperId = keeperId;
        this.receiverId = receiverId;
        this.nextOperatorId = nextOperatorId;
        this.itemIds = itemIds;
    }

    public Order(ArrayList t) {
        this(
            ((Number) t.get(0)).intValue(),
            ((Number) t.get(1)).intValue(),
            ((Number) t.get(2)).intValue(),
            ((Number) t.get(3)).intValue(),
            convertArrayListToIntArray((ArrayList) t.get(4))
        );
    }
        
    private static int[] convertArrayListToIntArray(ArrayList arrayList) {
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = ((Number) arrayList.get(i)).intValue();
        }
        return result;
    }


    
    // public void printData() {
    //     StringBuilder dataString = new StringBuilder("Order ID: " + id);

    //     if (keeper != null) {
    //         dataString.append(", Keeper: ").append(keeper.getUserName());
    //     } else {
    //         dataString.append(", Keeper: Not assigned");
    //     }

    //     if (receiver != null) {
    //         dataString.append(", Receiver: ").append(receiver.getUserName());
    //     } else {
    //         dataString.append(", Receiver: Not assigned");
    //     }

    //     dataString.append(", Items: ");
    //     for (Item item : items) {
    //         dataString.append(item.name).append("), ");
    //     }
    //     // Remove the trailing comma and space
    //     if (!items.isEmpty()) {
    //         dataString.setLength(dataString.length() - 2);
    //     }
    //     System.out.println(dataString.toString());
    // }



    // /**
    //  * 
    //  * Leszűri az adott user melyik orderek keeper-je.
    //  * 
    //  * @param user
    //  * @return LinkedList of OrderModels
    //  */
    // public LinkedList<Order> getOrdersOfKeeper(User user){
    //     LinkedList<Order> selected = new LinkedList<Order>();
    //     for (int i = 0; i< orders.size(); i++){
    //         Order temp = orders.get(i);
            
    //         if(temp.keeper.getUserName() == user.getUserName()){
    //             selected.add(temp);
    //         }
    //     }
    //     return selected;
    // }

    
    // /**
    //  * 
    //  * list the orders of the keeper, then select one from it.
    //  * 
    //  * @param orderController
    //  * @param user
    //  * @return
    //  */
    // public Order getOrderFromUserOfKeeper(User user) {
    //     LinkedList<Order> ordersOfKeeper = orderController.getOrdersOfKeeper(user);
    //     return getOrderFromUser(ordersOfKeeper);
    // } 

    // public Order getOrderFromUser(LinkedList<Order> orders){
    //     LinkedList<Order> temp = orders;
    //     Utils.printMenu("Orderek", Map.of());
    //     for (int i = 0; i< temp.size(); i++){
    //        System.out.println("Id: "+temp.get(i).id +" - "+temp.get(i).receiver.getCustomerFirstName() + " " + temp.get(i).receiver.getCustomerLastName());
    //     }
    //         System.out.print("\nKérem az id-t: ");
    //         String tempId = Utils.sc.next();

    //     for (int i = 0; i< temp.size(); i++){
            
    //        if (tempId == Integer.toString(temp.get(i).id)) {
    //         return temp.get(i);
    //        }
    //     }    
    //     return null;
    // }

    // public LinkedList<OrderModel> getOrdersByDepot(DepotModel depot){
    //     
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