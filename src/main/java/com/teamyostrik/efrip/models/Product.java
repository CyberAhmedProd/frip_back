package com.teamyostrik.efrip.models;

import jdk.jfr.Timestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Document(collection = "product")
public class Product {
    @Id
    private String id;
    private String name;
    @DBRef
    private User user;
    @DBRef
    private Category category;
    private String details;
    private Double price;
    private String description;
    private boolean featured;


    @DBRef
    private List<Photo> images;

    @CreatedDate
    private Timestamp createdDate;
    @LastModifiedDate
    private Timestamp lastModified;
    public Product(String name, User user, Category category, String details, Double price, String description,
                   boolean featured, List<Photo> images) {
        super();
        this.name = name;
        this.user = user;
        this.category = category;
        this.details = details;
        this.price = price;
        this.description = description;
        this.featured = featured;
        this.images = images;

    }

    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public List<Photo> getImages() {
        return images;
    }

    public void setImages(List<Photo> images) {
        this.images = images;
    }

}
