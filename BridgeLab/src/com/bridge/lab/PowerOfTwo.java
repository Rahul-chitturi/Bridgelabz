package com.bridge.lab;

public class PowerOfTwo {

	public static void main(String[] args) {
System.out.println("ENTER A NUMBER WITH IN 31");
int n=0;       
// read in one command-line argument
int a= 0;
        n = Integer.parseInt(args[0]);
  if(n>30) {
	  System.err.println("enter value with in 31 run again with valid input");
  }else {

        int i = 0;                // count from 0 to N
        int POWER = 1;       // the ith power of two

        // repeat until i equals n
        while (i <= n) {
            System.out.println(i + " " + POWER);   // print out the power of two
            POWER = 2 * POWER;                // double to get the next one
            i = i + 1;
        }

  }

	}

}
