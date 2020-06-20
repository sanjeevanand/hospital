package com.hospital.jpa;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>     {
	
	Doctor findByMobile(String mobile);
	Doctor findByEmail(String email);

}
