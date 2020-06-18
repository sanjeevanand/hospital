package com.hospital.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.jpa.DoctorRepository;
import com.hospital.jpa.MasterRepository;
import com.hospital.jpa.OtpRepository;
import com.hospital.jpa.RegistrationRepository;
import com.hospital.jpa.ServiceMasterRepository;
import com.hospital.jpa.SpecializationMasterRepository;
import com.hospital.model.Doctor;
import com.hospital.model.Registration;

@Controller
@RequestMapping("/admin")
public class AdminContoller {
	
	@Autowired
	private RegistrationRepository registrationRepository;


	@Autowired
	private OtpRepository otpRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	private MasterRepository masterRepository;
	
	@Autowired
	private ServiceMasterRepository serviceMasterRepository;
	
	@Autowired
	private SpecializationMasterRepository specializationMasterRepository;

	@GetMapping("/")
	public String homepage(HttpServletRequest request) {
		
		
		  Registration sessionUser = (Registration) request.getSession().getAttribute("user");
		  if (sessionUser != null) 
			  return "dashboard_admin"; 
		  else
		      return "login_admin";
	}
	@PostMapping("loginSubmit")
	public String loginSubmit(HttpServletRequest req, Model m) {
		System.out.println("path=/admin/loginSubmit");
		String email = req.getParameter("userName");
		String pswd = req.getParameter("password");
		Registration user = registrationRepository.findByEmail(email);
		if (user != null) {
			// Registration user = (Registration) session.getAttribute("user");
			Registration sessionUser = (Registration) req.getSession().getAttribute("user");

			if (user.getPassword().equals(pswd)) {
				if (sessionUser == null) {

					req.getSession().setAttribute("user", user);
				}
				if (user.getStatus().equals("admin"))// CKConstant.STATUS_EMAIL))
				{
					System.out.println("path=/admin/success");
					m.addAttribute("patient", 0);//PatientRepository.count());
					return "dashboard_admin";
				} else {
					System.out.println("path=/admin/lock");
					m.addAttribute("email", "Please activate your account");
					return "login_admin";
				}

			} else {
				System.out.println("path=/admin/fail");
				m.addAttribute("pwd", "Invalid Password");
				return "login_admin";
			}
		} else {
			System.out.println("path=/admin/fail");
			m.addAttribute("email", "Invalid email ID or user does not exist");
			return "login_admin";
		}
	}
	@GetMapping("/dashboard")
	public String dashboard(HttpServletRequest request) {
		/*
		 * Registration sessionUser = (Registration)
		 * request.getSession().getAttribute("user"); if (sessionUser != null) return
		 * "home"; else return "redirect:/admin/";
		 */
		return "dashboard_admin";
	}
  @GetMapping("appointments")	
   public String appointments() {
	   return "appointments";
   }
  @GetMapping("doctorslist")	
  public String doctorslist() {
	   return "doctorslist";
  }
  @GetMapping("createdocter")	
  public String createdocter(Model m) {
	  m.addAttribute("doctor", new Doctor());
	   return "createdocter";
  }
  @PostMapping("/saveDoctor")
	public String saveDoctor(@Valid @ModelAttribute("doctor") Doctor doctor,BindingResult bResult,Model m,HttpServletRequest req) {
		
		if(bResult.hasErrors()){
			return "createdocter";
		}else{
		//Doctor temp =  (Doctor) req.getSession().getAttribute("userDoctor");
		//if(null==doctor.getPassword())
		//	doctor.setPassword(temp.getPassword());
		
		doctorRepository.save(doctor);	
		//req.getSession().setAttribute("userDoctor", doctor);
		m.addAttribute("msg", "Record inserted !");
		return "doctorslist";
		}
	}
  @GetMapping("doctersmaster")	
  public String doctersmaster(Model m) {
	  
	  List specialityList = masterRepository.findAll();
	  m.addAttribute("specialityList",specialityList);
	   return "doctersmaster";
  }
 @GetMapping("/delete/speciality") 
 public String deletedoctersmaster(@RequestParam("selectId") long theId) {
	  
	  masterRepository.delete(masterRepository.findByselectId(theId));
	   return "redirect:/admin/doctersmaster";
  }
  
 @GetMapping("servicemaster")	
 public String servicemaster(Model m) {
	  
	  List specialityList = serviceMasterRepository.findAll();
	  m.addAttribute("specialityList",specialityList);
	   return "servicemaster";
 }
 @GetMapping("specializationmaster")	
 public String specializationmaster(Model m) {
	  
	  List specialityList = specializationMasterRepository.findAll();
	  m.addAttribute("specialityList",specialityList);
	   return "specializationmaster";
 }
  
  @GetMapping("patientslist")	
  public String patientslist() {
	   return "patientslist";
  }

  @GetMapping("createpatients")	
  public String createpatients() {
	   return "createpatients";
  }
  
}
