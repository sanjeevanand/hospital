package com.hospital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="servicemaster_select")
public class ServiceMaster implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long selectId ;
	@Column
	private String service;
	
	
	
	public long getSelectId() {
		return selectId;
	}
	public void setSelectId(long selectId) {
		this.selectId = selectId;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}

	

}
