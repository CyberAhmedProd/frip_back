package com.teamyostrik.efrip.models;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Profil {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	@DBRef
	private Photo avatar;
	private UserState userState;
	@DBRef
	private Address address;
	@DBRef
	private User user;
	
	public Profil(String firstName, String lastName, Photo avatar, UserState userState, Address address, User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.avatar = avatar;
		this.userState = userState;
		this.address = address;
		this.user = user;
	}
	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Photo getAvatar() {
		return avatar;
	}
	public void setAvatar(Photo avatar) {
		this.avatar = avatar;
	}
	public UserState getUserState() {
		return userState;
	}
	public void setUserState(UserState userState) {
		this.userState = userState;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
