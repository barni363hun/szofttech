package classes;

public class User {
	protected int id;
	protected String userName;
	protected String userPassword;
	protected char userType;

	public User(User u){
		id = u.id;
		userName = u.userName;
		userPassword = u.userPassword;
		userType = u.userType;
	}
	
	public User(Object[] objArr){
		id = (int) objArr[0];
		userName = (String) objArr[1];
		userPassword = (String) objArr[2];
		userType = (char) objArr[3];
	}

	// public User(String[] s) {
	// 	this.id = Integer.parseInt(s[0]);
	// 	setUserName(s[1]);
	// 	setUserPassword(s[2]);
	// 	setUserType(s[3]);
	// 	setUserRowInDatabase(s[4]);
	// }

	// public void setUserName(String uN) {
	// 	this.userName = uN;
	// }

	// public void setUserPassword(String uP) {
	// 	this.userPassword = uP;
	// }

	// public void setUserType(String uT) {
	// 	this.userType = uT.charAt(0);
	// }

	// public void setUserRowInDatabase(String uRID) {
	// 	this.userRowInDatabase = Integer.parseInt(uRID);
	// }

	// public String getUserName() {
	// 	return userName;
	// }

	// public String getUserPassword() {
	// 	return userPassword;
	// }

	public char getUserType() {
		return userType;
	}

	// public int getUserRowInDatabase() {
	// 	return userRowInDatabase;
	// }

	// public String[] getUser() {
	// 	String[] user = {
	// 			getUserName(),
	// 			getUserPassword(),
	// 			Character.toString(getUserType()),
	// 			String.valueOf(getUserRowInDatabase()) };
	// 	return user;
	// }
}