package classes.user;

public class User {
	String userName;
	String userPassword;
	char userType;
	int userRowInDatabase;

	public User(String[] s) {
		setUserName(s[0]);
		setUserPassword(s[1]);
		setUserType(s[2]);
		setUserRowInDatabase(s[3]);
	}

	public void setUserName(String uN) {
		this.userName = uN;
	}

	public void setUserPassword(String uP) {
		this.userPassword = uP;
	}

	public void setUserType(String uT) {
		this.userType = uT.charAt(0);
	}

	public void setUserRowInDatabase(String uRID) {
		this.userRowInDatabase = Integer.parseInt(uRID);
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public char getUserType() {
		return userType;
	}

	public int getUserRowInDatabase() {
		return userRowInDatabase;
	}

	public String[] getUser() {
		String[] user = {
				getUserName(),
				getUserPassword(),
				Character.toString(getUserType()),
				String.valueOf(getUserRowInDatabase()) };
		return user;
	}
}