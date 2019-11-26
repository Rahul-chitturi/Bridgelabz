package com.bridgelabz.datastrure;
/********************************************************************************************
 * Purpose :primeanagram using queue
 * @author :Rahul C H
 * @version:1.0
 * @date   :21-11-2019
 * @Filename:PrimeAnagramUsingQueue.java
 ********************************************************************************************/
import com.bridgelabz.datastructure.base.Queue;
import com.bridgelabz.datastructure.base.Unordered;
import com.bridgelabz.utility.Utility;

public class PrimeAnagraminQueue {

	public static void main(String[] args) {
		Queue<Integer> qu = new Queue<Integer>();
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
							qu.enqueue(ar.get(i));
							qu.enqueue(ar.get(j));
						}
					}
				}
				
				qu.dispPrime();
			}


	

}
