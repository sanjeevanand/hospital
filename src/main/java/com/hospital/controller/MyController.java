package com.hospital.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hospital.jpa.DoctorRepository;
import com.hospital.model.Doctor;
import com.hospital.util.StorageException;
import com.hospital.util.StorageService;

@Controller
public class MyController {

    @Autowired
    private StorageService storageService;
    @Autowired
	DoctorRepository doctorRepository;

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST,
            consumes = {"multipart/form-data"})
    public String upload(@RequestParam MultipartFile file,HttpServletRequest req, Model m) {

    	
    	System.out.println("path=/doUpload");
		Doctor doctor = (Doctor) req.getSession().getAttribute("userDoctor");
	
		if (doctor != null) {
			 storageService.uploadFile(file);
			 doctor.setProfile(file.getOriginalFilename());
			 doctorRepository.saveAndFlush(doctor);
			 req.getSession().setAttribute("userDoctor", doctor);
		   	m.addAttribute("userDoctor", doctor);
			 return "redirect:/doctor/profile";
		}
		else {
			return "logind";
		}
       

       
    }

    @ExceptionHandler(StorageException.class)
    public String handleStorageFileNotFound(StorageException e) {

        return "redirect:/failure.html";
    }
}