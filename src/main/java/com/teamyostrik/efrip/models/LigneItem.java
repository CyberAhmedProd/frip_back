package com.teamyostrik.efrip.models;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class LigneItem {
	private String id;
	private int quantity;
	@DBRef
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
