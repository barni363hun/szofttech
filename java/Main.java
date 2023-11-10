import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args){
	Main obj=new Main();
	ReadFile customerList =new ReadFile("../data/database.customer.csv");
	ReadFile itemList =new ReadFile("../data/database.item.csv");

	int customerNum=customerList.getListSize();
	Customer[] customers=new Customer[customerNum];
	for(int i=0;i<customerNum;i++){
	customers[i]=new Customer(customerList.splitLine(i, customerList.token));}

	System.out.println(Arrays.toString(customers[0].getCustomer()));

	}
}