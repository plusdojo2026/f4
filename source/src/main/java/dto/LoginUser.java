package dto;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String user_name; // ログイン時のID

	public String getId() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public LoginUser() {
		this(null);
	}

	public LoginUser(String user_name) {
		this.user_name = user_name;
	}
}
