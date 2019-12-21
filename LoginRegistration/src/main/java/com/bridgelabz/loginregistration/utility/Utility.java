package com.bridgelabz.loginregistration.utility;

import java.util.Base64;

public class Utility {
	public static String getPassword() {
		StringBuffer st = new StringBuffer("urhsiVAR");
		st.reverse();
		
		String pass = Base64.getEncoder().encodeToString(st.toString().getBytes());

		return pass;
	}
	
}
