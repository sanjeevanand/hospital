package com.hospital.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.jpa.MasterRepository;
import com.hospital.jpa.ServiceMasterRepository;
import com.hospital.jpa.SpecializationMasterRepository;
import com.hospital.model.Master;
import com.hospital.model.ServiceMaster;
import com.hospital.model.SpecializationMaster;

@RestController
@RequestMapping("/rest")
public class MasterRestController {
	@Autowired
	MasterRepository masterRepository;
	
	@Autowired
	private ServiceMasterRepository serviceMasterRepository;
	
	@Autowired
	private SpecializationMasterRepository specializationMasterRepository;

	
	@PostMapping(value = "/addSpeciality", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Master createSpeciality(Master master) {
		
		System.out.println(master);
		Master temp = null;
		if (null != master)
			temp = masterRepository.findBySpeciality(master.getSpeciality());

		if (null == temp) {
			
			return masterRepository.save(master);
		} else {
			master.setSpeciality("exist");
			return temp;
		}
	}

	@GetMapping(value = "/masterList")
	public List masterList() {
		return masterRepository.findAll();
	}
	
	@PostMapping(value = "/addService", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ServiceMaster addService(ServiceMaster master) {
		System.out.println(master);
		ServiceMaster temp = null;
		if (null != master)
			temp = serviceMasterRepository.findByService(master.getService());

		if (null == temp) {
			
			return serviceMasterRepository.save(master);
		} else {
			master.setService("exist");
			return temp;
		}
	}


	@PostMapping(value = "/addSpecialization", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public SpecializationMaster addSpecialization(SpecializationMaster master) {
		System.out.println(master);
		SpecializationMaster temp = null;
		if (null != master)
			temp = specializationMasterRepository.findBySpecialization(master.getSpecialization());

		if (null == temp) {
			
			return specializationMasterRepository.save(master);
		} else {
			master.setSpecialization("exist");
			return temp;
		}
	}


}
