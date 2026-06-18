package dto;

import java.io.Serializable;

public class User implements Serializable {
	private String user_name; // ID
	private String password; // パスワード

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}

	public User() {
		this.user_name = "";
		this.password = "";
	}

}