package com.bridgelab.basic;

import java.util.Scanner;

public class LeapYear {
	/**
	 * Function to check if year is leap year or not
	 * 
	 * @param year the value of year to check
	 * @return true if it is leap year or false if its not
	 */
	static boolean isLeap(int year) {
		return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter year in 4 digit");
		int year = s.nextInt();
		/*
		 * ensures the value is 4 digit
		 */
		while (year < 999 || year > 9999) {
			System.out.println("wrong input");
			System.out.println("enter year in 4 digit");
			year = s.nextInt();
		}
		if (isLeap(year)) {
			System.out.println(year + " is a leap year");
		} else
			System.out.println(year + " is not a leap year");
		s.close();

	}

}
