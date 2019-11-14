package com.bridgelab.algorithms;
import com.bridgelab.utility.Utility;;
/**
 * @author Rahul C H
 * @version 10.0
 * @since 11/11/2019
 */
public class Insertion {

	public static void main(String[] args) {
	int arr[]  =  {5,4,3,6,3,2,4};
	int sorted[] = Utility.insertionSort(arr );
	for(int k : sorted) {
		System.out.println(k);
	}
	}

}
