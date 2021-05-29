package com.teamyostrik.efrip.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document (collection = "order")
public class Order {
    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private Address billingAddress;
    private OrderStatus status;
    private Date orderedDate;
    private Date shippedDate;
    private String fullName;
    private int mobile;
    private String flat;
    private String near;
    private float totalPrice;
    @DBRef
    private List<LigneItem> listLigneItem;
    @DBRef
    private Payment payment;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModified;

    public Order() {
    }
	
	public Order(User user, Address billingAddress, OrderStatus status, Date orderedDate, Date shippedDate,
			String fullName, int mobile, String flat, String near, float totalPrice, List<LigneItem> listLigneItem,
			Payment payment, Date createdDate, Date lastModified) {
		super();
		this.user = user;
		this.billingAddress = billingAddress;
		this.status = status;
		this.orderedDate = orderedDate;
		this.shippedDate = shippedDate;
		this.fullName = fullName;
		this.mobile = mobile;
		this.flat = flat;
		this.near = near;
		this.totalPrice = totalPrice;
		this.listLigneItem = listLigneItem;
		this.payment = payment;
		this.createdDate = createdDate;
		this.lastModified = lastModified;
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
	public Date getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}
	public Date getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(Date shippedDate) {
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

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getFlat() {
		return flat;
	}
	public void setFlat(String flat) {
		this.flat = flat;
	}
	public String getNear() {
		return near;
	}
	public void setNear(String near) {
		this.near = near;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	
	
	
}
