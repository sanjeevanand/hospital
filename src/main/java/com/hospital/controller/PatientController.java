package com.hospital.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.jpa.AddressRepository;
import com.hospital.jpa.PatientRepository;
import com.hospital.model.Patient;
import com.hospital.util.HospitalUtil;

@Controller
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientRepository patientRepository;

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${hospital.url}")
	private String hospitalUrl;

	@GetMapping("/")
	public String homepage(HttpServletRequest request) {
		System.out.println("path=/mk/");
		Patient sessionPatient = (Patient) request.getSession().getAttribute("userPatient");
		if (sessionPatient != null)
			return "dashboardp";
		else
			return "loginp";
	}

	@PostMapping("/loginSubmit")
	public String loginSubmit(HttpServletRequest req, Model m) {
		System.out.println("path=/admin/loginSubmit");
		String mobile = req.getParameter("mobile");
		String pswd = req.getParameter("pwd");
		Patient user = null;
		if (HospitalUtil.isEmail(mobile)) {
			user = patientRepository.findByEmail(mobile);
		} else {
			user = patientRepository.findByMobile(mobile);
		}
		if (user != null) {
			Patient sessionPatient = (Patient) req.getSession().getAttribute("userPatient");

			if (null!=user.getPassword() && user.getPassword().equals(pswd)) {
				if (sessionPatient == null) {

					req.getSession().setAttribute("userPatient", user);
				}
				return "redirect:/patient/dashboard";
			} else {
				System.out.println("path=/admin/fail");
				m.addAttribute("pwd", "Invalid Password");
				return "loginp";
			}
		} else {
			System.out.println("path=/admin/fail");
			m.addAttribute("email", "Invalid email ID or user does not exist");
			return "loginp";
		}
	}

	@GetMapping("/dashboard")
	public String dashboard(HttpServletRequest req, Model m) {
		System.out.println("path=/dashboardp");
		Patient sessionPatient = (Patient) req.getSession().getAttribute("userPatient");
		
		if (sessionPatient != null)
		{
			m.addAttribute("patientUser", sessionPatient);
			return "dashboardp";
		}
		else {
			return "loginp";
		}
	}

	@GetMapping("/forgotPassword")
	public String forgot(@RequestParam(value = "msg", required = false) String msg, Model model) {
		System.out.println("path=/admin/forgotPassword");
		if (msg != null)
			model.addAttribute("msg", msg);

		return "forgotPasswordp";
	}

	@PostMapping("forgotsubmit")
	public String forgotsubmit(HttpServletRequest req, Model model) {
		System.out.println("path=/admin/forgotsubmit");
		String email = req.getParameter("email");
		// String pswd = req.getParameter("pswd");
		int ctr = 0;
		Patient user = null;
		if (null != email) {
			if (HospitalUtil.isEmail(email)) {
				user = patientRepository.findByEmail(email);
				ctr = 1;
			} else {
				user = patientRepository.findByMobile(email);
				ctr = 2;
			}
		}
		if (null != user) {
			model.addAttribute("msg", "reset link sent to mobile");
			
			sendOtp(user,ctr,req.getRemoteAddr());
			return "forgotPasswordp";
		} else {
			model.addAttribute("msg", "Invalid Mobile No.");
			return "forgotPasswordp";
		}

	}

	@GetMapping("reset/{mobile:.+}")
	public String reset(@PathVariable String mobile, HttpServletRequest req, Model m) {
		System.out.println("path=/admin/reset");
		// String email= req.getParameter("txtEmail");
		 Patient user = null;
		 int ctr = 0;
		if (HospitalUtil.isEmail(mobile)) {
			user = patientRepository.findByEmail(mobile);
			ctr = 1;
		} else {
			user = patientRepository.findByMobile(mobile);
			ctr = 2;
		}
	//	Patient user = patientRepository.findByMobile(mobile);
		if (null != user) {
			if(ctr==1)
			m.addAttribute("mobile", user.getEmail());
			else
				m.addAttribute("mobile", user.getMobile());

			return "resetPasswordp";
		} else {
			m.addAttribute("msg", "Invalid email ID or user does not exist");
			return "forgotPassword";
		}

	}
	
	@PostMapping("savePatientSubmit")
	public String savePatientSubmit(HttpServletRequest req, Model model) {
		System.out.println("path=/admin/resetAction");
		String pass = req.getParameter("pass");
		String repass = req.getParameter("repass");
		String mobile = req.getParameter("mobile");
		// String pswd = req.getParameter("pswd");
		if(pass.equals(repass)){
			 Patient user = null;
			 int ctr = 0;
			if (HospitalUtil.isEmail(mobile)) {
				user = patientRepository.findByEmail(mobile);
				ctr = 1;
			} else {
				user = patientRepository.findByMobile(mobile);
				ctr = 2;
			}
	//	Patient user = patientRepository.findByMobile(mobile);
		if (null != user) {
			model.addAttribute("msg", "reset link sent to mobile");
			user.setPassword(pass);
			patientRepository.save(user);
			return "loginp";
		} else {
			model.addAttribute("msg", "Invalid Request");
			return "resetPasswordp";
		}
		}else {
			model.addAttribute("msg", "Password does not matched");
			return "resetPasswordp";
		}
	}
	@GetMapping("/profile")
	public String profile(HttpServletRequest req, Model m) {
		System.out.println("path=/admin/profile");
		Patient sessionPatient = (Patient) req.getSession().getAttribute("userPatient");
		if (sessionPatient != null) {
			m.addAttribute("patient", sessionPatient);
			Map<String, String> genders = new LinkedHashMap<String, String>();
			genders.put("Male", "Male");
			genders.put("Female", "Female");
			m.addAttribute("genders", genders);
			
			Map<String, String> bloodgrp = new LinkedHashMap<String, String>();
			bloodgrp.put("A+", "A+");
			bloodgrp.put("O-", "O-");
			bloodgrp.put("B+", "B+");
			m.addAttribute("bloodgrp", bloodgrp);
			
			Map<String, String> lang = new LinkedHashMap<String, String>();
			lang.put("English", "English");
			lang.put("Tamil", "Tamil");
			
			m.addAttribute("lang", lang);
			return "profilep";
			
		}
		else
			return "redirect:/patient/";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@Valid @ModelAttribute("patient") Patient patient,BindingResult bResult,Model m,HttpServletRequest req) {
		
		if(bResult.hasErrors()){
			return "profilep";
		}else{
		Patient temp =  (Patient) req.getSession().getAttribute("userPatient");
		if(null==patient.getPassword())
			patient.setPassword(temp.getPassword());
		
		patientRepository.save(patient);	
		req.getSession().setAttribute("userPatient", patient);
		m.addAttribute("msg", "Record inserted !");
		return "redirect:/patient/profile";
		}
	}
	
	@GetMapping("/medical_record")
	public String medical_record(HttpServletRequest req, Model m) {
		System.out.println("path=/admin/profile");
		Patient sessionPatient = (Patient) req.getSession().getAttribute("userPatient");
		if (sessionPatient != null) {
			m.addAttribute("patient", sessionPatient);
			return "medical_record";
		}
		else
			return "redirect:/patient/";
	}
	@GetMapping("/lab_test")
	public String lab_test(HttpServletRequest req, Model m) {
		System.out.println("path=/admin/profile");
		Patient sessionPatient = (Patient) req.getSession().getAttribute("userPatient");
		if (sessionPatient != null) {
			m.addAttribute("patient", sessionPatient);
			return "lab_testp";
		}
		else
			return "redirect:/patient/";
	}
	@GetMapping("/consultion")
	public String consultion(HttpServletRequest req, Model m) {
		System.out.println("path=/admin/profile");
		Patient sessionPatient = (Patient) req.getSession().getAttribute("userPatient");
		if (sessionPatient != null) {
			m.addAttribute("patient", sessionPatient);
			return "consultionp";
		}
		else
			return "redirect:/patient/";
	}
	@GetMapping("/feedback")
	public String feedback(HttpServletRequest req, Model m) {
		System.out.println("path=/admin/profile");
		Patient sessionPatient = (Patient) req.getSession().getAttribute("userPatient");
		if (sessionPatient != null) {
			m.addAttribute("patient", sessionPatient);
			return "feedbackp";
		}
		else
			return "redirect:/patient/";
	}
	@GetMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		System.out.println("path=/admin/logout");
		request.getSession().invalidate();
		return "redirect:/patient/";
	}
	void sendOtp(Patient patient,int ctr,String url) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(""+patient.getEmail());

        msg.setSubject("Welcome mail from DigiKlinik");
        if(ctr==1)
        msg.setText("http://"+hospitalUrl+"/patient/reset/"+patient.getEmail());
        else
        msg.setText("http://"+hospitalUrl+"/patient/reset/"+patient.getMobile());

        
        javaMailSender.send(msg);

    }
	
}
