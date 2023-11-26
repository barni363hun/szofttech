package classes.classes_from_data;

public class Item {
String itemName;
int itemPrice;
int itemQuantity;
boolean itemIsInquired;

Item(String[] s) {
		setItemName(s[0]);
		setItemPrice(s[1]);
		setItemQuantity(s[2]);
		setItemIsInquired(s[3]);
	}

    public void setItemName(String iN) {
		this.itemName = iN;
	}

    public void setItemPrice(String iP) {
		this.itemPrice = iP;
	}

    public void setItemQuantity(String iQ) {
		this.itemQuantity = iQ;
	}

    public void setItemIsInquired(String iII) {
		this.itemIsInquired = iII;
	}

    public String getItemName() {
		return itemName;
	}

    public String getItemPrice() {
		return itemPrice;
	}

    public String getItemQuantity() {
		return itemQuantity;
	}
    
    public String getIsInquired() {
		return itemIsInquired;
	}

}
