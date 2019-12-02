package com.bridgelabz.datastrure;
/********************************************************************************************
 * Purpose :Binary SearchTree
 * @author :Rahul C H
 * @version:1.0
 * @date   :21-11-2019
 * @Filename:BinarySearchtree.java
 ********************************************************************************************/
import com.bridgelabz.utility.Utility;

public class BinarySearchtree {

		public static void main(String[] args) {
	
			System.out.println("Enter the total number");
			double number=Utility.inputDouble();//taking user input
			
			while(number>0)
			{
				double totalNodes=Utility.inputDouble();//taking user input
				int totalTree=Utility.numberOfBinarySearchTree(totalNodes);//calling the method
				System.out.println(totalTree);
				number--;
			}
			//System.out.println("Invalied Character");//when condition false
		}
	}
