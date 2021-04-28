package com.teamyostrik.efrip.models;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Id
	private String id;
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	private String email;
	private String username; 
	private String password;
	private String firstName;
	private String lastName;
	@DBRef
	private Photo avatar;
	private String token;
	private UserState userState;
	@DBRef
	private Address address;
	private Status status;
	@DBRef
    private Set<Role> roles;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public User(String email, String username, String password, String firstName, String lastName, Photo avatar,
			String token, UserState userState, Address address, Status status, Set<Role> roles) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avatar = avatar;
		this.token = token;
		this.userState = userState;
		this.address = address;
		this.status = status;
		this.roles = roles;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}