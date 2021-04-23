package com.teamyostrik.efrip.models;

public class LigneItem {
	private String id;
	private Short quantity;
	private float price;
	public LigneItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneItem(Short quantity, float price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Short getQuantity() {
		return quantity;
	}
	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
