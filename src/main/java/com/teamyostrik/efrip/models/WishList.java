package com.teamyostrik.efrip.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wishlist")
public class WishList {
    @Id
    String id;

    @DBRef
    Product product;

    @DBRef

    User user;

    public WishList() {
    }

    public WishList(String id, Product product, User user) {
        this.id = id;
        this.product = product;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
