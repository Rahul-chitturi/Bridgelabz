package com.bridgelabz.stockaccountmanagement.service;

import java.io.File;


import com.bridgelabz.stockaccountmanagement.model.CompanyDetails;

public interface StockAccount {
	


	void buyShare(double amount, String symbol, File fileWrite);

	void sellShare(double amount, String symbol, File file2);

	void removeCompanyDetails(String symbol);



	void printTransactiolnDetails();

	void addCompanyDetails(File file, CompanyDetails companyDetails);
}
