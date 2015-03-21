package com.ainosoft.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AddressSlim implements IsSerializable {
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private String name, street, city, country, zip,state;
    private int id; 
    public AddressSlim(String name, String street, String city, String country,
			String zip,String state) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.state=state; 
	}
    public AddressSlim(int i,String name, String street, String city, String country,
			String zip,String state) {
		this.id=i;
    	this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.state=state; 
	}
    
	public AddressSlim(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
