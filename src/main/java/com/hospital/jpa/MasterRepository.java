package com.hospital.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.Address;
import com.hospital.model.Master;

public interface MasterRepository extends JpaRepository<Master, Long>{

	Master findBySpeciality(String speciality);
	//Master findByselectId(long selectId);
	 Optional<Master> findById(Long id);
	

}
