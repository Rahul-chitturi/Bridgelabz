package com.bridgelabz.fundoonotes.utility;

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
}
