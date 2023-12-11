package classes;

import java.util.ArrayList;
import java.util.List;

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
		id = (int) (double)objArr[0];
		userName = (String) objArr[1];
		userPassword = (String) objArr[2];
		userType = (char) objArr[3];
	}

    public User(int _id, String username, String password, char type) {
		id = _id;
		userName = username;
		userPassword = password;
		userType = type;
	}

	public static List<User> getAllUsers(JsonHandler userHandler) {
        List<User> users = new ArrayList<>();

        try {
            List<Object[]> userData = userHandler.readAll();

            for (Object[] objArr : userData) {
                User user = new User(objArr); // Assuming User class has a constructor that takes Object[]
                users.add(user);
            }

        } catch (Exception e) {
            // Handle exceptions such as IO errors, parsing errors, etc.
            System.err.println("Error reading users: " + e.getMessage());
            // You might want to log the exception or take appropriate action.
        }

        return users;
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