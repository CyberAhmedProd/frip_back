package com.teamyostrik.efrip.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.List;

@Document (collection = "order")
public class Order {
    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private List<Product> products;
    private Address billingAddress;
    private OrderStatus status;
    private Timestamp orderedDate;
    private Timestamp shippedDate;
    private float totalPrice;
    private List<LigneItem> listLigneItem;
    public Order() {
    }
  
	public Order(User user, List<Product> products, Address billingAddress, OrderStatus status, Timestamp orderedDate,
			Timestamp shippedDate, float totalPrice, List<LigneItem> listLigneItem) {
		super();
		this.user = user;
		this.products = products;
		this.billingAddress = billingAddress;
		this.status = status;
		this.orderedDate = orderedDate;
		this.shippedDate = shippedDate;
		this.totalPrice = totalPrice;
		this.listLigneItem = listLigneItem;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Timestamp getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(Timestamp orderedDate) {
		this.orderedDate = orderedDate;
	}
	public Timestamp getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(Timestamp shippedDate) {
		this.shippedDate = shippedDate;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<LigneItem> getListLigneItem() {
		return listLigneItem;
	}

	public void setListLigneItem(List<LigneItem> listLigneItem) {
		this.listLigneItem = listLigneItem;
	}
	
}
