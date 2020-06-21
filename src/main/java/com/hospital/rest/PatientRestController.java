package com.hospital.rest;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.jpa.OtpRepository;
import com.hospital.jpa.PatientRepository;
import com.hospital.model.Address;
import com.hospital.model.Otp;
import com.hospital.model.Patient;
import com.hospital.util.HospitalUtil;

@RestController
@RequestMapping("/rest")
public class PatientRestController {
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	OtpRepository OtpRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping(value = "/patientRegistration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Patient createUser(Patient patient) {
		System.out.println(patient);
		Patient temp = null;
		int ctr = 0;
		if (null != patient) {
			if (HospitalUtil.isEmail(patient.getMobile())) {
				temp = patientRepository.findByEmail(patient.getMobile());
				ctr = 1;
			} else {
				temp = patientRepository.findByMobile(patient.getMobile());
				ctr = 2;
			}
		}

		if (null == temp) {
			Random x = new Random();
			String otp = "P" + x.nextInt(9999);
			System.out.println(otp);
			patient.setAddress(new Address());
			patient.addOtpList(new Otp(otp, new Date()));
			if (ctr == 1) {
				patient.setEmail(patient.getMobile());
				patient.setMobile("");

			}
			Patient stored = patientRepository.save(patient);
			sendEmail(stored);
			return stored;
		} else {
			temp.setName("exist");
			return temp;
		}
	}

	@PostMapping(value = "/otpVerify")
	public boolean otpVerify(@RequestParam Map<String, String> arg) {
		Patient obj = null ;
		if (HospitalUtil.isEmail(arg.get("mobile"))) {
			obj = patientRepository.findByEmail(arg.get("mobile"));
		} else {
			obj = patientRepository.findByMobile(arg.get("mobile"));
		}
		Otp otp = obj.getOtpList().get(0);
		if (("P" + arg.get("otp")).equals(otp.getOtp()))
			return true;
		else
			return false;
	}
	void sendEmail(Patient patient) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(""+patient.getEmail());

        msg.setSubject("Welcome mail from DigiKlinik");
        msg.setText(patient.getOtpList().get(0).toString());

        
        javaMailSender.send(msg);

    }
}
