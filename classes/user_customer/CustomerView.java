package classes.user_customer;

import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import classes.ViewUtils;
import classes.item.ItemController;
import classes.item.ItemModel;
import classes.item.Item;
import classes.order.OrderController;
import classes.order.OrderModel;
import classes.user_depot.DepotController;

public class CustomerView {

    ViewUtils viewUtils = null;
    Scanner sc = new Scanner(System.in);

    CustomerController customerController = null;
    ItemController itemController = null;
    OrderController orderController = null;
    DepotController depotController = null;


    public CustomerView(
        CustomerController _customerController, 
        ItemController _itemController,
        OrderController _orderController,
        DepotController _depotController) {

        customerController = _customerController;
        itemController = _itemController;
        orderController = _orderController;
        depotController = _depotController;
        
        boolean exit = false;
        while (!exit) {
            ViewUtils.printMenu("Customer", Map.of(
                    // "1", "Csomaghoz tartozó üzenetek lekérdezése",
                    "2", "Termék kosárba rakása",
                    "3", "Termék törlése a kosárból",
                    "4", "Kosár tartalmának megtekintése",
                    "5", "Kosár tartalmának megrendelése",
                    "k", "Kilépés"));
            switch (ViewUtils.getChar()) {
                case '2':
                    ViewUtils.printMenu("Termék kosárba rakása", Map.of("k", "Kilépés"));
                    ItemModel item = new Item(itemController).getItemFromUser();
                    customerController.customer.cart.add(item);
                case '3':
                    ViewUtils.printMenu("Termék törlése a kosárból", Map.of("k", "Kilépés"));
                    customerController.customer.cart.remove(selectItemFromCart());
                    break;
                case '4':
                    ViewUtils.printMenu("Kosár tartalmának megtekintése", Map.of());
                    listCart();
                    break;
                case '5':
                    ViewUtils.printMenu("Kosár tartalmának megrendelése", Map.of());
                    // TODO id így maradjon?
                    int id = new Random().nextInt(1000,Integer.MAX_VALUE);
                    orderController.orders.add(new OrderModel(
                        id, 
                        depotController.getWareHouse(),
                        selectRecieverFromCustomers(),
                        customerController.customer.cart));
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

    private CustomerModel selectRecieverFromCustomers(){
        //TODO return a customer
        return customerController.customer;
    }

    private ItemModel selectItemFromCart(){
        listCart();
        ViewUtils.printMenu("Adja meg a termék id-jét", Map.of("k", "Kilépés"));
        String bemenet = sc.nextLine();
        LinkedList<ItemModel> list = customerController.customer.cart;
        if (bemenet != "k"){
            for (int i = 0; i < list.size(); i++) {
                if (Integer.toString(list.get(i).id) == bemenet){
                    return list.get(i);
                }
            }
        }
        ViewUtils.printMenu("Hibás érték", Map.of());
        return null;
    }

    public void listCart() {
       LinkedList<ItemModel> tempCart = customerController.customer.cart;
        for (int i = 0; i < tempCart.size(); i++) {
            System.out.println(
                    "Item ID: " + tempCart.get(i).id + ", Name: " + tempCart.get(i).name + ", Price: $" + tempCart.get(i).price);
        }
    }


}
