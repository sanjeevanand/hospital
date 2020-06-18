package com.hospital.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Registration implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String city;
	private String status;
	private String role;
	
	@OneToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="registration_id")
	@JsonIgnore
	private List<Otp> otpList;
	public List<Otp> getOtpList() {
		return otpList;
	}

	public void setOtpList(List<Otp> otpList) {
		this.otpList = otpList;
	}
	public void addOtpList(Otp otp){
		if(this.otpList==null){
			this.otpList = new ArrayList<>();
		}
		this.otpList.add(otp);
	}
	
	public Registration() {
		
	}

	public Registration(String name, String email, String mobile, String password, String city, String status) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.city = city;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Registration [name=" + name + ", email=" + email + ", mobile=" + mobile + ", password=" + password
				+ ", city=" + city + ", status=" + status + ", role=" + role + ", otpList=" + otpList + "]";
	}

	
	
}
