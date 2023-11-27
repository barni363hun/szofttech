package classes.classes_from_data;

public class Item {
	String itemName;
	int itemPrice;
	int itemQuantity;
	boolean itemIsInquired;

	protected Item(String[] s) {
		setItemName(s[0]);
		setItemPrice(s[1]);
		setItemQuantity(s[2]);
		setItemIsInquired(s[3]);
	}
	
    public void printData() {
        String dataString = String.format("Item Name: %s, Item Price: $%d, Item Quantity: %d, Item Inquired: %s",
                itemName, itemPrice, itemQuantity, itemIsInquired ? "Yes" : "No");
        System.out.println(dataString);
    }

	public void setItemName(String iN) {
		this.itemName = iN;
	}

	public void setItemPrice(String iP) {
		this.itemPrice = Integer.parseInt(iP);
	}

	public void setItemQuantity(String iQ) {
		this.itemQuantity = Integer.parseInt(iQ);
	}

	public void setItemIsInquired(String iII) {
		this.itemIsInquired = Boolean.parseBoolean(iII);
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public Boolean getIsInquired() {
		return itemIsInquired;
	}

}
