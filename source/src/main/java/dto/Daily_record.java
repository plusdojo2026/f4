package dto;

import java.io.Serializable;
import java.util.Date;

public class Daily_record implements Serializable {
	private int userId; // ユーザーID
	private int characterId; // キャラクターID
	private int body; // からだ
	private int mind; // きもち
	private Date createDate; // 日付
	private String defaultScreenShot; //　初期スクリーンショット画像
	private String editScreenShot; //　らくがき後スクリーンショット画像
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCharacterId() {
		return characterId;
	}
	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}
	public int getBody() {
		return body;
	}
	public void setBody(int body) {
		this.body = body;
	}
	public int getMind() {
		return mind;
	}
	public void setMind(int mind) {
		this.mind = mind;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDefaultScreenShot() {
		return defaultScreenShot;
	}
	public void setDefaultScreenShot(String defaultScreenShot) {
		this.defaultScreenShot = defaultScreenShot;
	}
	public String getEditScreenShot() {
		return editScreenShot;
	}
	public void setEditScreenShot(String editScreenShot) {
		this.editScreenShot = editScreenShot;
	}
	public Daily_record(int userId, int characterId, int body, int mind, Date createDate, String defaultScreenShot,
			String editScreenShot) {
		super();
		this.userId = userId;
		this.characterId = characterId;
		this.body = body;
		this.mind = mind;
		this.createDate = createDate;
		this.defaultScreenShot = defaultScreenShot;
		this.editScreenShot = editScreenShot;
	}
	public Daily_record() {
		super();
		this.userId = 0;
		this.characterId = 0;
		this.body = 0;
		this.mind = 0;
		this.createDate = null;
		this.defaultScreenShot = "";
		this.editScreenShot = "";
	}
	
	//松野追加
	public Daily_record(Date createDate) {
		this.createDate=createDate;
	}
}
