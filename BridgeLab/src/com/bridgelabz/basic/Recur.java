package com.bridgelabz.basic;

import java.util.*;

public class Recur {

//	public static void print(int a) {
//		System.out.println(a);
//		if(a>99) {
//			return; 
//		}
//		 print(a+1);
//	}
//	
//	public static void main(String[] args) {
//	Recur.print(0);
//	}
	public static void main(String[] args) {
		String str = "mam";
//		for(int i =1 ; i<=str.length();i++) {
//			System.out.println(str.substring(0, i));
//		}
//dt		String s="";
		char ch[] = str.toCharArray();
//		for(char  r : ch) {
//			s=s+r;
//			System.out.println(s);
//		}

		Stack<Character> dt = new Stack<Character>();
		for (int i = ch.length - 1; i >= 0; i--) {
			dt.push(ch[i]);
		}
		String s = "";
		while (!dt.isEmpty()) {
			s = s + dt.pop();
		}
		System.out.println(s);
	}

}
