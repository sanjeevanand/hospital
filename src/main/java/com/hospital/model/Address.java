package com.hospital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = -3078325312619021962L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int id;
	@Column
	private String houseNo;
	@Column
	private String colony;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String pincode;
	@Column
	private String country;
	@Column
	private String landmark;
	protected Address(String houseNo, String colony, String city, String state, String pincode, String country,
			String landmark) {
		super();
		this.houseNo = houseNo;
		this.colony = colony;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.landmark = landmark;
	}
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNo=" + houseNo + ", colony=" + colony + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", country=" + country + ", landmark=" + landmark + "]";
	}
	
	

}
