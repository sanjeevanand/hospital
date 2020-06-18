package com.hospital.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.Address;
import com.hospital.model.Master;
import com.hospital.model.ServiceMaster;

public interface ServiceMasterRepository extends JpaRepository<ServiceMaster, Long>{

	ServiceMaster findByService(String service);
	ServiceMaster findByselectId(long selectId);
	
	

}
