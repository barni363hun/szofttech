package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import classes.json.OrderHandler;

public class Courier extends User {
    private List<Order> orders = new ArrayList<>();
    
    public Courier(User user) {
        super(user);
    }

    public int getId(){
        return this.id;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
    
    public void CourierMenu(OrderHandler orderHandler) {
        Utils.printMenu("Melyik csomaggal akarsz interaktálni?", Map.of());
        Order currentOrder = Order.selectOrderFromList(orders);
        boolean exit = false;
        while (!exit) {
            Utils.printMenu("Courier", Map.of(
                    "1", "Csomag felvétele a raktárból",
                    "2", "Csomag kiszállítva",
                    "3", "Csomag kiszállítása sikertelen",
                    "k", "Kilépés"));
            switch (Utils.getChar()) {
                case '1':
                    Utils.printMenu("Csomag felvéve", Map.of());
                    currentOrder.keeperId = this.id;
                    currentOrder.nextOperatorId = currentOrder.receiverId;
                    orderHandler.list.set(currentOrder.id-1, currentOrder);
                    exit = true;
                    break;
                case '2':
                    Utils.printMenu("Sikeres kézbesítés", Map.of());
                    currentOrder.keeperId = currentOrder.receiverId;
                    orderHandler.list.set(currentOrder.id-1, currentOrder);
                    exit = true;
                    break;
                case '3':
                    Utils.printMenu("Sikertelen kézbesítés", Map.of());
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
