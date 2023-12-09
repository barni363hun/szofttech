package classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import classes.file.JsonHandler;

public class Courier extends User {
    private List<Order> orders = new ArrayList<>();
    
    public Courier(User user) {
        super(user);
    }

    public void setOrders(JsonHandler orderHandler) {
        for (Object[] objArr : orderHandler.readAll()) {
            Order currOrder = new Order(objArr);
            if (currOrder.keeperId == this.id) {
                orders.add(currOrder);
            }
        }
    }

    private Order selectOrder(JsonHandler orderHandler) {
        
        Order.printOutOrders(orders);
        int input = (int)ViewUtils.getChar();
        boolean exit = false;
        while (!exit) {
            for (Order order : orders) {
                if (order.id == input) {
                    exit = true;
                    return order;
                } 
            }
        }
       return null;
    }
    
    private void CourierMenu(JsonHandler orderHandler) {

        Order currentOrder = selectOrder(orderHandler);
        boolean exit = false;
        while (!exit) {
            ViewUtils.printMenu("Courier", Map.of(
                    "1", "Csomag felvétele a raktárból",
                    "2", "Csomag kiszállítva",
                    "3", "Csomag kiszállítása sikertelen",
                    "k", "Kilépés"));
            switch (ViewUtils.getChar()) {
                case '1':
                    ViewUtils.printMenu("Csomag felvéve", Map.of());
                    currentOrder.keeperId = this.id;
                    break;
                case '2':
                    ViewUtils.printMenu("Sikeres kézbesítés", Map.of());
                    currentOrder.receiverId = currentOrder.receiverId;
                    break;
                case '3':
                    ViewUtils.printMenu("Sikertelen kézbesítés", Map.of());
                    // TODO nemtom itt mit csináljunk
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
