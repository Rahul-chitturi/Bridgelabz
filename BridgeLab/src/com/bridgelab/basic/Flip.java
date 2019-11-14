package com.bridgelab.basic;
import java.util.Scanner;
public class Flip {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
    System.out.println("enter postive integer");
	int n = scan.nextInt();
	scan.close();
	int HEAD = 0  ;
    while(n<0) {
    	System.out.println("error enetr positive");
    	n= scan.nextInt();
    }
    for(int i = 0 ; i< n   ; i++ ) {
    double RAN  =  Math.random();
    if(RAN<0.5) {
    HEAD++;
    }
    }
    System.out.println("HEADS:"+(100/n)*HEAD);
    System.out.println("TAILS:"+(100 - ((100/n)*HEAD)));
    }
}
