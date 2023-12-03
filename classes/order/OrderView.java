package classes.order;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import classes.ViewUtils;
import classes.user.User;

public class OrderView {
    Scanner sc = new Scanner(System.in);

    OrderController orderController = null;

    public OrderView(OrderController _orderController) {
        orderController = _orderController;
    }

    /**
     * 
     * list the orders of the keeper, then select one from it.
     * 
     * @param orderController
     * @param user
     * @return
     */
    public OrderModel getOrderFromUserOfKeeper(User user) {
        LinkedList<OrderModel> ordersOfKeeper = orderController.getOrdersOfKeeper(user);
        return getOrderFromUser(ordersOfKeeper);
    } 

    public OrderModel getOrderFromUser(LinkedList<OrderModel> orders){
        LinkedList<OrderModel> temp = orders;
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
    
}
