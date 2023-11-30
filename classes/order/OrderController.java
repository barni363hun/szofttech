package classes.order;

import java.util.LinkedList;

import classes.user.User;

public class OrderController {
    public LinkedList<OrderModel> orders = new LinkedList<OrderModel>();

    public OrderController() {
    }

    public OrderModel getOrderById(String u){
		for (int i = 0; i < orders.size(); i++) {
            if (Integer.toString(orders.get(i).id) == u){
                return orders.get(i);
            }
        }
        return null;

    }

    public void setOrderKeeper(int id /* ez az order.id */,User user) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).id == id){
              orders.get(i).keeper = user;
            }
        }
    }

    public LinkedList<OrderModel> getOrders(){
        return orders;
    }

}
