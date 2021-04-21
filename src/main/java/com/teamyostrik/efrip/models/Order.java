package com.teamyostrik.efrip.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public Order() {
    }

    public Order(String id, User user, List<Product> products, Address billingAddress) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.billingAddress = billingAddress;
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
}
