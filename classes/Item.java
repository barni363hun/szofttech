package classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import classes.file.JsonHandler;

public class Item {

	public int id;
	public String name;
	public int price;
    public boolean isInquired;

    static private JsonHandler items = new JsonHandler("items.json");

    static Scanner sc = new Scanner(System.in);

    public Item(int _id, String _name, int _price,boolean _isInquired) {
        id = _id;
        name = _name;
        price = _price;
        isInquired = _isInquired;
    }
    
    public void addItemToList(int id, String name, int price){
        items.create(new Object[]{id, name, price,false});
    }

    public List<Object[]> getItems(){
        return items.readAll();
    }
    
    public void getItemFromUser() {
        items.printItems();
        // boolean exit = false;
        // while (!exit) {
        //     ViewUtils.printMenu("Adja meg a termék id-jét", Map.of());
        //     String bemenet = sc.next();
        //     for (int i = 0; i < items.size(); i++) {
        //         if (Integer.toString(items.readById(i)[0]) == bemenet){
        //             return items.readById(i);
        //         }
        //     }
        // ViewUtils.printMenu("Hibás érték", Map.of());
        // }
        // return null;
    }
    
}
