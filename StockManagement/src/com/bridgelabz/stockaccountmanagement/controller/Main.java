package com.bridgelabz.stockaccountmanagement.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.stockaccountmanagement.model.CompanyDetails;
import com.bridgelabz.stockaccountmanagement.service.serviceimplementation.StockImplementation;
import com.bridgelabz.stockaccountmanagement.utility.StockUtility;

public class Main {

	static StockImplementation accountService = new StockImplementation();
	static String path = "JsonFile/";
	static File file;

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		System.out.println();
		System.out.println("Select following option ");
		System.out.println("1. Add Company Details");
		System.out.println("2. Remove Company Details");
		System.out.println("3. Create an Account");
		System.out.println("4. display Company details");
		
		String choice = StockUtility.inputString();
		if(StockUtility.intChecker(choice)) {
			switch (choice) {
			case "1":
				CompanyDetails companyDetails = CompanyShareController.companyDetails(); 
				file = new File("/home/user/git/Oops/StockManagement/src/jsonStock/CompanyList.json");
				accountService.addCompanyDetails(file,companyDetails);
				menu();
				break;
			case "2":
				System.out.println("Enter Company Symbol");
				String symbol = StockUtility.inputString();
				accountService.removeCompanyDetails(symbol);
				menu();
				break;
			case "3":
				System.out.println("Create an Account");
				System.out.println("ENETER NAME:");
				String name = StockUtility.inputString();
				createAccount(name);
				menu();
				break;
			case "4" :
				accountService.printCompanyDetails();
				menu();
				break;
			default:
				System.out.println("Invalid Option");
				menu();
				break;
			}
		}
	}

	private static void createAccount(String fileName) {
				
		file = new File("/home/user/git/Oops/StockManagement/src/jsonStock/"+fileName+".json");
	
		try(FileWriter fileWriter = new FileWriter(file)){
		
			
			System.out.println(fileName+" Created Successfully !!!");
			if(file.length()==0) {
				String defaultValue = "[]";
				fileWriter.write(defaultValue);
				fileWriter.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		buyOrSellStock(file);
	}

	public static void buyOrSellStock(File file2) {
		System.out.println("1. Buy Some Share");
		System.out.println("2. Sell some Share");
		System.out.println("3. Print Transaction");
		System.out.println("4. back to main menu");
	
		double amount;
		String symbol;
		
		String choice = StockUtility.inputString();
		switch(choice) {
		case "1":
			System.out.println("Enter amount :\nEnter Symbol :");
			amount = StockUtility.inputDouble();
			symbol = StockUtility.inputString();
			accountService.buyShare(amount,symbol,file2);
			buyOrSellStock(file2);
			break;
		case "2":
			System.out.println("Enter amount :\nEnter Symbol :");
			amount = StockUtility.inputDouble();
			symbol = StockUtility.inputString();
			accountService.sellShare(amount,symbol,file2);
			buyOrSellStock(file2);
			break;
		case "3":
			accountService.printTransactiolnDetails();
			buyOrSellStock(file2);
			break;
		case "4":
			menu();
			break;
			default: System.out.println("Invalid option");
		}
		
	}

}
