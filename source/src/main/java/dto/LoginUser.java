package dto;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String userName; // ログイン時のユーザー名

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LoginUser(String userName) {
		this.userName = userName;
	}
	public LoginUser() {
		this.userName = "";
	}

}
