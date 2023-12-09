package classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import classes.file.JsonHandler;


import classes.*;




public class Customer extends User{

    private List<Order> orders = new ArrayList<>();
    public List<Integer> cart = new ArrayList<>();
	String customerFirstName;
	String customerLastName;
	String customerAddressZIP;
	String customerAddressTown;
	String customerAddressStreet;
	String customerPhone;
	String customerEmail;

	
    ViewUtils viewUtils = null;
    Scanner sc = new Scanner(System.in);

    // public LinkedList<ItemModel> cart = new LinkedList<ItemModel>();

	public Customer(User u){
        super(u);
    }
	
	public Customer(String[] s) {
		setCustomerFirstName(s[0]);
		setCustomerLastName(s[1]);
		setCustomerAddressZIP(s[2]);
		setCustomerAddressTown(s[3]);
		setCustomerAddressStreet(s[4]);
		setCustomerPhone(s[5]);
		setCustomerEmail(s[6]);
        //super(s);
	}

    //TODO - Itemeket így kapja meg?
	public void CustomerMenu(JsonHandler customerHandler, JsonHandler itemHandler){
      
        boolean exit = false;
        while (!exit) {
            ViewUtils.printMenu("Customer", Map.of(
                    // "1", "Csomaghoz tartozó üzenetek lekérdezése",
                    "2", "Termék kosárba rakása",
                    "3", "Termék törlése a kosárból",
                    "4", "Kosár tartalmának megtekintése",
                    "5", "Kosár tartalmának megrendelése",
                    "k", "Kilépés"));
            switch (ViewUtils.getChar()) {
                case '2':
                    ViewUtils.printMenu("Termék kosárba rakása", Map.of("k", "Kilépés"));
                    
                    // ItemModel item = new Item(itemController).getItemFromUser();
                    // customerController.customer.cart.add(item);
                case '3':
                    ViewUtils.printMenu("Termék törlése a kosárból", Map.of("k", "Kilépés"));
                    
                    
                    // customerController.customer.cart.remove(selectItemFromCart());
                    break;
                case '4':
                    ViewUtils.printMenu("Kosár tartalmának megtekintése", Map.of());
                    // listCart();
                    break;
                case '5':
                    ViewUtils.printMenu("Kosár tartalmának megrendelése", Map.of());
                    // TODO id így maradjon?
                //     int id = new Random().nextInt(1000,Integer.MAX_VALUE);
                //     orderController.orders.add(new Order(
                //         id, 
                //         depotController.getWareHouse(),
                //         selectRecieverFromCustomers(),
                //         customerController.customer.cart));
                //     break;
                // case 'k':
                //     exit = true;
                //     break;
                // default:
                //     System.out.println("Nincs ilyen menüpont!");
                    break;
            }
        }
    }


	
    private Customer selectRecieverFromCustomers(){
        //TODO return a customer
        return customerController.customer;
    }

    private ItemModel selectItemFromCart(){
        listCart();
        ViewUtils.printMenu("Adja meg a termék id-jét", Map.of("k", "Kilépés"));
        String bemenet = sc.nextLine();
        LinkedList<ItemModel> list = customerController.customer.cart;
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

    public void listCart() {
       LinkedList<ItemModel> tempCart = customerController.customer.cart;
        for (int i = 0; i < tempCart.size(); i++) {
            System.out.println(
                    "Item ID: " + tempCart.get(i).id + ", Name: " + tempCart.get(i).name + ", Price: $" + tempCart.get(i).price);
        }
    }

	
    public CustomerController(User user) {
        customer = new Customer(user);
        customers = new LinkedList<Customer>();
        FileRead customerList = new FileRead("customer");
        for (int i = 1; i < customerList.getListSize(); i++) {
                    String temp[] = customerList.splitLine(i);
        }

    }

    public Customer selectFromCustomers() {
        // eze undorító
        System.out.println("Kerem a vevo nevet: ");
        String name = sc.next();
        Boolean exit = false;
        while (!exit) {
            for (Customer e : customers) {
                if (e.getUserName().equals(name)) {
                    exit = true;
                    return  e;
                }
            }
            // if(ret == null) {
                System.out.println("\nNincs talalat!\nKerem a vevo nevet: ");
                name = sc.next();
            // }
        }
        return null; //null
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