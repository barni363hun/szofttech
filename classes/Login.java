package classes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Login {

	private String TypedUsername;
	private String TypedPassword;

	LinkedList<User> users = new LinkedList<User>();

	public Login(UserHandler userHandler) {
		// users = ;
		
		User a = userHandler.list.get(0);
		System.out.println(a.getClass());

	}

	private User getUserByUsername(String username) {
		// for (int i = 0; i < users.size(); i++) {
		// 	User currentUser = users.get(i);
		// 	if (.userName.equals(username)) {
		// 		return users.get(i);
		// 	}
		// }
		return null; 
	}

	public User getPasswordFromUser() {
		char[] userPasswordMasked = System.console().readPassword("Enter your Password: ");
		for (int i = 0; i < userPasswordMasked.length; i++) {
			System.out.print("*");
		}
		System.out.println("");
		this.TypedPassword = String.valueOf(userPasswordMasked);
		User currUser = getUserByUsername(TypedUsername);
		if (currUser.userPassword == TypedPassword) {
			System.out.println("You are now logged in!");
			return currUser;
		} else {
			System.out.println("Wrong Password!");
			this.getPasswordFromUser();
		}
		return null;
	}

	public void getUserNameFromUser() {
		// TODO sztem szebb lenne loop-al
		System.out.print("Enter your User Name: ");
		this.TypedUsername = Utils.sc.nextLine();
		if (getUserByUsername(TypedUsername) != null) {
			System.out.println("User found!");
		} else {
			System.out.println("User named '" + this.TypedUsername + "' does not exists!");
			this.getUserNameFromUser();
		}
	}

}