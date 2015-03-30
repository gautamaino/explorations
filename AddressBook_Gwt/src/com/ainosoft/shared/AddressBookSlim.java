package com.ainosoft.shared;

import java.io.Serializable;

public class AddressBookSlim implements Serializable {
	private String country, state, city, street, zip;
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AddressBookSlim() {

	}

	public AddressBookSlim(String country, String state, String city,
			String street, String zip) {
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}