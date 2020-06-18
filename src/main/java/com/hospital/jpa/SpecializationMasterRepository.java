package com.hospital.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.Address;
import com.hospital.model.Master;
import com.hospital.model.SpecializationMaster;

public interface SpecializationMasterRepository extends JpaRepository<SpecializationMaster, Long>{

	SpecializationMaster findBySpecialization(String specialization);
	SpecializationMaster findByselectId(long selectId);
	
	

}
