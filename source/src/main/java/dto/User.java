package dto;

import java.io.Serializable;

public class User implements Serializable {
	private int userId;		 // 自動採番
	private String userName; // ユーザー名（入力）
	private String password; // パスワード（入力）
	private String qrCode;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public User(int userId, String userName, String password, String qrCode) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.qrCode = qrCode;
	}
	public User() {
		this.userId = 0;
		this.userName = "";
		this.password = "";
		this.qrCode = "";
	}
}