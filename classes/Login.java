package classes;
import java.util.List;

public class Login {

	private String TypedUsername;
	private String TypedPassword;

	List<User> users;

	public Login(JsonHandler<User> userHandler) {
		users = userHandler.list;
	}

	private User getUserByUsername(String username) {
		for (User user : users) {
			if (user.userName == username) {
				return user;
			}
		}
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