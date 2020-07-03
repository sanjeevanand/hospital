package com.hospital;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HospitalApplication  extends SpringBootServletInitializer {
	 private static final Logger logger =  LogManager.getLogger(HospitalApplication.class.getName());
	public static void main(String[] args) {
		
		SpringApplication.run(HospitalApplication.class, args);
		logger.debug("--Application Started--");
	}

}
