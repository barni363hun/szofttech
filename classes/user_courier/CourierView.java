package classes.user_courier;

import java.util.Map;

import classes.ViewUtils;
import classes.item.ItemView;
import classes.order.OrderController;
import classes.user.User;

public class CourierView {

    public CourierView() {}

    private void courierMenu(CourierController courierController,OrderController orderController) {

        // BARNI IN PROGRESS

        courierController.courier.
        Order currentOrder = orderController.getOrderById();
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
                    currentOrder.keeper = currentCourier;
                    break;
                case '2':
                    ViewUtils.printMenu("Sikeres kézbesítés", Map.of());
                    currentOrder.keeper = currentOrder.receiver;
                    break;
                case '3':
                    ViewUtils.printMenu("Sikertelen kézbesítés", Map.of());
                    currentOrder.keeper = depots.getFirst();
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
