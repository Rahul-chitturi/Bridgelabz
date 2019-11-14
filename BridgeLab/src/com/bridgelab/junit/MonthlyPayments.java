package com.bridgelab.junit;
import java.util.Scanner;
import com.bridgelab.utility.Utility;
/******************************************************************************
 * Compilation: javac -d bin MonthlyPayment.java Execution: java -cp bin
 * com.bridgelabz.util.MonthlyPayment n
 * 
 * Purpose: to check the monthly payments for given amount ,duration and rate.
 *
  * @author RAHUL CHITTURI
 * @version 10.0
 * @since 11-11-2019
 *
 ******************************************************************************/

public class MonthlyPayments {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter principal ,year and rate");
		double p = s.nextDouble();
		double y = s.nextDouble();
		double r = s.nextDouble();
		s.close();
		System.out.println("mothly payment is " + Utility.monthlyPayment(p, y, r));
	}
}
