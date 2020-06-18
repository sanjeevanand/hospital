package com.hospital.rest;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.jpa.DoctorRepository;
import com.hospital.jpa.OtpRepository;
import com.hospital.model.Address;
import com.hospital.model.Doctor;
import com.hospital.model.Otp;

@RestController
@RequestMapping("/rest")
public class DoctorRestController {
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	OtpRepository OtpRepository;

	@PostMapping(value = "/doctorRegistration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Doctor createUser(Doctor doctor) {
		System.out.println(doctor);
		Doctor temp = null;
		if (null != doctor)
			temp = doctorRepository.findByMobile(doctor.getMobile());

		if (null == temp) {
			Random x = new Random();
			String otp = "P" + x.nextInt(9999);
			System.out.println(otp);
			//doctor.setAddress(new Address());
			doctor.addOtpList(new Otp(otp, new Date()));
			return doctorRepository.save(doctor);
		} else {
			temp.setFirstname("exist");
			return temp;
		}
	}

	@PostMapping(value = "/doctorOtpVerify")
	public boolean otpVerify(@RequestParam Map<String, String> arg) {
		Doctor obj = doctorRepository.findByMobile(arg.get("mobile"));
		Otp otp = obj.getOtpList().get(0);
		if (("P" + arg.get("otp")).equals(otp.getOtp()))
			return true;
		else
			return false;
	}
	
	@PostMapping(value = "/doctorDeactivate", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public boolean deativate(HttpServletRequest req,Model m) {
		
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean deactivate = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
			doctorRepository.delete(obj);
			deactivate = true;
		}
		else {
			deactivate = false;
		}
		return deactivate;
	}
	
	@PostMapping(value = "/doctorRegistrationDoc")
	public boolean doctorRegistrationDoc(HttpServletRequest req,Model m,Doctor doctor) {
		
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
			obj.setRegNo(doctor.getRegNo());
			obj.setRegYear(doctor.getRegYear());
			req.getSession().setAttribute("userDoctor", obj);
			save = true;
		}
		else {
			save = false;
		}
		return save;
	}
}
