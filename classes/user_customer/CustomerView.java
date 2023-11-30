package classes.roles.customer;

import classes.classes_from_data.User;

public class CustomerView {

    CustomerController customerController = null;
    ItemView itemView = null;
    ViewUtils viewUtils = null;

    public CustomerView(User user, ItemView iv) {
        customerController = new CustomerController(user);
        itemView = iv;
        customerMenu();
    }

    public void customerMenu(){

        boolean exit = false;
                while (!exit) {
                    printMenu("Customer", Map.of(
                            // "1", "Csomaghoz tartozó üzenetek lekérdezése",
                            "2", "Termék kosárba rakása",
                            "3", "Termék törlése a kosárból",
                            "4", "Kosár tartalmának megtekintése",
                            "5", "Kosár tartalmának megrendelése",
                            "k", "Kilépés"));
                    switch (getChar()) {
                        case '2':
                            printMenu("Termék kosárba rakása", Map.of("k", "Kilépés"));
                            String itemId = itemView.getItemById();
                            Item item = itemController.getItemById(itemId);
                            customerController.addToCart(item);
                            customerController.addToCart();
                            // c.cart.add(getItemById());
                        case '3':
                            printMenu("Termék törlése a kosárból", Map.of("k", "Kilépés"));
                            customerController.listCart();
                            customerController.removeFromCart();
                            // c.cart.remove(getItemById());
                            break;
                        case '4':
                            printMenu("Kosár tartalmának megtekintése", Map.of());
                            customerController.listCart();
                            break;
                        case '5':
                            printMenu("Kosár tartalmának megrendelése", Map.of());
                            customerController.sendOrder();
                            // orders.add(new Order(random.nextInt(1000,Integer.MAX_VALUE), depots.getFirst(), c, c.cart));
                            break;
                        case 'k':
                            exit = true;
                            break;
                        default:
                            System.out.println("Nincs ilyen menüpont!");
                            break;

                    }
                }
        

        //adott menüpont alatt
        // itemek kijelzése

        //
        Order o = orderView.readItem();

        setKeeperToValaki()

    }

}
