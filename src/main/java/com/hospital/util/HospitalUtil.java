package com.hospital.util;

public class HospitalUtil {
	
	public static boolean isMobile(String mobile) {
		boolean result = false;
		if(!mobile.isEmpty()) {
			if(!mobile.contains("@"))
			result = true;
			else
				result = false;
		}else {
			result = false;
		}
		return result;
	}
public static boolean isEmail(String email) {
		
	boolean result = false;
	if(!email.isEmpty()) {
		if(email.contains("@"))
			result = true;
			else
		result = false;
	}else {
		result = false;
	}
	return result;
	}
}
