package classes.user_depot;

import java.util.Map;

import classes.ViewUtils;
import classes.order.OrderController;
import classes.order.OrderModel;
import classes.order.OrderView;
import classes.user.User;
import classes.user_courier.CourierModel;

public class DepotView {

    DepotController depotController = null;
    OrderController orderController = null;

    public DepotView(DepotController _depotController,OrderController _orderController) {
        depotController = _depotController;
        orderController = _orderController;
        boolean exit = false;
        while (!exit) {
            ViewUtils.printMenu("Depo", Map.of(
                    "1", "Csomag átvétele",
                    "k", "Kilépés"));
            switch (ViewUtils.getChar()) {
                case '1':
                    ViewUtils.printMenu("Csomag átvétele", Map.of());
                    OrderModel myOrder = new OrderView(orderController).getOrderFromUserOfKeeper(depotController.depot);
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
}
