package com.bridgelabz.datastrure;

import java.util.ArrayList;

import com.bridgelabz.utility.Utility;

public class PrimeAnagram {

	public static void main(String[] args)  {
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
		for(int i = 0 ; i<10 ; i++) {
		for(int j = 0 ; j<100;j++) {
			if(prime[i][j]!=-1) {
			for(int k = j+1 ; k <100;k++ ) {
			if(prime[i][k]!=-1&& Utility.anagram(prime[i][j],prime[i][k])) {
				System.out.println(prime[i][j]+" "+ prime[i][k]);
			}
			}
			}
		}
	}
	
	}
	}


