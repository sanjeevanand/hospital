package com.hospital.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="doctor")
public class Doctor implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1276058699016642142L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private long doctorId;
	
	@Column
	private String prefix;
	
	@Column
	private String firstname;
	
	@Column
    private String gender;
	
	
	@Column
    private String dob;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at; 
	
	

	@Column//(unique = true)
    private String mobile;
	
	@Column//(unique = true)
    private String email;
	
	@Column
    private String city;
	@Column
    private String profile;
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Column
    private String experience;
	@Column
    private String description;
	@Column
    private String location;
	@Column
	private String address;
	@Column
	private String address_city;
	@Column
	private String state;
	
	@Column
	private String pincode;
	@Column
	private String country;
	@Column
	private String landmark;
	
	@Column
	private String password;
	
	@Column
	private String status;
	
	@Column
	private String regNo;
	
	@Column
	private String regYear;
	
	@Column
	private String language;
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	/*
	 * @Column private List<String> language;
	 * 
	 * 
	 * public List<String> getLanguage() { return language; }
	 * 
	 * public void setLanguage(List<String> language) { this.language = language; }
	 */

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getRegYear() {
		return regYear;
	}

	public void setRegYear(String regYear) {
		this.regYear = regYear;
	}

	@OneToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="doctor_id")
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

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_city() {
		return address_city;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	@OneToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="doctor_id")
	@JsonIgnore
	private List<WorkExperience> workExperienceList;
	
	@OneToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="doctor_id")
	@JsonIgnore
	private List<Education> educationList;
	
	@OneToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="doctor_id")
	@JsonIgnore
	private List<ServiceDoctor> serviceDoctorList;
	
	@OneToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="doctor_id")
	@JsonIgnore
	private List<SpecializationDoctor> specializationDoctorList;
	
	@OneToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="doctor_id")
	@JsonIgnore
	private List<Awards> awardsList;

	@OneToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="doctor_id")
	@JsonIgnore
	private List<Membership> membershipList;
	
	public List<WorkExperience> getWorkExperienceList() {
		return workExperienceList;
	}

	public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
		this.workExperienceList = workExperienceList;
	}

	public List<Education> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<Education> educationList) {
		this.educationList = educationList;
	}
	
	public List<ServiceDoctor> getServiceDoctorList() {
		return serviceDoctorList;
	}

	public void setServiceDoctorList(List<ServiceDoctor> serviceDoctorList) {
		this.serviceDoctorList = serviceDoctorList;
	}

	public List<SpecializationDoctor> getSpecializationDoctorList() {
		return specializationDoctorList;
	}

	public void setSpecializationDoctorList(List<SpecializationDoctor> specializationDoctorList) {
		this.specializationDoctorList = specializationDoctorList;
	}

	public List<Awards> getAwardsList() {
		return awardsList;
	}

	public void setAwardsList(List<Awards> awardsList) {
		this.awardsList = awardsList;
	}

	public List<Membership> getMembershipList() {
		return membershipList;
	}

	public void setMembershipList(List<Membership> membershipList) {
		this.membershipList = membershipList;
	}

	public void addEducationList(Education education){
		if(this.educationList==null){
			this.educationList = new ArrayList<>();
		}
		this.educationList.add(education);
	}
	public void addworkExperienceList(WorkExperience workExperience){
		if(this.workExperienceList==null){
			this.workExperienceList = new ArrayList<>();
		}
		this.workExperienceList.add(workExperience);
	}
	public void addawardsList(Awards awards){
		if(this.awardsList==null){
			this.awardsList = new ArrayList<>();
		}
		this.awardsList.add(awards);
	}
	public void addMembershipList(Membership membership){
		if(this.membershipList==null){
			this.membershipList = new ArrayList<>();
		}
		this.membershipList.add(membership);
	}
	public void addServiceDoctorList(ServiceDoctor serviceDoctor){
		if(this.serviceDoctorList==null){
			this.serviceDoctorList = new ArrayList<>();
		}
		this.serviceDoctorList.add(serviceDoctor);
	}
	
	public void addspecializationDoctorList(SpecializationDoctor specializationDoctor){
		if(this.specializationDoctorList==null){
			this.specializationDoctorList = new ArrayList<>();
		}
		this.specializationDoctorList.add(specializationDoctor);
	}
	
}
