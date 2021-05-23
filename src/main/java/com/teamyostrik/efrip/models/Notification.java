package com.teamyostrik.efrip.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "notification")
public class Notification {
    @Id
    private String id;

    @DBRef
    private User user;

    private String auction_id;

    private boolean isRead=false;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModfiedDate;

    public Notification() {
    }

    public Notification(String id, User user, String auction_id, boolean isRead,Date createdDate, Date lastModfiedDate) {
        this.id = id;
        this.user = user;
        this.auction_id = auction_id;
        this.isRead=isRead;
        this.createdDate = createdDate;
        this.lastModfiedDate = lastModfiedDate;
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



    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModfiedDate() {
        return lastModfiedDate;
    }

    public void setLastModfiedDate(Date lastModfiedDate) {
        this.lastModfiedDate = lastModfiedDate;
    }

    public String getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
