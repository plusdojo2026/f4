package dto;

import java.io.Serializable;

public class Item implements Serializable{
	private int itemId;			//アイテムID
	private String itemName;	//アイテム名
	private String itemImg;		//アイテム画像
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	public Item(int itemId, String itemName, String itemImg) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemImg = itemImg;
	}
	public Item() {
		super();
		this.itemId = 0;
		this.itemName = "";
		this.itemImg = "";
	}
}
