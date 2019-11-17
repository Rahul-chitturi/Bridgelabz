/********************************************************************************************
 * Purpose   :To  bubblesort the given array
 * @author   :Rahul C H
 * @version  :1.0
 * @date     :14-11-2019
 * @Filename :Bubblesort.java
 ********************************************************************************************/
package com.bridgelab.algorithms;

import com.bridgelab.utility.Utility;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[]  =  {1,5,4,6,3,1};
        int sorted[] = Utility.bubbleSort(arr);
        
        for(int i : sorted) {
        	System.out.print(i+"  ");
        }
	}

}
