package com.teamyostrik.efrip.models;

public class LigneItem {
	private String id;
	private int quantity;
	private Product product;
	public LigneItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneItem(int quantity,Product product) {
		super();
		this.quantity = quantity;
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
	
	
}
