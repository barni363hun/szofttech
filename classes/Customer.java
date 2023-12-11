package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import classes.json.ItemHandler;
import classes.json.MessageHandler;
import classes.json.OrderHandler;
import classes.json.UserHandler;

public class Customer extends User{

    public List<Item> cart = new ArrayList<>();

	public Customer(User u){
        super(u);
    }

	public void CustomerMenu(ItemHandler itemHandler, OrderHandler orderHandler, UserHandler userHandler, MessageHandler messageHandler){
      
        boolean exit = false;
        while (!exit) {
            Utils.printMenu("Customer", Map.of(
                    // "1", "Megrendeléshez tartozó üzenetek lekérdezése",
                    "1", "Termék kosárba rakása",
                    "2", "Termék törlése a kosárból",
                    "3", "Kosár tartalmának megtekintése",
                    "4", "Kosár tartalmának megrendelése",
                    "5", "Megrendeléseim listázása",
                    "6", "Megrendeléshez tartozó üzenetek lekérdezése",
                    "k", "Kilépés"));
            switch (Utils.getChar()) {
                case '1':
                    Utils.printMenu("Termék kosárba rakása", Map.of());
                    Item addItem = Item.selectItemFromList(itemHandler.list);
                    cart.add(addItem);
                    break;
                case '2':
                    Utils.printMenu("Termék törlése a kosárból", Map.of());
                    cart.remove(Item.selectItemFromList(cart));
                    break;
                case '3':
                    Utils.printMenu("Kosár tartalmának megtekintése", Map.of());
                    Item.printOutItems(cart);
                    break;
                case '4':
                    Utils.printMenu("Kosár tartalmának megrendelése", Map.of());
                    int[] itemIds = new int[cart.size()];
                    for (int i = 0; i < cart.size(); i++) {
                        itemIds[i] = cart.get(i).id;
                    }
                    Order newOrder = new Order(orderHandler.getBiggestId()+1,userHandler.getFirstByType('D'),id,userHandler.getFirstByType('C'),itemIds);
                    orderHandler.list.add(newOrder);
                    orderHandler.writeAllToJsonFile();
                    cart.clear();
                    messageHandler.list.add(
                        new Message(
                            messageHandler.getBiggestId()+1,
                            "Megrendelés létrejött",
                            Utils.getTime(),
                            newOrder.keeperId,
                            newOrder.id));
                    break;
                case '5':
                    Utils.printMenu("Megrendeléseim listázása", Map.of());
                    orderHandler.list.stream().filter(fo -> fo.receiverId == id).forEach(fo -> fo.printData());
                    break;
                case '6':
                    Utils.printMenu("Megrendeléshez tartozó üzenetek lekérdezése", Map.of());
                    Utils.printMenu("Melyik Megrendelést szeretnéd lekérdezni?", Map.of());
                    Order currentOrder = Order.selectOrderFromList(orderHandler.list.stream().filter(fo -> fo.receiverId == id).collect(Collectors.toList()));
                    messageHandler.list.stream().filter(fm -> fm.orderId == currentOrder.id).forEach(fm -> fm.printData());
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