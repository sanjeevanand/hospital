package com.hospital.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="patient")
public class Patient implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1276058699016642142L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
	private long patientId;
	@Column
	private String name;
	@Column
    private String email;
	@Column//(unique = true)
    private String mobile;
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	@Column
    private String gender;
	@Column
    private String dob;
	@Column
    private String bloodGroup;
	@Column
    private String timeZone;
	@Column
    private String extraPhone;
	@Column
    private String language;
	@Column
	private String password;
	@Column
	private String status;
	@Column
	private String imagePath;
	
	@OneToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="patient_id")
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
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
    private Address address;
	public String getName() {
		return name;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getExtraPhone() {
		return extraPhone;
	}

	public void setExtraPhone(String extraPhone) {
		this.extraPhone = extraPhone;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", gender=" + gender + ", dob=" + dob + ", bloodGroup=" + bloodGroup + ", timeZone=" + timeZone
				+ ", extraPhone=" + extraPhone + ", language=" + language + ", password=" + password + ", otpList="
				+ otpList + ", address=" + address + "]";
	}
    
}
