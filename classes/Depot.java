package classes;

import java.util.Map;

import classes.order.OrderView;

public class Depot extends User{

    public Depot() {

        boolean exit = false;
        while (!exit) {
            ViewUtils.printMenu("Depo", Map.of(
                    "1", "Csomag átvétele",
                    "k", "Kilépés"));
            switch (ViewUtils.getChar()) {
                case '1':
                    ViewUtils.printMenu("Csomag átvétele", Map.of());
                    Order myOrder = orderView.getOrderFromUserOfKeeper(depotController.depot);
                    if (myOrder.keeper instanceof CourierModel) {
                        orderController.setOrderKeeper(myOrder.id, depotController.depot);
                    } else {
                        System.out.println("Ez a csomag nem futárnál van!");
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
    
    public DepotController(User user) {
        depot = new DepotModel(user);
    }


    public DepotModel getWareHouse() {
        return depots.getFirst();
    }
    
}
