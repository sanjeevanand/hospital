package com.hospital.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.hospital.jpa.DoctorRepository;
import com.hospital.jpa.DoctorRepository;
import com.hospital.model.Doctor;
import com.hospital.model.Doctor;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	
	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping("/")
	public String homepage(HttpServletRequest request) {
		Doctor sessionPatient = (Doctor) request.getSession().getAttribute("userDoctor");
		if (sessionPatient != null)
			return "dashboardd";
		else
			return "logind";
	}
	@PostMapping("/loginSubmit")
	public String loginSubmit(HttpServletRequest req, Model m) {
		System.out.println("path=/admin/loginSubmit");
		String mobile = req.getParameter("mobile");
		String pswd = req.getParameter("pwd");
		Doctor user = doctorRepository.findByMobile(mobile);
		if (user != null) {
			Doctor sessionDoctor = (Doctor) req.getSession().getAttribute("userDoctor");

			if (null!=user.getPassword() && user.getPassword().equals(pswd)) {
				if (sessionDoctor == null) {

					req.getSession().setAttribute("userDoctor", user);
				}
				return "redirect:/doctor/dashboard";
			} else {
				System.out.println("path=/admin/fail");
				m.addAttribute("pwd", "Invalid Password");
				return "logind";
			}
		} else {
			System.out.println("path=/admin/fail");
			m.addAttribute("email", "Invalid email ID or user does not exist");
			return "logind";
		}
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpServletRequest req, Model m) {
		System.out.println("path=/dashboardd");
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (sessionPatient != null) {
			m.addAttribute("userDoctor", sessionPatient);
			return "dashboardd";
		}
		else {
			return "logind";
		}
	}
	
	@GetMapping("/forgotPassword")
	public String forgot(@RequestParam(value = "msg", required = false) String msg, Model model) {
		System.out.println("path=/admin/forgotPassword");
		if (msg != null)
			model.addAttribute("msg", msg);

		return "forgotPasswordd";
	}
	@PostMapping("forgotsubmit")
	public String forgotsubmit(HttpServletRequest req, Model model) {
		System.out.println("path=/admin/resetAction");
		String email = req.getParameter("email");
		// String pswd = req.getParameter("pswd");

		Doctor user = doctorRepository.findByMobile(email);
		if (null != user) {
			model.addAttribute("msg", "reset link sent to mobile");
			return "forgotPasswordd";
		} else {
			model.addAttribute("msg", "Invalid Mobile No.");
			return "forgotPasswordd";
		}

	}
	@GetMapping("reset/{mobile}")
	public String reset(@PathVariable String mobile, HttpServletRequest req, Model m) {
		System.out.println("path=/admin/reset");
		// String email= req.getParameter("txtEmail");
		Doctor user = doctorRepository.findByMobile(mobile);
		if (null != user) {
			m.addAttribute("mobile", user.getMobile());

			return "resetPasswordd";
		} else {
			m.addAttribute("msg", "Invalid email ID or user does not exist");
			return "forgotPasswordd";
		}

	}
	@PostMapping("saveDoctorSubmit")
	public String savePatientSubmit(HttpServletRequest req, Model model) {
		System.out.println("path=/admin/resetAction");
		String pass = req.getParameter("pass");
		String repass = req.getParameter("repass");
		String mobile = req.getParameter("mobile");
		// String pswd = req.getParameter("pswd");
		if(pass.equals(repass)){
		Doctor user = doctorRepository.findByMobile(mobile);
		if (null != user) {
			model.addAttribute("msg", "reset link sent to mobile");
			user.setPassword(pass);
			doctorRepository.save(user);
			return "logind";
		} else {
			model.addAttribute("msg", "Invalid Request");
			return "resetPasswordd";
		}
		}else {
			model.addAttribute("msg", "Password does not matched");
			return "resetPasswordp";
		}
	}
	
	@GetMapping("/profile")
	public String profile(HttpServletRequest req, Model m) {
		System.out.println("path=/admin/profile");
		
		Doctor sessionDoctor = (Doctor) req.getSession().getAttribute("userDoctor");
		if (sessionDoctor != null) {
			m.addAttribute("doctor", sessionDoctor);
		//	m.addAttribute("image", sessionDoctor.getImagePath());
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
			return "profiled";
			
		}
		else
			return "redirect:/doctor/";
	}
	
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(@Valid @ModelAttribute("doctor") Doctor doctor,BindingResult bResult,Model m,HttpServletRequest req) {
		
		if(bResult.hasErrors()){
			return "profiled";
		}else{
		Doctor temp =  (Doctor) req.getSession().getAttribute("userDoctor");
		if(null==doctor.getPassword())
			doctor.setPassword(temp.getPassword());
		
		doctorRepository.save(doctor);	
		req.getSession().setAttribute("userDoctor", doctor);
		m.addAttribute("msg", "Record inserted !");
		return "redirect:/doctor/profile";
		}
	}
	@GetMapping("/notifications")
	public String notifications(HttpServletRequest req,Model m) {
		System.out.println("path=/notifications");
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (sessionPatient != null) {
			m.addAttribute("userDoctor", sessionPatient);
			return "notificationsd";
		}
		else {
			return "logind";
		}
	}
	@GetMapping("/settings")
	public String setting(HttpServletRequest req,Model m) {
		System.out.println("path=/setting");
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (sessionPatient != null) {
			m.addAttribute("userDoctor", sessionPatient);
			return "settingsd";
		}
		else {
			return "logind";
		}
	}
	@PostMapping("changePassword")
	public String changePassword(HttpServletRequest req, Model m) {
		
		System.out.println("path=/changePassword");
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (sessionPatient != null) {
			String pass = req.getParameter("password");
			String newpassword = req.getParameter("newPassword");
			String renewpassword = req.getParameter("newRepassword");
			if(pass.equals(sessionPatient.getPassword())) {
				if(newpassword.equals(renewpassword)) {
				Doctor doctor =	doctorRepository.findByMobile(sessionPatient.getMobile());
				doctor.setPassword(newpassword);
				}
				else {
					m.addAttribute("msg", "New password and Confirm Password doesn't matched");
				}
			}
			else {
				m.addAttribute("msg", "Entered Current password incorrect !");
				
			}
			return "settingsd";
		}
		else {
			return "logind";
		}
		
	}
	@GetMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		System.out.println("path=/admin/logout");
		request.getSession().invalidate();
		return "redirect:/doctor/";
	}
	
	@GetMapping("/registration")
	public String registrationdoc(HttpServletRequest req,Model m) {
		System.out.println("path=/setting");
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (sessionPatient != null) {
			m.addAttribute("userDoctor", sessionPatient);
			return "regdoc";
		}
		else {
			return "logind";
		}
	}
	
	@GetMapping("/experience")
	public String experiencedoc(HttpServletRequest req,Model m) {
		System.out.println("path=/setting");
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (sessionPatient != null) {
			m.addAttribute("userDoctor", sessionPatient);
			return "experiencedoc";
		}
		else {
			return "logind";
		}
	}
	@GetMapping("/services")
	public String servicedoc(HttpServletRequest req,Model m) {
		System.out.println("path=/setting");
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (sessionPatient != null) {
			m.addAttribute("userDoctor", sessionPatient);
			return "servicedoc";
		}
		else {
			return "logind";
		}
	}
	@GetMapping("/awards")
	public String awardsdoc(HttpServletRequest req,Model m) {
		System.out.println("path=/setting");
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (sessionPatient != null) {
			m.addAttribute("userDoctor", sessionPatient);
			return "awardsdoc";
		}
		else {
			return "logind";
		}
	}
}
