package com.teamyostrik.efrip.models;

public class LigneItem {
	private String id;
	private int quantity;
	private float price;
	private Product product;
	public LigneItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneItem(int quantity, float price, Product product) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
