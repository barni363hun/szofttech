package classes;

import java.util.LinkedList;
import java.util.Map;

public class Courier extends User{

    
    public CourierMenu() {

        
        Order currentOrder = orderView.getOrderFromUser(courierController.getMyOrders(orderController));
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
                    currentOrder.keeper = courierController.courier;
                    break;
                case '2':
                    ViewUtils.printMenu("Sikeres kézbesítés", Map.of());
                    currentOrder.keeper = currentOrder.receiver;
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

    
    // public void addToCourier(CourierModel u) {
    //     couriers.add(u);
    // }

    public LinkedList<Order> getMyOrders(OrderController orderController){
        return orderController.getOrdersOfKeeper(courier);
    }
}