package dto;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String userId; // ログイン時のユーザー名

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LoginUser(String userId) {
		this.userId = userId;
	}
	public LoginUser() {
		this.userId = "";
	}

}
