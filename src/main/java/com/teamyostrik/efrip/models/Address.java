package com.teamyostrik.efrip.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "address")
public class Address {
	@Id
	private String id;
	private String city;
	private Short codePostal;
	private String country;
	private String street;
	public Address() {

	}
	public Address(String city, Short codePostal, String country, String street) {
		super();
		this.city = city;
		this.codePostal = codePostal;
		this.country = country;
		this.street = street;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Short getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Short codePostal) {
		this.codePostal = codePostal;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	
}
