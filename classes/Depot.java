package classes;

import java.util.Map;

import classes.file.JsonHandler;

public class Depot extends User{

    private int[] orderIdStock;

    public Depot(User user, JsonHandler depotHandler, JsonHandler orderHandler){
        super(user);
        printMenu(orderHandler);
    }

    private void printMenu(JsonHandler orderHandler){
        boolean exit = false;
        while (!exit) {
            ViewUtils.printMenu("Depo", Map.of(
                    "1", "Csomag átvétele",
                    "k", "Kilépés"));
            switch (ViewUtils.getChar()) {
                case '1':
                    ViewUtils.printMenu("Csomag átvétele", Map.of());
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
