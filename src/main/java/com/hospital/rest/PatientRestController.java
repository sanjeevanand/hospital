package com.hospital.rest;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.jpa.OtpRepository;
import com.hospital.jpa.PatientRepository;
import com.hospital.model.Address;
import com.hospital.model.Otp;
import com.hospital.model.Patient;

@RestController
@RequestMapping("/rest")
public class PatientRestController {
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	OtpRepository OtpRepository;

	@PostMapping(value = "/patientRegistration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Patient createUser(Patient patient) {
		System.out.println(patient);
		Patient temp = null;
		if (null != patient)
			temp = patientRepository.findByMobile(patient.getMobile());

		if (null == temp) {
			Random x = new Random();
			String otp = "P" + x.nextInt(9999);
			System.out.println(otp);
			patient.setAddress(new Address());
			patient.addOtpList(new Otp(otp, new Date()));
			return patientRepository.save(patient);
		} else {
			temp.setName("exist");
			return temp;
		}
	}

	@PostMapping(value = "/otpVerify")
	public boolean otpVerify(@RequestParam Map<String, String> arg) {
		Patient obj = patientRepository.findByMobile(arg.get("mobile"));
		Otp otp = obj.getOtpList().get(0);
		if (("P" + arg.get("otp")).equals(otp.getOtp()))
			return true;
		else
			return false;
	}
}
