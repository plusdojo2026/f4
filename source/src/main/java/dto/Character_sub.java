package dto;

import java.io.Serializable;

public class Character_sub implements Serializable{
	private int characterId;		//キャラクターID
	private int characterSubId;		//キャラクターの差分ID
	private String characterSubName;   //キャラクターの差分名
	private String characterSubImg;//キャラクターの差分画像 
	public int getCharacterId() {
		return characterId;
	}
	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}
	public int getCharacterSubId() {
		return characterSubId;
	}
	public void setCharacterSubId(int characterSubId) {
		this.characterSubId = characterSubId;
	}
	public String getCharacterSubName() {
		return characterSubName;
	}
	public void setCharacterSubName(String characterSubName) {
		this.characterSubName = characterSubName;
	}
	public String getCharacterSubImg() {
		return characterSubImg;
	}
	public void setCharacterSubImg(String characterSubImg) {
		this.characterSubImg = characterSubImg;
	}
	public Character_sub(int characterId, int characterSubId, String characterSubName, String characterSubImg) {
		super();
		this.characterId = characterId;
		this.characterSubId = characterSubId;
		this.characterSubName = characterSubName;
		this.characterSubImg = characterSubImg;
	}
	public Character_sub() {
		super();
		this.characterId = 0;
		this.characterSubId = 0;
		this.characterSubName = "";
		this.characterSubImg = "";
	}
}
