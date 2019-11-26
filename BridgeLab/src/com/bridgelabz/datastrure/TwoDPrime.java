package com.bridgelabz.datastrure;

import com.bridgelabz.utility.Utility;
/********************************************************************************************
 * Purpose :storing the primie number in 2d array
 * @author :Rahul C H
 * @version:1.0
 * @date   :21-11-2019
 * @Filename:TwoDarray.java
 ********************************************************************************************/
public class TwoDPrime {

	public static void main(String[] args) {
		int array[][]=new int[10][100];
		int prime[][]=new int[10][100];
		int temp=1;
		for (int i = 0; i< 10; i++) {
			for (int j = 0; j < 100; j++) {
				array[i][j]=temp;
				temp++;
			}
		}
		
		for (int i = 0; i <10; i++) {
			for (int j = 0; j < 100; j++) {
				if(Utility.isPrime(array[i][j]))
				{
				prime[i][j]=array[i][j];
				}
				else
				{
					prime[i][j]=-1;
				}
			}
		}
	
		for (int i[] : prime) {
			
			for (int j : i) {
				if(j!=-1&& j!=1)
				{
					System.out.print(j+" ");
				}
			}
			System.out.println("\n");
		}
	
		
	}

}
