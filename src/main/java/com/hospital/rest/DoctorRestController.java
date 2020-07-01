package com.hospital.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.jpa.DoctorRepository;
import com.hospital.jpa.OtpRepository;
import com.hospital.model.Awards;
import com.hospital.model.Doctor;
import com.hospital.model.Education;
import com.hospital.model.Membership;
import com.hospital.model.Otp;
import com.hospital.model.ServiceDoctor;
import com.hospital.model.SpecializationDoctor;
import com.hospital.model.WorkExperience;
import com.hospital.sms.WSApiNN;
import com.hospital.util.HospitalUtil;

@RestController
@RequestMapping("/rest")
public class DoctorRestController {
	
	  private static final Logger logger = LoggerFactory.getLogger(DoctorRestController.class);
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	OtpRepository OtpRepository;
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${hospital.url}")
	private String hospitalUrl;

	@PostMapping(value = "/doctorRegistration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Doctor createUser(Doctor doctor) {
		logger.info("doctorRegistration");
		System.out.println(doctor);
		Doctor temp = null;
		int ctr = 0;
		if (null != doctor) {
			if (HospitalUtil.isEmail(doctor.getMobile())) {
				temp = doctorRepository.findByEmail(doctor.getMobile());
				ctr = 1;
			} else {
				temp = doctorRepository.findByMobile(doctor.getMobile());
				ctr = 2;
			}
		}
		if (null == temp) {
			Random x = new Random();
			String otp = "P" + x.nextInt(9999);
			System.out.println(otp);
			// doctor.setAddress(new Address());
			doctor.addOtpList(new Otp(otp, new Date()));
			doctor.setCreated_at(new Date());
			if (ctr == 1) {
				doctor.setEmail(doctor.getMobile());
				doctor.setMobile("");

			}
			Doctor stored = doctorRepository.save(doctor);
			if (ctr == 1)
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
			Doctor x = new Doctor();
			x.setFirstname("exist");
			return x;
		}
	}

	@PostMapping(value = "/doctorOtpVerify")
	public boolean otpVerify(@RequestParam Map<String, String> arg) {
		Doctor obj = null;
		if (HospitalUtil.isEmail(arg.get("mobile"))) {
			obj = doctorRepository.findByEmail(arg.get("mobile"));
		} else {
			obj = doctorRepository.findByMobile(arg.get("mobile"));
		}
	//	Doctor obj = doctorRepository.findByMobile(arg.get("mobile"));
		int i = obj.getOtpList().size();
		Otp otp = obj.getOtpList().get(i-1);
		if (("P" + arg.get("otp")).equals(otp.getOtp())) {
			obj.setStatus("1");
			return true;
		}
		else
		{
			return false;
		}
	}

	@PostMapping(value = "/doctorDeactivate", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public boolean deativate(HttpServletRequest req, Model m) {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean deactivate = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
			doctorRepository.delete(obj);
			deactivate = true;
		} else {
			deactivate = false;
		}
		return deactivate;
	}

	@PostMapping(value = "/doctorRegistrationDoc")
	public boolean doctorRegistrationDoc(HttpServletRequest req, Model m, Doctor doctor) {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
			obj.setRegNo(doctor.getRegNo());
			obj.setRegYear(doctor.getRegYear());
			req.getSession().setAttribute("userDoctor", obj);
			save = true;
		} else {
			save = false;
		}
		return save;
	}

	@PostMapping(value = "/doctorExperiencedDoc")
	public boolean doctorExperiencedDoc(HttpServletRequest req, Model m, WorkExperience workExperience) {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
			obj.addworkExperienceList(workExperience);
			doctorRepository.save(obj);
			req.getSession().setAttribute("userDoctor", obj);
			save = true;
		} else {
			save = false;
		}
		return save;
	}
	@GetMapping(value = "/deleteDoctorExperiencedDoc/{experience}")
	public void deleteDoctorExperiencedDoc(@PathVariable("experience") String experience,HttpServletRequest req,HttpServletResponse response) throws IOException {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
		List<WorkExperience>	newList = new ArrayList<>();
		
			for(WorkExperience x : obj.getWorkExperienceList()){
				if(experience.equals(x.getExperience()))
				newList.add(x);
			}
			obj.getWorkExperienceList().removeAll(newList);
			doctorRepository.save(obj);
			req.getSession().setAttribute("userDoctor", obj);
		response.sendRedirect("/doctor/experience");
		}else {
			response.sendRedirect("/doctor/");
		}
	}

	@PostMapping(value = "/doctorEducationDoc")
	public boolean doctorEducationDoc(HttpServletRequest req, Model m, Education education) {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
			// obj.setRegNo(doctor.getRegNo());
			// obj.setRegYear(doctor.getRegYear());
			obj.addEducationList(education);
			req.getSession().setAttribute("userDoctor", obj);
			save = true;
		} else {
			save = false;
		}
		return save;
	}
	@GetMapping(value = "/deleteDoctorEducationDoc/{education}")
	public void deleteDoctorEducationDoc(@PathVariable("education") String education,HttpServletRequest req,HttpServletResponse response) throws IOException {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
		List<Education>	newList = new ArrayList<>();
		
			for(Education x : obj.getEducationList()){
				if(education.equals(x.getEducation()))
				newList.add(x);
			}
			obj.getEducationList().removeAll(newList);
			doctorRepository.save(obj);
			req.getSession().setAttribute("userDoctor", obj);
		response.sendRedirect("/doctor/experience");
		}else {
			response.sendRedirect("/doctor/");
		}
	}
	@PostMapping(value = "/doctorAwardsDoc")
	public boolean doctorAwardsDoc(HttpServletRequest req, Model m, Awards awards) {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
			// obj.setRegNo(doctor.getRegNo());
			// obj.setRegYear(doctor.getRegYear());
			obj.addawardsList(awards);
			req.getSession().setAttribute("userDoctor", obj);
			save = true;
		} else {
			save = false;
		}
		return save;
	}
	@GetMapping(value = "/deleteDoctorAwardsDoc/{awards}")
	public void deleteDoctorAwardsDoc(@PathVariable("awards") String awards,HttpServletRequest req,HttpServletResponse response) throws IOException {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
		List<Awards>	newList = new ArrayList<>();
		
			for(Awards x : obj.getAwardsList()){
				if(awards.equals(x.getAwards()))
				newList.add(x);
			}
			obj.getAwardsList().removeAll(newList);
			doctorRepository.save(obj);
			req.getSession().setAttribute("userDoctor", obj);
		response.sendRedirect("/doctor/awards");
		}else {
			response.sendRedirect("/doctor/");
		}
	}
	@PostMapping(value = "/doctorMembershipsDoc")
	public boolean doctorMembershipsDoc(HttpServletRequest req, Model m, Membership membership) {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
			// obj.setRegNo(doctor.getRegNo());
			// obj.setRegYear(doctor.getRegYear());
			obj.addMembershipList(membership);
			req.getSession().setAttribute("userDoctor", obj);
			save = true;
		} else {
			save = false;
		}
		return save;
	}
	
	@GetMapping(value = "/deleteDoctorMemberDoc/{member}")
	public void deleteDoctorMemberDoc(@PathVariable("member") String member,HttpServletRequest req,HttpServletResponse response) throws IOException {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
		List<Membership>	newList = new ArrayList<>();
		
			for(Membership x : obj.getMembershipList()){
				if(member.equals(x.getMember()))
				newList.add(x);
			}
			obj.getMembershipList().removeAll(newList);
			doctorRepository.save(obj);
			req.getSession().setAttribute("userDoctor", obj);
		response.sendRedirect("/doctor/awards");
		}else {
			response.sendRedirect("/doctor/");
		}
	}
	@PostMapping(value = "/serviceDoctorDoc")
	public boolean serviceDoctorDoc(HttpServletRequest req, Model m, ServiceDoctor serviceDoctor) {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
			// obj.setRegNo(doctor.getRegNo());
			// obj.setRegYear(doctor.getRegYear());
			obj.addServiceDoctorList(serviceDoctor);
			req.getSession().setAttribute("userDoctor", obj);
			save = true;
		} else {
			save = false;
		}
		return save;
	}
	@GetMapping(value = "/deleteServiceDoctorDoc/{service}")
	public void deleteServiceDoctorDoc(@PathVariable("service") String service,HttpServletRequest req,HttpServletResponse response) throws IOException {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
		List<ServiceDoctor>	newList = new ArrayList<>();
		
			for(ServiceDoctor x : obj.getServiceDoctorList()){
				if(service.equals(x.getService()))
				newList.add(x);
			}
			obj.getServiceDoctorList().removeAll(newList);
			doctorRepository.save(obj);
			req.getSession().setAttribute("userDoctor", obj);
		response.sendRedirect("/doctor/services");
		}else {
			response.sendRedirect("/doctor/");
		}
	}
	@PostMapping(value = "/specializationDoctorDoc")
	public boolean specializationDoctorDoc(HttpServletRequest req, Model m, SpecializationDoctor specializationDoctor) {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
			// obj.setRegNo(doctor.getRegNo());
			// obj.setRegYear(doctor.getRegYear());
			obj.addspecializationDoctorList(specializationDoctor);
			req.getSession().setAttribute("userDoctor", obj);
			save = true;
		} else {
			save = false;
		}
		return save;
	}
	@GetMapping(value = "/deleteSpecializationDoctorDoc/{specialization}")
	public void deleteSpecializationDoctorDoc(@PathVariable("specialization") String specialization,HttpServletRequest req,HttpServletResponse response) throws IOException {

		Doctor sessionPatient = (Doctor) req.getSession().getAttribute("userDoctor");
		boolean save = false;
		if (sessionPatient != null) {
			Doctor obj = doctorRepository.findByMobile(sessionPatient.getMobile());
		List<SpecializationDoctor>	newList = new ArrayList<>();
		
			for(SpecializationDoctor x : obj.getSpecializationDoctorList()){
				if(specialization.equals(x.getSpecialization()))
				newList.add(x);
			}
			obj.getSpecializationDoctorList().removeAll(newList);
			doctorRepository.save(obj);
			req.getSession().setAttribute("userDoctor", obj);
		response.sendRedirect("/doctor/services");
		}else {
			response.sendRedirect("/doctor/");
		}
	}
	void sendEmail(Doctor doctor) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(""+doctor.getEmail());

        msg.setSubject("Welcome mail from DigiKlinik");
        String msg1 = "your otp is "+doctor.getOtpList().get(0).getOtp();
        String url = "http://"+hospitalUrl+"/rest/doctorverifyLink/"+doctor.getEmail();
        msg.setText(url);



        
        javaMailSender.send(msg);

    }
	@GetMapping(value = "/doctorverifyLink/{email:.+}")
	public void doctorverifyLink(@PathVariable("email") String email,HttpServletRequest req,HttpServletResponse response) throws IOException {

			Doctor obj = doctorRepository.findByEmail(email);
		    obj.setStatus("1");
			doctorRepository.save(obj);
		response.sendRedirect("/doctor/");
	}
}
