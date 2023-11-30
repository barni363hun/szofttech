package classes.item;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import classes.ViewUtils;

public class ItemView {

    ItemController itemController = null;
    Scanner sc = new Scanner(System.in);

    public ItemView(ItemController _itemController) {
        itemController = _itemController;
    }
    public ItemModel getItemFromUser() {
        // TODO possibly null
        // melyik item-el szeretnél dolgozni
        printData();
        ViewUtils.printMenu("Adja meg a termék id-jét", Map.of("k", "Kilépés"));
        String bemenet = sc.nextLine();
        LinkedList<ItemModel> list = itemController.getItems();
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

    public void printData() {
        LinkedList<ItemModel> list = itemController.getItems();
        for (int i = 0; i < list.size(); i++) {

            System.out.println(
                    "Item ID: " + list.get(i).id + ", Name: " + list.get(i).name + ", Price: $" + list.get(i).price);
        }

    }
}
