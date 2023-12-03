package classes.user_courier;

import java.util.Map;

import classes.ViewUtils;
import classes.order.OrderController;
import classes.order.OrderModel;
import classes.order.OrderView;

public class CourierView {

    CourierController courierController = null;
    OrderController orderController = null;

    public CourierView(CourierController _courierController,OrderController _orderController) {
        courierController = _courierController;
        orderController = _orderController;

        OrderView orderView=new OrderView(orderController);
        OrderModel currentOrder = orderView.getOrderFromUser(courierController.getMyOrders(orderController));
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
}
