/********************************************************************************************
 * @purpose  :Utility class for reusable codes
 * @author   :Rahul C H
 * @version  :1.0
 * @date     :14-11-2019
 * @Filename :Utility.java
 ********************************************************************************************/

package com.bridgelab.utility;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Utility {
	// resuable static object for scanner class  
		public static Scanner scan =  new Scanner(System.in);
    //reusable static Object for PrintWriter class 
		public static PrintWriter pw = new PrintWriter(System.out);
	/**
	 * function  to sort a arrya using insertion sort
	 * @param takes input  unsorted Integer array
	 * @return sorted integer array
	 */
	public static int[] insertionSort(int[] a) {
	int n = a.length , value = 0 , hole = 0 ; 
	for(int i = 0 ; i<=n-1 ; i++) {
	value = a[i];
	hole = i;
	while(hole>0&&a[hole-1]>value) {
		a[hole] = a[hole-1];
		hole = hole -1;
	}
	a[hole]=value;
	}
	return a ; 
	}
	
	
	/**
	 * Function to sort implementing bubble sort algorithm
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] bubbleSort(int[] arr) {
		int temp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

				}
			}
		}
		return arr;
	}

	/**
	 * Function to sort string array using bubble sort algorithm
	 * 
	 * @param arr the array which needs to be sorted
	 */
	public static void bubbleSort(String[] arr) {
		String temp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareToIgnoreCase(arr[j]) > 0) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

				}
			}
		}
	}
	
	
	/**
	 * FUnction to print the  integer 2DARRAY  
	 * @param n the 2Darrya
	 */
	public static void PrintArr(int a[][]) {
		for(int b[] : a ) {
			for( int  c : b) {
				
				pw.print(c+" ");
				pw.flush();
			}
			System.out.println();
		}
	}
	
	/**
	 * FUnction to print the  doubles 2DARRAY  
	 * @param n the 2Darrya
	 */
	public static void PrintArr(double a[][]) {
		for(double b[] : a ) {
			for( double  c : b) {
				pw.print(c+" ");
				pw.flush();
			}
			System.out.println();
		}
	}
	/**
	 * FUnction to print the  boolean 2DARRAY  
	 * @param n the 2Darrya
	 */
	public static void PrintArr(boolean a[][]) {
		for(boolean b[] : a ) {
			for( boolean  c : b) {
			if(c ==  true) {
				pw.print("1 ");
				pw.flush();
			}
			else {
				pw.print("0 ");
				pw.flush();
			}
			}
			System.out.println();
		}
	}

	/**
	 * Function to count the characters in a string alphabaticlally and return array
	 * of the count of each alphabet
	 * 
	 * @param s the string given to count
	 * @return the array for counted characters
	 */
	public static int[] count(String s) {
		s = s.toLowerCase();
		int[] c = new int[25];
		for (int i = 0; i < s.length(); i++) {
			c[s.charAt(i) - 97]++;
		}
		return c;
	}
	
	/**
	 * Function to count the value in given integer be place
	 * 
	 * @param n the integer value to count
	 * @return the integer array for the count value
	 */
	public static int[] count(int n) {
		int[] count = new int[10];
		int temp = n;
		while (temp != 0) {
			int r = temp % 10;
			count[r]++;
			temp = temp / 10;
		}
		return count;
	}
	/**
	 * Function to check the two strings are anagrams or not
	 * 
	 * @param s1 the first string to check
	 * @param s2 the second string to check
	 * @return true if its string and vice-versa
	 */
	public static boolean anagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		int[] s1count = count(s1);
		int[] s2count = count(s2);
		for (int i = 0; i < s2count.length; i++) {
			if (s2count[i] != s1count[i]) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Function helping prime() to check if prime is pallindrome and print it
	 */
	public static void primePallindrome() {
		System.out.println();
		boolean b;
		for (int j = 2; j <= 1000; j++) {
			b = true;
			for (int i = 2; i < j / 2; i++) {
				if (j % i == 0) {
					b = false;
					break;
				}
			}
			if (b && isPallindrome(j))
				System.out.print(j + " ");
		}
	}
	

	/**
	 * Function to check if no is anagram or not
	 */
	public static void primeAnagrams() {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		System.out.println();
		boolean b;
		for (int j = 2; j <= 1000; j++) {
			b = true;
			for (int i = 2; i < j / 2; i++) {
				if (j % i == 0) {
					b = false;
					break;
				}
			}
			if (b)
				ar.add(j);
		}
		for (int i = 0; i < ar.size(); i++) {
			for (int j = i + 1; j < ar.size(); j++) {
				if (anagram(ar.get(i), ar.get(j))) {
					System.out.println(ar.get(i) + "  " + ar.get(j));
				}
			}
		}
	}
	/**
	 * to check the values are anagrams or not
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static boolean anagram(int n1, int n2) {
		int[] n1count = count(n1);
		int[] n2count = count(n2);
		for (int i = 0; i < n2count.length; i++) {
			if (n1count[i] != n2count[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Function to print the prime no between to 1 to 1000
	 */
	public static void prime() {
		boolean b;
		for (int j = 2; j <= 1000; j++) {
			b = true;
			for (int i = 2; i < j / 2; i++) {
				if (j % i == 0) {
					b = false;
					break;
				}
			}
			if (b)
				System.out.print(j + " ");
		}
	}
	/**
	 * function to chekc if given no is prime or not
	 * 
	 * @param n thenumber which to check for prime
	 * @return true if prime false if not
	 */
	public static boolean isPrime(int n) {
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Function to find the is pallindrome or not
	 * 
	 * @param n the integer which to check for pallindrome
	 * @return true if its pallindrome or false if its not
	 */
	public static boolean isPallindrome(int n) {
		int temp = n;
		int sum = 0;
		while (temp != 0) {
			int r = temp % 10;
			sum = sum * 10 + r;
			temp = temp / 10;
		}
		if (sum == n) {
			return true;
		}
		return false;
	}
	/**
	 * Function to check the day of the week of given date
	 *
	 * @param d int value for day of date
	 * @param m int value for month of year
	 * @param y int value for year
	 * @return day of week from 1 to 7
	 */
public 	static int dayOfWeek(int d, int m, int y) {
		int y0 = y - (14 - m) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = m + 12 * ((14 - m) / 12) - 2;
		int d0 = (d + x + (31 * m0) / 12) % 7;
		return d0;
	}

	/**
	 * Function to convert fahrenheit to celcius and vice-versa
	 *
	 * @param tem the value of temperature
	 * @param t   the character ie c or f for given temp to convert
	 * @return converted temperature
	 */
	
	public static int temperaturConversion(int tem, char t) {
		int conver;
		if (t == 'c' || t == 'C') {
			conver = (tem * 9 / 5) + 32;
		} else if (t == 'f' || t == 'F') {
			conver = (tem - 32) * 5 / 9;
		} else {
			System.out.println("Enter correct input");
			return 0;
		}
		return conver;
	}
	

	public static int binary(int[]arr , int n) {
	   int high = arr.length-1  , low = 0 , mid ; 
	   Arrays.sort(arr);
	   while(low<=high) {
		   mid = (high+low)/2;
		   if(n==arr[mid]) {
			   return mid;
		   }else if(arr[mid]<n) {
			   low = mid+1;
		   }else {
			   high = mid -1;
		   }
	   }
		return -1;
	}
	
/**
 * to search a word using binary
 * @param arr
 * @param s word which is to be searched 
 * @return integer index 
 */
	public static int binary(String[] arr ,String s) {
		int high = arr.length-1 , low = 0 , mid;
		Arrays.sort(arr);
		
		while(low<=high) {
			mid =(high+low)/2;
			if(s.equalsIgnoreCase(arr[mid])) {
				return mid;
			}else if(arr[mid].compareToIgnoreCase(s)<0) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		
		return -1;
	}
	/**
	 * to calculate monthly payment for r interest and p principal for y years
	 *
	 * @param p the principal amount given
	 * @param y the year for which p is given
	 * @param r the rate at which p is given
	 * @return monthly payment
	 */
 public	static double monthlyPayment(double p, double y, double r) {
		double n = 12 * y;
		double r0 = r / (12 * 100);
		double payment = p * r0 / (1 - Math.pow((1 + r0), -n));
		return payment;
	}

	/**
	 * Function to find the square root of given no
	 *
	 * @param c the value to find square root of
	 * @return return the square root
	 */
 public	static double sqrt(double c) {

		double t = c;
		double epsilon = 1e-15;
		while (Math.abs(t - c / t) > epsilon * t) {
			t = (c / t + t) / 2;
		}

		return t;
	}

	/**
	 * Function to convert decimal to binary
	 *
	 * @param d integer value to convert
	 * @return return integer array with binary digits
	 */
	public static int[] toBinary(int d) {

		String bin = "";
		while (d != 0) {
			bin = (d % 2) + bin;
			d /= 2;
		}
		while (bin.length() % 4 != 0) {
			bin = 0 + bin;
		}
		return stringToIntArray(bin);
	}

	/**
	 * Function to convert string to int array helper function for swapnibble in
	 * Binary.java class
	 *
	 * @param bin String of binary no
	 * @return return integer array
	 */
	static int[] stringToIntArray(String bin) {
		int[] binary = new int[bin.length()];
		for (int i = 0; i < binary.length; i++) {
			binary[i] = bin.charAt(i) - 48;
		}
		return binary;
	}

	/**
	 * Function to convert binary to decimal
	 *
	 * @param binary the binary array to convert
	 * @return return converted decimal no
	 */
	public static int toDecimal(int[] binary) {
		int dec = 0, j = 0;
		for (int i = binary.length - 1; i>= 0; i--) {
			if (binary[i] == 1) {
				dec = dec + (int) Math.pow(2, j);
			}
			j++;
		}
		return dec;
	}
	
}
