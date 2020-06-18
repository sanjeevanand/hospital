package com.hospital.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Otp implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String otp;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;
	public Otp(String otp, Date updated_at) {
		super();
		this.otp = otp;
		this.updated_at = updated_at;
	}
	protected Otp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "Otp [id=" + id + ", otp=" + otp + ", updated_at=" + updated_at + "]";
	}
	
	@Transient
	private String RegistrationId; 
	@Transient
	private String PatientId;
	@Transient
	private String doctorId;
}
