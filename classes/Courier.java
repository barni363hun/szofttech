package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import classes.json.MessageHandler;
import classes.json.OrderHandler;

public class Courier extends User {
    private List<Order> orders = new ArrayList<>();
    
    public Courier(User user) {
        super(user);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
    
    public void CourierMenu(OrderHandler orderHandler, MessageHandler messageHandler) {
        Utils.printMenu("Melyik Megrendeléssel akarsz interaktálni?", Map.of());
        Order currentOrder = Order.selectOrderFromList(orders);
        boolean exit = false;
        while (!exit) {
            Utils.printMenu("Courier", Map.of(
                    "1", "Megrendelés felvétele a raktárból",
                    "2", "Megrendelés kiszállítva",
                    "3", "Megrendelés kiszállítása sikertelen",
                    "k", "Kilépés"));
            switch (Utils.getChar()) {
                case '1':
                    Utils.printMenu("Megrendelés felvéve", Map.of());
                    currentOrder.keeperId = this.id;
                    currentOrder.nextOperatorId = currentOrder.receiverId;
                    orderHandler.list.set(currentOrder.id-1, currentOrder);
                    messageHandler.list.add(
                        new Message(
                            messageHandler.getBiggestId()+1,
                            "Megrendelést felvettem a raktárból",
                            Utils.getTime(),
                            currentOrder.keeperId,
                            currentOrder.id));
                    exit = true;
                    break;
                case '2':
                    Utils.printMenu("Sikeres kézbesítés", Map.of());
                    currentOrder.keeperId = currentOrder.receiverId;
                    orderHandler.list.set(currentOrder.id-1, currentOrder);
                    messageHandler.list.add(
                        new Message(
                            messageHandler.getBiggestId()+1,
                            "Megrendelést sikeresen kézbesítettem",
                            Utils.getTime(),
                            currentOrder.keeperId,
                            currentOrder.id));
                    exit = true;
                    break;
                case '3':
                    Utils.printMenu("Sikertelen kézbesítés", Map.of());
                    messageHandler.list.add(
                        new Message(
                            messageHandler.getBiggestId()+1,
                            "Megrendelés kézbesítetése sikertelen",
                            Utils.getTime(),
                            currentOrder.keeperId,
                            currentOrder.id));
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
