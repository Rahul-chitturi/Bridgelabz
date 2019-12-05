package com.bridgelabz.designpattern.utility;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class Utility {




		static Scanner scanner = new Scanner(System.in);;// Taken Scanner as static
		static Random random= new Random(); // Taken Random as static

		/*
		 * returns InputString
		 */
		public static String inputString() {
			try {
				return scanner.next();
			} catch (Exception e) {
				System.out.println(e);
			}
			return "";
		}

		/*
		 * returns InputStringLine
		 */
		public static String inputStringLine() {
			try {
				return scanner.nextLine();
			} catch (Exception e) {
				System.out.println(e);
			}
			return "";
		}

		/*
		 * returns InputInteger
		 */
		public static int inputInteger() {
			try {
				return scanner.nextInt();
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}

		/*
		 * returns InputDouble
		 */
		public static double inputDouble() {
			try {
				return scanner.nextDouble();
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0.0;
		}

		/*
		 * returns InputBoolean
		 */
		public static boolean inputBoolean() {
			try {
				return scanner.nextBoolean();
			} catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}

		/* Anagram Detecting Program */
		public static boolean isAnagram(String stringOne, String stringTwo) {
			char characterOne[] = stringOne.toCharArray();// String converted into character Array
			char characterTwo[] = stringTwo.toCharArray();

			int lengthOne = stringOne.length();
			int lengthTwo = stringTwo.length();

			if (lengthOne != lengthTwo)
				return false;

			Arrays.sort(characterOne);
			Arrays.sort(characterTwo);
			for (int i = 0; i < lengthOne; i++) {
				if (characterOne[i] != characterTwo[i])
					return false;
			}
			return true;
		}

		/* Scanner */
		public static Object scanner() {
			Scanner scanner = new Scanner(System.in);
			return scanner;
		}

		/* Prime number */
		public static void primeNumber() {

			System.out.println("Prime Number");
			for (int i = 1; i < 1000; i++) {
				int count = 0;
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						count++;
						break;
					}
				}
				if (count == 0) {
					System.out.println(i);
				}
			}
		}

		/* Print Prime number those are anagram and Palindram */
		public static void primeAnagram() {
			for (int i = 1; i < 1000; i++) {
				for (int j = i + 1; j < 999; j++) {
					int n[] = new int[i];
					int m[] = new int[j];
					if (n.length != m.length) {
						break;
					}
					Arrays.sort(n);
					Arrays.sort(m);
					for (int k = 0; k < n.length; k++) {
						if (n[k] == m[k]) {
							System.out.println(n[k]);
						}
					}
				}
			}
		}

		/* Palindram Anagram */
		public static void palindramAnagram() {
			for (int i = 1; i < 1000; i++) {

			}
		}

		/* Binary Search */
		public static int binarySearch(String stringOne[], String word) {
			int left = 0, right = stringOne.length - 1;
			while (left <= right) {
				int middle = left + (right - left) / 2;

				int result = word.compareTo(stringOne[middle]);

				if (result == 0)
					return middle;
				if (result > 0)
					left = middle + 1;
				else
					right = middle - 1;
			}
			return -1;
		}

		/* Insertion Sort */
		public static void insertionSort(String string[]) {
			String temp = "";
			for (int i = 0; i < string.length; i++) {
				for (int j = i + 1; j < string.length; j++) {
					if (string[i].compareToIgnoreCase(string[j]) > 0) {
						temp = string[i];
						string[i] = string[j];
						string[j] = temp;
					}
				}
			}
			for (int i = 0; i < string.length; i++) {
				System.out.println(string[i]);
			}
		}

		/* Bubble Sort */
		public static void bubbleSort(int array[]) {
			for (int i = 0; i < array.length - 1; i++) {
				for (int j = 0; j < array.length - i - 1; j++) {
					if (array[j] > array[j + 1]) {
						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				}
			}
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
		}

		/* Merge Sort */
		public static void sort(String str[], int left, int right) {
			if (left < right) {
				int middle = (left + right) / 2;

				sort(str, left, middle);
				sort(str, middle + 1, right);

				merge(str, left, middle, right);
			}
		}

		public static void merge(String[] string, int left, int middle, int right) {
			int numberOne = middle - left + 1;
			int numberTwo = right - middle;

			String left1[] = new String[numberOne];
			String right1[] = new String[numberTwo];

			for (int i = 0; i < numberOne; i++)
				left1[i] = string[left + i];
			for (int i = 0; i < numberTwo; i++)
				right1[i] = string[middle + 1 + i];

			int i = 0, j = 0;
			int k = left;
			while (i < numberOne && j < numberTwo) {
				if (left1[i].compareTo(right1[j]) < 0) {
					string[k] = left1[i];
					i++;
				} else {
					string[k] = right1[j];
					j++;
				}
				k++;
			}
			while (i < numberOne) {
				string[k] = left1[i];
				i++;
				k++;
			}
			while (j < numberTwo) {
				string[k] = right1[j];
				j++;
				k++;
			}
		}

		public static void printElement(String str[]) {
			for (int i = 0; i < str.length; i++) {
				System.out.println(str[i]);
			}
		}

		/* Montly Payment Program */
		public static void montlyPayment(double principle, int year, int rate) {
			int n = 12 * year;
			int r = rate / 12 * 100;
			double payment = principle * r / 1 - ((1 + r) ^ (-n));
			System.out.println("Payment " + payment);
		}

		/* Serching sorting */
		@SuppressWarnings("unused")
		public static void searchingSorting(char characterStart) {
			LocalTime time = java.time.LocalTime.now();
			if (characterStart == 's' || characterStart == 'S') {

				int hour = time.getHour();
				int minute = time.getMinute();
				int second = time.getSecond();
				int nano = time.getNano();

			}
		}

		/* Guess Number */
		public static int guessNumber(int number) {
			if (number <= 100) {
				int low = 0, high = 100, mid;
				while (low != high) {
					mid = (low + high) / 2;
					System.out.println("Enter 1 if number between " + low + "-" + mid + " Enter 2 if number between "
							+ (mid + 1) + "-" + high);
					int c = ((Scanner) scanner()).nextInt();
					if (c == 1)
						high = mid;
					else
						low = mid + 1;
				}
				return low;
			} else {
				return 0;
			}
		}

		/* Decimal to Binary */
		public static void toBinary(int number) {
			String s = "";
			@SuppressWarnings("unused")
			int count = 0;
			while (number != 0) {
				int a = number % 2;
				if (a == 1) {
					count++;
				}
				s = a + "" + s;
				number = number / 2;
			}
			System.out.println(s);
		}

		/* count Digit */
		public static int countDigit(int number) {
			int count = 0;
			while (number != 0) {
				count++;
				number = number / 10;
			}
			return count;
		}

		/*
		 *  Day of the week 
		 */
		public static void dayOfWeek(int month, int date, int year) {
			int day = 0;
			for (int i = 1; i <= month; i++) {
				int year1 = year - (14 - month) / 12;
				int x = year1 + year1 / 4 - year1 / 100 + year1 / 400;
				int month1 = month + 12 * ((14 - month) / 12) - 2;
				day = (date + x + 31 * month1 / 12) % 7;
			}

			System.out.println(day);
		}

		/* swap Binary */
		public static int swapNibble(int number) {
			/*
			 * String s=""; int count=0,count1=0; while(number!=0) { int a=number%2;
			 * if(a==1) { count++; } s=a+""+s; number=number/2; } int
			 * s1=Integer.parseInt(s); int temp=countDigit(s1); if(temp==8) { while(s1!=0) {
			 * count1++; s1=s1/10; if(count1==4) { int temp1=s1; System.out.println(temp); }
			 * } }
			 */

			return ((number & 0x0F) << 4 | (number & 0xF0) >> 4);

		}
}
