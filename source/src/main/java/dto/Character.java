package dto;

import java.io.Serializable;

public class Character implements Serializable {
	private int characterId;		 //キャラクターID
	private String characterName;   //キャラクター名
	private String characterMainImg;//キャラクター画像  
	public int getCharacterId() {
		return characterId;
	}
	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public String getCharacterMainImg() {
		return characterMainImg;
	}
	public void setCharacterMainImg(String characterMainImg) {
		this.characterMainImg = characterMainImg;
	}
	public Character(int characterId, String characterName, String characterMainImg) {
		super();
		this.characterId = characterId;
		this.characterName = characterName;
		this.characterMainImg = characterMainImg;
	}
	public Character() {
		this.characterId = 0;
		this.characterName = "";
		this.characterMainImg = "";
	}
	 

}
