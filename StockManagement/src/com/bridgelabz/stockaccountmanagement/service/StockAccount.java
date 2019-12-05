package com.bridgelabz.stockaccountmanagement.service;

import java.io.File;
<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
import com.bridgelabz.stockaccountmanagement.model.CompanyDetails;

public interface StockAccount {
	


	void buyShare(double amount, String symbol, File fileWrite);

	void sellShare(double amount, String symbol, File file2);

	void removeCompanyDetails(String symbol);



	void printTransactiolnDetails();

	void addCompanyDetails(File file, CompanyDetails companyDetails);
}
