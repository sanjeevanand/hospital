package com.hospital.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.Otp;

public interface OtpRepository extends JpaRepository<Otp, Long> {

}
