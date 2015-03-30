package com.ainosoft.server;
// Generated 6 Mar, 2015 4:42:27 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name = "Address")
public class AddressPojo implements java.io.Serializable {

	private int id;
	private String zip;
	private String street;
	private String city;
	private String state;
	private String country;

	public AddressPojo() {
	}

	public AddressPojo(int id) {
		this.id = id;
	}

	public AddressPojo(int id, String zip, String street, String city,
			String state, String country) {
		this.id = id;
		this.zip = zip;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Id
	@GenericGenerator(name="id_generator",strategy="increment")
	@GeneratedValue(generator="id_generator")
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "zip", length = 45)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "street", length = 45)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "city", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 45)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "country", length = 45)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
