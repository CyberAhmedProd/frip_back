package com.teamyostrik.efrip.models;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Document(collection ="product")
public class Product {
    @Id
    String id;
    String name;
    @DBRef
    User  user;
    @DBRef
    Category category;
    String details;
    Double price;
    String description;
    boolean featured;
    String image;
    String images;
    @DateTimeFormat(style = "M-DD-YY")
    @CreatedDate
    private Date createdDate;
	public Product(String name, User user, Category category, String details, Double price, String description,
			boolean featured, String image, String images, Date createdDate) {
		super();
		this.name = name;
		this.user = user;
		this.category = category;
		this.details = details;
		this.price = price;
		this.description = description;
		this.featured = featured;
		this.image = image;
		this.images = images;
		this.createdDate = createdDate;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
    



}
