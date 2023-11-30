package classes.roles.customer;

import java.util.LinkedList;
import classes.*;
import classes.item.ItemModel;
import classes.order.OrderModel;
import classes.user.User;



public class CustomerModel extends User{

	String customerFirstName;
	String customerLastName;
	String customerAddressZIP;
	String customerAddressTown;
	String customerAddressStreet;
	String customerPhone;
	String customerEmail;

    public LinkedList<ItemModel> cart = new LinkedList<ItemModel>();

    

	public CustomerModel(String[] s) {
		setCustomerFirstName(s[0]);
		setCustomerLastName(s[1]);
		setCustomerAddressZIP(s[2]);
		setCustomerAddressTown(s[3]);
		setCustomerAddressStreet(s[4]);
		setCustomerPhone(s[5]);
		setCustomerEmail(s[6]);
        //super(s);
	}
    public CustomerModel(User u){
        super(u);
    }

	public void setCustomerFirstName(String cFN) {
		this.customerFirstName = cFN;
	}

	public void setCustomerLastName(String cLN) {
		this.customerLastName = cLN;
	}

	public void setCustomerAddressZIP(String cAZ) {
		this.customerAddressZIP = cAZ;
	}

	public void setCustomerAddressTown(String cAT) {
		this.customerAddressTown = cAT;
	}

	public void setCustomerAddressStreet(String cAS) {
		this.customerAddressStreet = cAS;
	}

	public void setCustomerPhone(String cP) {
		this.customerPhone = cP;
	}

	public void setCustomerEmail(String cE) {
		this.customerEmail = cE;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public String getCustomerName() {
		String name = getCustomerFirstName() + " " + getCustomerLastName();
		return name;
	}

	public String getCustomerAddressZIP() {
		return customerAddressZIP;
	}

	public String getCustomerAddressTown() {
		return customerAddressTown;
	}

	public String getCustomerAddressStreet() {
		return customerAddressStreet;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public String[] getCustomer() {
		String[] customer = {
				getCustomerName(),
				getCustomerAddressZIP(),
				getCustomerAddressTown(),
				getCustomerAddressStreet(),
				getCustomerPhone(),
				getCustomerEmail() };
		return customer;
	}
}