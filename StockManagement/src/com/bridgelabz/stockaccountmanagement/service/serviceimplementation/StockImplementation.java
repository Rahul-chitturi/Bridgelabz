package com.bridgelabz.stockaccountmanagement.service.serviceimplementation;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
<<<<<<< HEAD
=======
import java.util.Set;

>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.stockaccountmanagement.model.CompanyDetails;
import com.bridgelabz.stockaccountmanagement.repository.StockData;
import com.bridgelabz.stockaccountmanagement.service.StockAccount;
import com.bridgelabz.stockaccountmanagement.utility.Queue;
import com.bridgelabz.stockaccountmanagement.utility.Stack;

public class StockImplementation implements StockAccount {

	String path = "/home/user/git/Oops/StockManagement/src/jsonStock/CompanyList.json";
	File fileRead = new File(path);
	Stack<String> Stack;
	Queue<String> Queue;
	CompanyDetails[] companyShares;

	public StockImplementation() {
		Stack = new Stack<>();
		Queue = new Queue<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addCompanyDetails(File file, CompanyDetails companyDetails) {
		JSONObject jsonObject = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject baseJson = (JSONObject) StockData.readData(file);
		JSONObject json = (JSONObject) baseJson.get("STOCK MARKET");

		jsonObject.put("CompanyName", companyDetails.getCompanyName());
		jsonObject.put("CompanySymbol", companyDetails.getCompanySymbol());
		jsonObject.put("NumberOfShare", companyDetails.getNumberOfShare());
		jsonObject.put("Price", companyDetails.getPrice());
		jsonObject.put("Date", companyDetails.getDateTime());

		array.add(jsonObject);
		json.put(companyDetails.getCompanySymbol(), array);

		StockData.writeData(file, baseJson);
	}

<<<<<<< HEAD
	@SuppressWarnings({ "unchecked", "unused" })
=======
	@SuppressWarnings("unchecked")
>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
	public void buyShare(double amount, String symbol, File fileWrite) {
		int count = 0;
		double price = 0;
		JSONArray array, jsonArray = null;

		JSONObject jsonObject = StockData.readData(fileRead);
		JSONObject json = (JSONObject) jsonObject.get("STOCK MARKET");
		System.out.println(json);
		long Nshare = 0;
		if ((array = (JSONArray) json.get(symbol)) != null) {
			jsonArray = array;
			Iterator<?> iterator = array.iterator();
			while (iterator.hasNext()) {
				JSONObject cDetails = (JSONObject) iterator.next();
				Nshare = (long) cDetails.get("NumberOfShare");
				price = (double) cDetails.get("Price");
			}
			price  = price / Nshare;
			System.out.println(amount/price);
			int numberOfShare = (int) Math.round(amount/price);
			System.out.println("Share :" + numberOfShare);

			array = updateCompanyDetails(jsonArray, numberOfShare , price);
			LocalDateTime current = LocalDateTime.now();
			// System.out.println("current date and time : "+ current);
			// to print in a particular format
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

			String dateTime = current.format(format);

			JSONObject accountObject = new JSONObject();
			accountObject.put("Symbol", symbol);
			accountObject.put("PurchaseShare", numberOfShare);
			accountObject.put("PurchaseTime", dateTime);
			accountObject.put("Price", price);

			JSONArray array2 = new JSONArray();
			array2.add(accountObject);

			StockData.writeData(fileRead, jsonObject);
			StockData.writeData(fileWrite, array2);

			Stack.push("Purchased");
			Queue.enqueue(dateTime);
		} else {
			System.out.println("The Stock you are trying to purchase is not available in Stock Market");
		}

	}

<<<<<<< HEAD
	@SuppressWarnings("unchecked")
=======
>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
	private JSONArray updateCompanyDetails(JSONArray jsonArray, int numberOfShare , double price) {
		long updatedShare = 0;

		Iterator<?> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			JSONObject type = (JSONObject) iterator.next();
			updatedShare = (long) type.get("NumberOfShare");
			System.out.println("updated share " + updatedShare);
			if (numberOfShare > updatedShare) {
				System.out.println("Number of Share should be less than total share which is :" + updatedShare);
			} else {
				updatedShare = (updatedShare - numberOfShare);
				type.put("NumberOfShare", updatedShare);
				type.put("Price",(double) price *updatedShare);
			}
		}
		return jsonArray;
	}

	@Override
	public void sellShare(double amount, String symbol, File file2) {
		double price = 0;
		JSONArray jsonArray = StockData.readArrayData(file2);
		if (jsonArray.size() != 0) {
			Iterator<?> iterator = jsonArray.iterator();
			JSONObject jsonObject, accountJson = null;
			while (iterator.hasNext()) {
				if ((jsonObject = (JSONObject) iterator.next()).get("Symbol").equals(symbol)) {
					if (jsonObject.get("PurchaseShare") != null) {
						accountJson = jsonObject;
						price = (double) jsonObject.get("Price");
					}
					}
			}
			
			int numberOfShare = (int) Math.round(price / amount);
			System.out.println("Share :" + numberOfShare);

			jsonObject = updateAccountDetails(accountJson, numberOfShare);

			StockData.writeData(file2, jsonObject);
		} else {
			System.out.println("You doesn't have any share please buy some share berfore selling\n");
		}
	}

	public void printCompanyDetails() {
		String pathe = "/home/user/git/Oops/StockManagement/src/jsonStock/CompanyList.json";
		File fileR = new File(pathe);
		JSONObject json = StockData.readData(fileR);
		JSONObject Stock = (JSONObject) json.get("STOCK MARKET");
<<<<<<< HEAD
		@SuppressWarnings("unused")
=======
>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
		JSONArray arr = new JSONArray();

		Object[] Keys = Stock.keySet().toArray();
		for (Object i : Keys) {
			JSONArray a = (JSONArray) Stock.get(i);
			for (Object j : a) {
				JSONObject m = (JSONObject) j;
				System.out.println("CompanyName   :" + m.get("CompanyName"));
				System.out.println("NumberOfShare :" + m.get("NumberOfShare"));
				System.out.println("Price         :" + m.get("Price"));
				System.out.println("CompanySymbol :" + m.get("CompanySymbol"));
				System.out.println("Date          :" + m.get("Date"));
				System.out.println();
			}
		}
	}

<<<<<<< HEAD
	@SuppressWarnings("unchecked")
=======
>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
	private JSONObject updateAccountDetails(JSONObject accountJson, int numberOfShare) {
		long share = (long) accountJson.get("PurchaseShare");
		long updatedShare = 0;
		String dateTime = "";
		if (share > numberOfShare) {
			updatedShare = share - numberOfShare;
			accountJson.put("SoldShare", updatedShare);
			LocalDateTime current = LocalDateTime.now();
			// to print in a particular format
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

			dateTime = current.format(format);
			Stack.push("Sold");
			Queue.enqueue(dateTime);

		} else {
			System.out.println("You are trying to sell Over limit you habve only " + share + " share");
		}

		accountJson.put("SoldTime", dateTime);

		return accountJson;
	}

<<<<<<< HEAD
	@SuppressWarnings("unchecked")
=======
>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
	@Override
	public void removeCompanyDetails(String symbol) {
		JSONObject jsonObj = StockData.readData(fileRead);
		JSONObject jsonObj1 = (JSONObject) jsonObj.get("STOCK MARKET");
		JSONObject jsonObj2 = new JSONObject();

		if (jsonObj1.containsKey(symbol)) {
			jsonObj1.remove(symbol);
			jsonObj2.put("STOCK MARKET", jsonObj1);

			StockData.writeData(fileRead, jsonObj2);
			System.out.println("Success.....");
		} else {
			System.out.println("not found");
		}
	}

	@Override
	public void printTransactiolnDetails() {
		/**
		 * prints queue
		 */

		System.out.println("\nTransactions Queue:");
		while (!Queue.isEmpty()) {
			System.out.println(Queue.deque());
		}

		/**
		 * prints stack
		 */
		System.out.println("\nTransactions Stack:");
		while (!Stack.isEmpty()) {
			System.out.println(Stack.pop());
		}

	}

}
