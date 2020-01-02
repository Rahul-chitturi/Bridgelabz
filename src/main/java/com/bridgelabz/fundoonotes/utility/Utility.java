package com.bridgelabz.fundoonotes.utility;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utility {

	/**
	 * used to encrypt the password and returns password
	 * 
	 * @param password
	 * @return
	 */
	public static String getEncryPassWord(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}
	
	public static  boolean checkPassword(String pass , String newPass) {
		
	return 	BCrypt.checkpw(newPass, pass);
	
	}
}
