package dto;

import java.io.Serializable;

public class User implements Serializable {
	private String userId; // ユーザー名（入力）
	private String password; // パスワード（入力）
	private String qrCode;	 // QRコード画像
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public User(String userId, String password, String qrCode) {
		this.userId = userId;
		this.password = password;
		this.qrCode = qrCode;
	}
	public User() {
		this.userId = "";
		this.password = "";
		this.qrCode = "";
	}

}