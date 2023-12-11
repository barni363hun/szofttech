package classes;

import java.util.ArrayList;
import java.util.List;

import classes.json.JsonDataClass;

public class Item extends JsonDataClass{

	public String name;
	public int price;
    
    @Override
    public List<Object> getArrayList() {
        List<Object> itemData = new ArrayList<>();
        itemData.add(id);
        itemData.add(name);
        itemData.add(price);
        return itemData;
    }

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
    
    public Item(ArrayList t) {
        this(
            ((Number) t.get(0)).intValue(),    // Assuming id is at index 0
            (String) t.get(1),                  // Assuming name is at index 1
            ((Number) t.get(2)).intValue()      // Assuming price is at index 2
        );
    }


    private static void printItem(Item item) {
        System.out.println("Product Information: ID=" + item.id + ", Name=" + item.name + ", Price=" + item.price);
    }
    
    public static void printOutItems(List<Item> items){
        for (Item item : items) {
            printItem(item);
        }
    }
    
    public static Item selectItemFromList(List<Item> items) {
        Item.printOutItems(items);
        int input;
        Item res = null; 
        while (res == null) {
            System.out.println("Adj meg egy id-t");
            input = Utils.sc.nextInt();
            for (Item item : items) {
                if (item.id == input) {
                    res = item;
                }
            }
        }
       return res;
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
