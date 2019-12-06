package com.bridgelabz.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
public static void main(String[] args) {
	
	Pattern p =Pattern.compile(".rs");
	Matcher m = p.matcher("ars");
	System.out.println(m.matches());
	System.out.println(Pattern.matches(".s", "as " ));
	
}
}
