package com.hospital.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	

}
