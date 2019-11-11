/******************************************************************************
 * Purpose:  Program to sumofnumberaddsto0
 *
 * @author RAHUL C H
 * @version 10.0   
 * @since 11-11-2019
 *
 ******************************************************************************/
package functionals;
import java.util.Scanner;

public class SumOfNumberAddsTo0 {

	/*
	 * static scanner to take input from different methods
	 */
	static Scanner s = new Scanner(System.in);

	/**
	 * function to check sum of triplets is 0
	 * 
	 * @param n the no of elements to check for for creation of array
	 */
	static void sum0count(int n) {
		int[] arr = new int[n];
		int count = 0;
		System.out.println("enter values");
		// taking integer input for creating array
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		// checking for triplets by loop
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						count++;
						System.out.println(arr[i] + "+" + arr[j] + "+" + arr[k] + "=" + "0");
					}
				}
			}
		}
		// output
		System.out.println("total pairs are " + count);

	}

	public static void main(String[] args) {

		System.out.println("enter no of inputs");
		int n = s.nextInt();
		sum0count(n);

	}
}
