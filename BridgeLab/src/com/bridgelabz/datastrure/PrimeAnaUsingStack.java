package com.bridgelabz.datastrure;
import com.bridgelabz.datastructure.base.Stack;
import com.bridgelabz.datastructure.base.Unordered;
import com.bridgelabz.utility.Utility;

public class PrimeAnaUsingStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
	Unordered<Integer> ar = new Unordered<Integer>();
			boolean b;
			for (int j = 2; j <= 1000; j++) {
				b = true;
				for (int i = 2; i < j / 2; i++) {
					if (j % i == 0) {
						b = false;
						break;
					}
				}
				if (b)
					ar.add(j);
			}
			for (int i = 0; i < ar.size(); i++) {
				for (int j = i + 1; j < ar.size(); j++) {
					if (Utility.anagram(ar.get(i), ar.get(j))) {
						stack.push(ar.get(i));
						stack.push(ar.get(j));
					}
				}
			}
			
			stack.disp();
		}

	}


