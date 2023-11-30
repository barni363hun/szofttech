package classes.item;

public class ItemModel {
	public int id;
	public String name;
	public int price;
	
    public void printData() {
        System.out.println("Item ID: " + id + ", Name: " + name + ", Price: $" + price);
    }
	
	public ItemModel(int id, String name, int price) {
		this.id = id;
        this.name = name;
        this.price = price;
    }
}
