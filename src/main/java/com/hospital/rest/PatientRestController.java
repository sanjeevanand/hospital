package com.hospital.rest;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.jpa.OtpRepository;
import com.hospital.jpa.PatientRepository;
import com.hospital.model.Address;
import com.hospital.model.Doctor;
import com.hospital.model.Otp;
import com.hospital.model.Patient;
import com.hospital.sms.WSApiNN;
import com.hospital.util.HospitalUtil;

@RestController
@RequestMapping("/rest")
public class PatientRestController {
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	OtpRepository OtpRepository;
	@Value("${hospital.url}")
	private String hospitalUrl;
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
			if(ctr==1)
			sendEmail(stored);
			else
				try {
					WSApiNN.sendSms(stored.getMobile(),stored.getOtpList().get(0).getOtp());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

			return stored;
		} else {
			Patient x = new Patient();
			x.setName("exist");
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
		
		if (("P" + arg.get("otp")).equals(otp.getOtp())) {
			obj.setStatus("1");
			return true;
			}
		else
			return false;
	}
	void sendEmail(Patient patient) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(""+patient.getEmail());

        msg.setSubject("Welcome mail from DigiKlinik");
      //  msg.setText(patient.getOtpList().get(0).toString());
        String url = "http://"+hospitalUrl+"/rest/patientverifyLink/"+patient.getEmail();
        msg.setText(url);
        javaMailSender.send(msg);

    }
	@GetMapping(value = "/patientverifyLink/{email:.+}")
	public void patientverifyLink(@PathVariable("email") String email,HttpServletRequest req,HttpServletResponse response) throws IOException {

		Patient obj = patientRepository.findByEmail(email);
		    obj.setStatus("1");
		    patientRepository.save(obj);
		response.sendRedirect("/patient/");
	}
}
