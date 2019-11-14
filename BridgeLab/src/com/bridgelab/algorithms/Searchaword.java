package com.bridgelab.algorithms;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bridgelab.utility.Utility;
public class Searchaword {

	public static String[] fileRead(File f) throws IOException {
		String word = "";
		ArrayList<String> s1 = new ArrayList<String>();
		FileReader fr = new FileReader(f);
		int c;
		while ((c = fr.read()) != -1) {
			if (c == 32) {
				s1.add(word);
				word = "";
			} else {
				word = word + String.valueOf((char) c);
			}
		}
		fr.close();
		String[] s = new String[s1.size()];
		s1.toArray(s);
		return s;
	}
	
	public static void main(String[] args)  {
		try {
		File file = new File("C:\\Users\\Rahul C H\\git\\BridgeLab\\BridgeLab\\src\\search.txt");
		String str[] = fileRead(file);
		for(String s: str) {
			System.out.println(s);
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("enter word to search");
		String s = scan.nextLine();
		int n  = Utility.binary(str, s);
		if(n>0) {
			System.out.println("found");
		}else {
			System.out.println("not found");
		}
		scan.close();
	}catch(Exception e ) {
		System.out.println(e);
	}
	}

}
