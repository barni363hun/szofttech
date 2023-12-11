package classes;

import java.util.ArrayList;
import java.util.List;

public class User extends JsonDataClass{
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
	
    public User(int _id, String username, String password, char type) {
		id = _id;
		userName = username;
		userPassword = password;
		userType = type;
	}
	
	public User(ArrayList t) {
		this(((Number) t.get(0)).intValue(), (String) t.get(1), (String) t.get(2), ((String) t.get(3)).charAt(0));
	}


	static public void printOutUsers(List<User> users) {
        for (User user : users) {
            System.out.println("User ID: " + user.id);
            System.out.println("User Name: " + user.userName);
            System.out.println("User Password: " + user.userPassword);
            System.out.println("User Type: " + user.userType);
            System.out.println("-------------------------");
        }
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