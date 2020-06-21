package com.hospital.jpa;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.Doctor;
import com.hospital.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>     {
	
	Patient findByMobile(String mobile);
	Patient findByEmail(String email);
}
