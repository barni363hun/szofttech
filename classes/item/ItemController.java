package classes.item;

import java.util.LinkedList;

public class ItemController {
    public LinkedList<ItemModel> items = new LinkedList<ItemModel>();

    public ItemController(){}
    
    public void addItemToList(ItemModel item){
        items.add(item);
    }

    public LinkedList<ItemModel> getItems(){
        return items;
    }
}
