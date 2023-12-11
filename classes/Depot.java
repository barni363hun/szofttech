package classes;

import java.util.List;
import java.util.Map;

import classes.json.OrderHandler;
import classes.json.UserHandler;

public class Depot extends User{

    public Depot(User user){
        super(user);
    }

    // public Depot(Object[] objArr) {
    //     super(objArr);
    // }

    public void DepotMenu(OrderHandler orderHandler, UserHandler userHandler){
        boolean exit = false;
        while (!exit) {
            Utils.printMenu("Depo", Map.of(
                    "1", "Csomag átvétele",
                    "k", "Kilépés"));
            switch (Utils.getChar()) {
                case '1':
                    Utils.printMenu("Csomag átvétele", Map.of());
                    // is this order should arrive to me?
                    List<Order> addressedToMe = Order.getOrdersAddressedToThisOperator(orderHandler.list,this);
                    if (addressedToMe.size() > 0) { 
                        Order currOrder = Order.selectOrderFromList(addressedToMe);
                        currOrder.keeperId = currOrder.nextOperatorId;
                        currOrder.nextOperatorId = userHandler.getFirstByType('C');
                        orderHandler.list.set(currOrder.id-1, currOrder);
                    }
                    else{
                        // TODO error message
                    }
                    break;
                case 'k':
                    exit = true;
                    break;
                default:
                    System.out.println("Nincs ilyen menüpont!");
                    break;
            }
        }
    }
}
