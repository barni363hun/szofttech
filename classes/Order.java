package classes;
import java.util.ArrayList;
import java.util.List;

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
}