package classes.file;

import java.io.Console;
import java.util.Scanner;

public class Login {

	public String userNameTyped;
	public String userPasswordTyped;
	public int line;

	public User loadUser(){
		FileRead userList = new FileRead("user");
		this.setUserNameTyped(userList.getRow(0));
		this.setUserPasswordTyped(userList.getRow(1)[this.line]);
		User user = new User(userList.splitLine(this.line));
		return user;
	}

	public void setUserNameTyped(String[] s) {

		System.out.print("Enter your User Name: ");
		Scanner sc = new Scanner(System.in);
		this.userNameTyped = sc.nextLine();
		if (nameCheck(s) == false) {
			System.out.println("User named '" + this.userNameTyped + "' does not exists!");
			this.setUserNameTyped(s);
		} else {
			System.out.println("User found!");
		}
	}

	public boolean nameCheck(String[] s) {
		for (int i = 1; i < s.length; i++) {
			if (this.userNameTyped.equalsIgnoreCase(s[i])) {
				this.line = i;
				return true;
			}
		}
		return false;
	}

	public void setUserPasswordTyped(String s) {

		char[] userPasswordMasked = System.console().readPassword("Enter your Password: ");
		for (int i = 0; i < userPasswordMasked.length; i++) {
			System.out.print("*");
		}
		System.out.println("");
		this.userPasswordTyped = String.valueOf(userPasswordMasked);
		if (passwordCheck(s) == false) {
			System.out.println("Wrong Password!");
			this.setUserPasswordTyped(s);
		} else {
			System.out.println("You are now logged in!");
		}

	}

	public boolean passwordCheck(String s) {
		if (this.userPasswordTyped.equals(s)) {
			return true;
		}
		return false;
	}

}