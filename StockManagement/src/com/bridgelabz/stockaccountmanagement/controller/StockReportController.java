package com.bridgelabz.stockaccountmanagement.controller;

import com.bridgelabz.stockaccountmanagement.model.StockPortfolio;
import com.bridgelabz.stockaccountmanagement.utility.MyLinkedList;
import com.bridgelabz.stockaccountmanagement.utility.StockUtility;

public class StockReportController {
static MyLinkedList<StockPortfolio> list;
	
	public static void main(String[] args) {

		StockReportController report = new StockReportController();	//	class object
		StockReportController.getStockData();
		report.printReport();
	}

	/**
	 * gets user input of stock data
	 * @param-type: Takes no argument
	 * @return-type: Doesn't return anything
	 */
	static void getStockData() {
		System.out.println("Enter number of stocks: ");
		int count = StockUtility.inputInteger();
		list = new MyLinkedList<StockPortfolio>();
		
		for(int i = 0; i < count; i++) {
			System.out.println("Enter stock name, number of shares and share price: ");
			String name = StockUtility.inputString();
			int numberOfShares = StockUtility.inputInteger();
			int price = StockUtility.inputInteger();
			StockPortfolio stock = new StockPortfolio(name, numberOfShares, price);
			list.add(stock);
		}
		StockUtility.scannerClose();
	}
	
	/**
	 * Print the Stock Report
	 * @param-type: Takes no argument
	 * @return-type: Doesn't return anything
	 * 
	 */
	void printReport() {
		int totalValue = 0;
		
		System.out.println("----------STOCK REPORT----------");
		System.out.println("\nName\tShares\tPrice\tValue");
		while(!list.isEmpty()) {
			StockPortfolio folio = list.pop();
			totalValue += folio.getValue();
			System.out.println(folio.getName() + "\t" + folio.getNumberOfShares()
					+ "\t" + folio.getPrice() + " \t" + folio.getValue());
		}
		System.out.println("\nTotal stock value is: " + totalValue);
	}
}
