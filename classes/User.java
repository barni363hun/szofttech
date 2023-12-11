package classes;

import java.util.ArrayList;
import java.util.List;

import classes.json.JsonDataClass;

public class User extends JsonDataClass{
	protected String userName;
	protected String userPassword;
	protected char userType;

    @Override
    public List<Object> getArrayList() {
        List<Object> itemData = new ArrayList<>();
        itemData.add(id);
        itemData.add(userName);
        itemData.add(userPassword);
        itemData.add(userType);
        return itemData;
    }

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

	public char getUserType() {
		return userType;
	}
}