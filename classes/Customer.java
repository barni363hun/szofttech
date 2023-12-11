package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import classes.json.ItemHandler;
import classes.json.JsonHandler;
import classes.json.OrderHandler;
import classes.json.UserHandler;

public class Customer extends User{

    public List<Item> cart = new ArrayList<>();
	// String customerFirstName;
	// String customerLastName;
	// String customerAddressZIP;
	// String customerAddressTown;
	// String customerAddressStreet;
	// String customerPhone;
	// String customerEmail;

    // public LinkedList<ItemModel> cart = new LinkedList<ItemModel>();

	public Customer(User u){
        super(u);
    }

    // public Customer(Object[] objArr) {
    //     super(objArr);
    // }
	// public Customer(String[] s) {
	// 	setCustomerFirstName(s[0]);
	// 	setCustomerLastName(s[1]);
	// 	setCustomerAddressZIP(s[2]);
	// 	setCustomerAddressTown(s[3]);
	// 	setCustomerAddressStreet(s[4]);
	// 	setCustomerPhone(s[5]);
	// 	setCustomerEmail(s[6]);
    //     //super(s);
	// }

    //TODO - Itemeket így kapja meg?
	public void CustomerMenu(ItemHandler itemHandler, OrderHandler orderHandler, UserHandler userHandler){
      
        boolean exit = false;
        while (!exit) {
            Utils.printMenu("Customer", Map.of(
                    // "1", "Csomaghoz tartozó üzenetek lekérdezése",
                    "1", "Termék kosárba rakása",
                    "2", "Termék törlése a kosárból",
                    "3", "Kosár tartalmának megtekintése",
                    "4", "Kosár tartalmának megrendelése",
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
                    Order o = new Order(orderHandler.getBiggestId(),userHandler.getFirstByType('D'),id,userHandler.getFirstByType('C'),itemIds);
                    orderHandler.list.add(o);
                    orderHandler.writeAllToJsonFile();
                    cart.clear();
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

    // private ItemModel selectItemFromCart(){
    //     listCart();
    //     Utils.printMenu("Adja meg a termék id-jét", Map.of("k", "Kilépés"));
    //     String bemenet = sc.nextLine();
    //     LinkedList<ItemModel> list = customerController.customer.cart;
    //     if (bemenet != "k"){
    //         for (int i = 0; i < list.size(); i++) {
    //             if (Integer.toString(list.get(i).id) == bemenet){
    //                 return list.get(i);
    //             }
    //         }
    //     }
    //     Utils.printMenu("Hibás érték", Map.of());
    //     return null;
    // }

    // public void listCart() {
    //    LinkedList<ItemModel> tempCart = customerController.customer.cart;
    //     for (int i = 0; i < tempCart.size(); i++) {
    //         System.out.println(
    //                 "Item ID: " + tempCart.get(i).id + ", Name: " + tempCart.get(i).name + ", Price: $" + tempCart.get(i).price);
    //     }
    // }

	
    // public CustomerController(User user) {
    //     customer = new Customer(user);
    //     customers = new LinkedList<Customer>();
    //     FileRead customerList = new FileRead("customer");
    //     for (int i = 1; i < customerList.getListSize(); i++) {
    //                 String temp[] = customerList.splitLine(i);
    //     }

    // }

    // public Customer selectFromCustomers() {
    //     // eze undorító
    //     System.out.println("Kerem a vevo nevet: ");
    //     String name = sc.next();
    //     Boolean exit = false;
    //     while (!exit) {
    //         for (Customer e : customers) {
    //             if (e.getUserName().equals(name)) {
    //                 exit = true;
    //                 return  e;
    //             }
    //         }
    //         // if(ret == null) {
    //             System.out.println("\nNincs talalat!\nKerem a vevo nevet: ");
    //             name = sc.next();
    //         // }
    //     }
    //     return null; //null
    // }

	// public void setCustomerFirstName(String cFN) {
	// 	this.customerFirstName = cFN;
	// }

	// public void setCustomerLastName(String cLN) {
	// 	this.customerLastName = cLN;
	// }

	// public void setCustomerAddressZIP(String cAZ) {
	// 	this.customerAddressZIP = cAZ;
	// }

	// public void setCustomerAddressTown(String cAT) {
	// 	this.customerAddressTown = cAT;
	// }

	// public void setCustomerAddressStreet(String cAS) {
	// 	this.customerAddressStreet = cAS;
	// }

	// public void setCustomerPhone(String cP) {
	// 	this.customerPhone = cP;
	// }

	// public void setCustomerEmail(String cE) {
	// 	this.customerEmail = cE;
	// }

	// public String getCustomerFirstName() {
	// 	return customerFirstName;
	// }

	// public String getCustomerLastName() {
	// 	return customerLastName;
	// }

	// public String getCustomerName() {
	// 	String name = getCustomerFirstName() + " " + getCustomerLastName();
	// 	return name;
	// }

	// public String getCustomerAddressZIP() {
	// 	return customerAddressZIP;
	// }

	// public String getCustomerAddressTown() {
	// 	return customerAddressTown;
	// }

	// public String getCustomerAddressStreet() {
	// 	return customerAddressStreet;
	// }

	// public String getCustomerPhone() {
	// 	return customerPhone;
	// }

	// public String getCustomerEmail() {
	// 	return customerEmail;
	// }

	// public String[] getCustomer() {
	// 	String[] customer = {
	// 			getCustomerName(),
	// 			getCustomerAddressZIP(),
	// 			getCustomerAddressTown(),
	// 			getCustomerAddressStreet(),
	// 			getCustomerPhone(),
	// 			getCustomerEmail() };
	// 	return customer;
	// }
}