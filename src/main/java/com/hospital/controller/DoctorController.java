package com.hospital.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

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
import com.hospital.jpa.DoctorRepository;
import com.hospital.jpa.MasterRepository;
import com.hospital.jpa.ServiceMasterRepository;
import com.hospital.jpa.SpecializationMasterRepository;
import com.hospital.model.Doctor;
import com.hospital.model.Otp;
import com.hospital.model.ServiceMaster;
import com.hospital.sms.WSApiNN;
import com.hospital.util.HospitalUtil;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	ServiceMasterRepository  serviceMasterRepository;
	
	@Autowired
	SpecializationMasterRepository specializationMasterRepository;
	
	@Autowired
	private MasterRepository masterRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Value("${hospital.url}")
	private String hospitalUrl;
	@Autowired
	private JavaMailSender javaMailSender;
	
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

		Doctor user = null;
		if (HospitalUtil.isEmail(mobile)) {
			user = doctorRepository.findByEmail(mobile);
		} else {
			user = doctorRepository.findByMobile(mobile);
		}

		if (user != null) {
			Doctor sessionDoctor = (Doctor) req.getSession().getAttribute("userDoctor");

			if (null!=user.getPassword() && user.getPassword().equals(pswd)) {
				if (sessionDoctor == null) {

					req.getSession().setAttribute("userDoctor", user);
				}
				if(user.getStatus().equals("1"))
				return "redirect:/doctor/dashboard";
				else
				{
					m.addAttribute("pwd", "verify your account");
					return "logind";
				}
			} else {
				System.out.println("path=/admin/fail");
				
				m.addAttribute("pwd", "Password field cannot be empty");
				return "logind";
			}
		} else {
			System.out.println("path=/admin/fail");
			m.addAttribute("email", "Mobile Number / Email ID field cannot be empty");
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
		int ctr = 0;
		Doctor user = null;
		if (HospitalUtil.isEmail(email)) {
			user = doctorRepository.findByEmail(email);
			ctr=1;
		} else {
			user = doctorRepository.findByMobile(email);
			ctr=2;
		}
	//	doctorRepository.findByMobile(email);
		if (null != user) {
			if(ctr==1) {
			model.addAttribute("msg", "reset link sent to email");
			model.addAttribute("email",email);
			user.setStatus("0");
			doctorRepository.save(user);
			sendEmail(user);
			
			return "forgot_email_sent";
			}
			else {
				model.addAttribute("msg", "Mobile no is not verified");
				
				model.addAttribute("email",email);
				user.setStatus("0");
				Random x = new Random();
				String otp = "P" + x.nextInt(9999);
				System.out.println(otp);
				// doctor.setAddress(new Address());
				user.addOtpList(new Otp(otp, new Date()));
				doctorRepository.save(user);
				//need to implement sms logic here ..
				try {
					int size = user.getOtpList().size();
					if(size>0)
					WSApiNN.sendSms(user.getMobile(),user.getOtpList().get(size-1).getOtp());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "forgot_otp_send";
				}
			//return "forgotPasswordd";
		} else {
			model.addAttribute("msg", "Invalid Mobile/Email Id");
			return "forgotPasswordd";
		}

	}
	@GetMapping("/forgotEmailSent")
	public String forgotEmailSent(@RequestParam(value = "msg", required = false) String msg, Model model) {
		System.out.println("path=/admin/forgotPassword");
		if (msg != null)
			model.addAttribute("msg", msg);

		return "forgot_email_sent";
	}
	@GetMapping("/forgotOtpSend")
	public String forgotOtpSend(@RequestParam(value = "msg", required = false) String msg, Model model) {
		System.out.println("path=/admin/forgotPassword");
		if (msg != null)
			model.addAttribute("msg", msg);

		return "forgot_otp_send";
	}
	@GetMapping("/reset/{email:.+}")
	public String reset(@PathVariable String email, HttpServletRequest req, Model m) {
		System.out.println("path=/admin/reset");
		int ctr = 0;
		Doctor user = null;
		if (HospitalUtil.isEmail(email)) {
			user = doctorRepository.findByEmail(email);
			ctr=1;
		} else {
			user = doctorRepository.findByMobile(email);
			ctr=2;
		}
		if (null != user) {
			m.addAttribute("mobile", user.getEmail());
			return "resetPasswordd";
		} else {
			m.addAttribute("msg", "Invalid email ID or user does not exist");
			return "forgotPasswordd";
		}

	}
	@PostMapping("saveDoctorSubmit")
	public String saveDoctorSubmit(HttpServletRequest req, Model model) {
		System.out.println("path=/admin/resetAction");
		String pass = req.getParameter("pass");
		String repass = req.getParameter("repass");
		String email = req.getParameter("mobile");
		// String pswd = req.getParameter("pswd");
		if(pass.equals(repass)){
		int ctr = 0;
		Doctor user = null;
		if (HospitalUtil.isEmail(email)) {
			user = doctorRepository.findByEmail(email);
			ctr=1;
		} else {
			user = doctorRepository.findByMobile(email);
			ctr=2;
		}
		if (null != user) {
		//	model.addAttribute("msg", "reset link sent to mobile");
			user.setPassword(pass);
			user.setStatus("1");
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
			lang.put("Turkish", "Turkish");
			
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
		if(null==doctor.getCreated_at())
			doctor.setCreated_at(temp.getCreated_at());
		if(null==doctor.getStatus())
			doctor.setStatus(temp.getStatus());
		if(null==doctor.getProfile())
			doctor.setProfile(temp.getProfile());
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
				Optional<Doctor> doctor =	doctorRepository.findById(sessionPatient.getDoctorId());
				doctor.get().setPassword(newpassword);
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
		System.out.println("path=/experience");
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (sessionPatient != null) {
			Doctor doctor =	doctorRepository.findByMobile(sessionPatient.getMobile());
			
			
			m.addAttribute("userDoctor", sessionPatient);
			m.addAttribute("workExperienceList", doctor.getWorkExperienceList());
			m.addAttribute("educationList", doctor.getEducationList());
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
			Doctor doctor =	doctorRepository.findByMobile(sessionPatient.getMobile());
			m.addAttribute("userDoctor", sessionPatient);
		List<ServiceMaster>	 serviceMasterList = serviceMasterRepository.findAll();
		 List specialityList = masterRepository.findAll();
		//  m.addAttribute("specialityList",specialityList);
		m.addAttribute("serviceMasterList",serviceMasterList);	
		m.addAttribute("specializationMasterList",specialityList);	
		m.addAttribute("serviceDoctorList",doctor.getServiceDoctorList());	
		m.addAttribute("specializationDoctorList",doctor.getSpecializationDoctorList());
		return "servicedoc";
		}
		else {
			return "logind";
		}
	}
	
	
	
	@GetMapping("/awards")
	public String awardsdoc(HttpServletRequest req,Model m) {
		System.out.println("path=/awards	");
		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (sessionPatient != null) {
			Doctor doctor =	doctorRepository.findByMobile(sessionPatient.getMobile());
			m.addAttribute("userDoctor", sessionPatient);
			m.addAttribute("awardsList", doctor.getAwardsList());
			m.addAttribute("membershipList", doctor.getMembershipList());
			return "awardsdoc";
		}
		else {
			return "logind";
		}
	}

	/*
	 * @GetMapping("/forgotPassword") public String forgot(@RequestParam(value =
	 * "msg", required = false) String msg, Model model) {
	 * System.out.println("path=/admin/forgotPassword"); if (msg != null)
	 * model.addAttribute("msg", msg);
	 * 
	 * return "forgotPasswordd"; }
	 */
	void sendEmail(Doctor doctor) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(""+doctor.getEmail());

        msg.setSubject("Reset mail from DigiKlinik");
      //  msg.setText(patient.getOtpList().get(0).toString());
        String url = "http://"+hospitalUrl+"/doctor/reset/"+doctor.getEmail();
        msg.setText(url);
        javaMailSender.send(msg);

    }
}
