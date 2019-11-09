package com.bridge.lab;

public class harmonic {

	public static void main(String[] args) {
	float sum = 0;
	
	int n  = Integer.parseInt(args[0]);
		for(int i = 1 ;  i<=n ; i++) {
			sum  = sum +(float )1/i;
			System.out.println(sum);
			
		}

	}

}
