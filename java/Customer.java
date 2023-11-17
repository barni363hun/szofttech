class Customer{
String customerID;
String customerFirstName;
String customerLastName;
String customerAddressZIP;
String customerAddressTown;
String customerAddressStreet;
String customerPhone;
String customerEmail;
Customer(String[] s){
	setCustomerID(s[0]);
	setCustomerFirstName(s[1]);
	setCustomerLastName(s[2]);
	setCustomerAddressZIP(s[3]);
	setCustomerAddressTown(s[4]);
	setCustomerAddressStreet(s[5]);
	setCustomerPhone(s[6]);
	setCustomerEmail(s[7]);}
public void setCustomerID(String cID){
	this.customerID=cID;}
public void setCustomerFirstName(String cFN){
	this.customerFirstName=cFN;}
public void setCustomerLastName(String cLN){
	this.customerLastName=cLN;}
public void setCustomerAddressZIP(String cAZ){
	this.customerAddressZIP=cAZ;}
public void setCustomerAddressTown(String cAT){
	this.customerAddressTown=cAT;}
public void setCustomerAddressStreet(String cAS){
	this.customerAddressStreet=cAS;}
public void setCustomerPhone(String cP){
	this.customerPhone=cP;}
public void setCustomerEmail(String cE){
	this.customerEmail=cE;}
public String getCustomerID(){
	return customerID;}
public String getCustomerFirstName(){
	return customerFirstName;}
public String getCustomerLastName(){
	return customerLastName;}
public String getCustomerName(){
	String name=getCustomerFirstName()+" "+getCustomerLastName();
	return name;}
public String getCustomerAddressZIP(){
	return customerAddressZIP;}
public String getCustomerAddressTown(){
	return customerAddressTown;}
public String getCustomerAddressStreet(){
	return customerAddressStreet;}
public String getCustomerPhone(){
	return customerPhone;}
public String getCustomerEmail(){
	return customerEmail;}
public String[] getCustomer(){
	String[] customer={
	getCustomerID(),
	getCustomerName(),
	getCustomerAddressZIP(),
	getCustomerAddressTown(),
	getCustomerAddressStreet(),
	getCustomerPhone(),
	getCustomerEmail()};
	return customer;}
}