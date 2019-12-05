package com.bridgelabz.stockaccountmanagement.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bridgelabz.stockaccountmanagement.model.CompanyDetails;
import com.bridgelabz.stockaccountmanagement.utility.StockUtility;

public class CompanyShareController {
public static CompanyDetails companyDetails() {
		
		System.out.println("Enter Company Name");
		String cName = StockUtility.inputString();
		if(StockUtility.isStringOnlyAlphabet(cName)) {
			
		}
		
		System.out.println("Enter Company Symbol");
		String symbol = StockUtility.inputString();
		
		System.out.println("Enter Number of Share");
		int numberOfShare = StockUtility.inputInteger();
		
		
		System.out.println("Enter Price");
		double price = StockUtility.inputDouble();
		
		
		// will give us the current time and date 
	    LocalDateTime current = LocalDateTime.now(); 
	   // System.out.println("current date and time : "+ current); 
		// to print in a particular format 
	    DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd-MM-yyyy");   
	    
	    String dateTime = current.format(format);   
	     
	    //System.out.println("in foramatted manner "+ dateTime); 
	    
	    CompanyDetails companyShare = new CompanyDetails(cName,symbol,numberOfShare,price,dateTime);
		return companyShare;
	}
	
	
}
