package classes;

import java.util.ArrayList;
import java.util.List;

public class Item {

	public int id;
	public String name;
	public int price;

     public Item(Object[] objectArray) {
        this.id = (int) objectArray[0];
        this.name = (String) objectArray[1];
        this.price = (int) objectArray[2];

    }

    public Item(int _id, String _name, int _price) {
        id = _id;
        name = _name;
        price = _price;
    }
    
    private static void printItem(Item item) {
        System.out.println("Product Information: ID=" + item.id + ", Name=" + item.name + ", Price=" + item.price);
    }
    
    public static void printOutItems(List<Item> items){
        for (Item item : items) {
            printItem(item);
        }
    }
    
    public static List<Item> getAllItems(JsonHandler itemHandler){
        List<Item> items = new ArrayList<>();
        for (Object[] objArr : itemHandler.readAll()) {
            items.add(new Item(objArr));
        }
        return items;
    }
    
    public static Item selectItemFromList(List<Item> items) {
        Item.printOutItems(items);
        int input;
        boolean exit = false;
        while (!exit) {
            input = (int)Utils.getChar();
            for (Item item : items) {
                if (item.id == input) {
                    return item;
                } 
            }
        }
       return null;
    }
    
    // public void addItemToList(int id, String name, int price){
    //     items.create(new Object[]{id, name, price,false});
    // }

    // public List<Object[]> getItems(){
    //     return items.readAll();
    // }
    
    // public void getItemFromUser() {
    //     items.printItems();
        // boolean exit = false;
        // while (!exit) {
        //     Utils.printMenu("Adja meg a termék id-jét", Map.of());
        //     String bemenet = sc.next();
        //     for (int i = 0; i < items.size(); i++) {
        //         if (Integer.toString(items.readById(i)[0]) == bemenet){
        //             return items.readById(i);
        //         }
        //     }
        // Utils.printMenu("Hibás érték", Map.of());
        // }
        // return null;
    // }
    
}
