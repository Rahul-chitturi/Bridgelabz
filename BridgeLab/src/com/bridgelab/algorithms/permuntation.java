package com.bridgelab.algorithms;
import java.util.*;
public class permuntation {
static	ArrayList<String> arl = new ArrayList<>();
static ArrayList<String> arr = new ArrayList<String>();
	public static void main(String[] args) {
	Scanner scan  = new Scanner(System.in);
 String name =  scan.nextLine();
 scan.close();
  printDistinctPermutn(name , "");
 System.out.println(arl);
 System.out.println(arr);
 if(arl.equals(arr)) {
	 System.out.println("Same");
 }else {
	 System.err.print("err");
 }
	}
	
	static String[] permutIteration(String s2) {
	
		for (int i = 0; i < s2.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				String s1 = s2;
			
				 arl.add(swap(s1, i, j));
			}
		}
		return arl.toArray(new String[arl.size()]);
	}

	static String swap(String s1, int i, int j) {

		char[] ch = s1.toCharArray();
		char temp;
		temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return new String(ch);
	}
	
	static void printDistinctPermutn(String str,  String ans) 
{ 

// If string is empty 
if (str.length() == 0) { 

// print ans 
	arr.add(ans);
System.out.print(ans + " "); 
return; 
} 


boolean alpha[] = new boolean[26]; 

for (int i = 0; i < str.length(); i++) { 

// ith character of str 
char ch = str.charAt(i); 

// Rest of the string after excluding  
// the ith character 
String ros = str.substring(0, i) +  
 str.substring(i + 1); 

// If the character has not been used  
// then recursive call will take place.  
// Otherwise, there will be no recursive 
// call 
if (alpha[ch - 'a'] == false) 
printDistinctPermutn(ros, ans + ch); 
alpha[ch - 'a'] = true; 
} 
} 


}
