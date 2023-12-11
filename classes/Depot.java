package classes;

import java.util.List;
import java.util.Map;

import classes.json.MessageHandler;
import classes.json.OrderHandler;
import classes.json.UserHandler;

public class Depot extends User{

    public Depot(User user){
        super(user);
    }

    // public Depot(Object[] objArr) {
    //     super(objArr);
    // }

    public void DepotMenu(OrderHandler orderHandler, UserHandler userHandler, MessageHandler messageHandler){
        boolean exit = false;
        while (!exit) {
            Utils.printMenu("Depo", Map.of(
                    "1", "Megrendelés átvétele",
                    "k", "Kilépés"));
            switch (Utils.getChar()) {
                case '1':
                    Utils.printMenu("Megrendelés átvétele", Map.of());
                    // is this order should arrive to me?
                    List<Order> addressedToMe = Order.getOrdersAddressedToThisOperator(orderHandler.list,this);
                    if (addressedToMe.size() > 0) { 
                        Order currentOrder = Order.selectOrderFromList(addressedToMe);
                        currentOrder.keeperId = currentOrder.nextOperatorId;
                        currentOrder.nextOperatorId = userHandler.getFirstByType('C');
                        orderHandler.list.set(currentOrder.id-1, currentOrder);
                        messageHandler.list.add(
                        new Message(
                            messageHandler.getBiggestId()+1,
                            "Megrendelés átvettem a futártól",
                            Utils.getTime(),
                            currentOrder.keeperId,
                            currentOrder.id));
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
