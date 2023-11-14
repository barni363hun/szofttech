import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args){
	Main obj=new Main();

	ReadFile userList =new ReadFile("../data/database.user.csv");
	ReadFile customerList =new ReadFile("../data/database.customer.csv");
	ReadFile itemList =new ReadFile("../data/database.item.csv");


	Login login=new Login();
	login.setUserNameTyped(userList.getRow(userList.token,0));
	login.setUserPasswordTyped(userList.getRow(userList.token,1)[login.line]);


	User user=new User(userList.splitLine(2, userList.token));

	int customerNum=customerList.getListSize();
	Customer[] customers=new Customer[customerNum];
	for(int i=0;i<customerNum;i++){
	customers[i]=new Customer(customerList.splitLine(i, customerList.token));}

	System.out.println(Arrays.toString(user.getUser()));
	System.out.println(Arrays.toString(customers[user.getUserRowInDatabase()].getCustomer()));

	}
}
