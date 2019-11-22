package com.bridgelabz.datastrure;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.datastructure.base.OrderdList;
import com.bridgelabz.utility.Utility;

public class OrderedListMain {
/**
 * main method to check the ordered list 
 * @param string arrya as  args
 * @throws and throws a  IOException
 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		OrderdList<Integer> nw = new OrderdList<Integer>();
		try {
		FileReader file = new FileReader("/home/rahul/git/BridgeLabZ/BridgeLab/src/OrderedFIle.txt");
		int i =0;
		String sb = "";
		while((i=file.read())!=-1) {
			sb = sb+(char) i ;
		}
		System.out.println(sb);
		String arrr[] = sb.split(" ");
		int arr[] = new int[arrr.length];
		 for(int j = 0 ; j<arrr.length;j++) {
			 arr[j] = Integer.parseInt(arrr[j]);
		 }
		 for(int k : arr) {
			nw.add(k);
		 }
		 System.out.println("Enter the number to search");
		int num = Utility.scanInt();
		if(nw.search(num)) {
			System.out.println("removed: "+ num);
		nw.remove(num);
		}else {
			System.out.println("added: "+ num);
			nw.add(num);
		}
		FileWriter filee  = new FileWriter("/home/rahul/git/BridgeLabZ/BridgeLab/src/OrderedFIle.txt");
		int size = nw.size();
		nw.disp();
		for(int o = 0 ; o<=size ; o++) {
			filee.write(nw.pop(0)+" ");
		}
		filee.close();
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}