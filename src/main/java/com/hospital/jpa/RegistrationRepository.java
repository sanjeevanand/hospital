package com.hospital.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	
	Registration	findByName(String name);
	Registration	findByEmail(String email);

}
