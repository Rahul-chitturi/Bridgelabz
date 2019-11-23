package com.bridgelabz.datastrure;

import com.bridgelabz.datastructure.base.Queue;
import com.bridgelabz.utility.Utility;

public class PalindromeChecker {

	public static void main(String[] args) {
		Queue<Character> q = new Queue<Character>();
		
		System.out.println("Palindrome Checker");
		System.out.println("eneter the word ");
		String word =  Utility.ScanString();
		char arr[] = word.toCharArray();
		for(char ha : arr) {
		 q.addFront(ha);  
		}
       String str = "";
       for(int i=0;i<arr.length; i++) {
    	   str = str + q.removeFront(); 
       }
       System.out.println(str);
       if(word.equals(str)) {
    	   System.out.println("palindrome");
       }else {
    	   System.out.println("not a palidrome");
       }
		
	}

}
