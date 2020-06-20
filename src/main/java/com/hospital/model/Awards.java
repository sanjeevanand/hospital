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
public class Awards implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4687314092420280570L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String awards;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;
	public Awards(String awards, Date updated_at) {
		super();
		this.awards = awards;
		this.updated_at = updated_at;
	}
	protected Awards() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	@Transient
	private String doctorId;
}
