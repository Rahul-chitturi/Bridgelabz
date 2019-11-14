package  com.bridgelab.junit;
/******************************************************************************
	 * Purpose:  Program to find the square root of a given nos
     *
 * @author RAHUL CHITTURI
 * @version 10.0
 * @since 11-11-2019
	 *
	 ******************************************************************************/
import java.util.Scanner;

import com.bridgelab.utility.Utility;;
public class SquareRoot {
	
/**
 * Main method to test the class
 * @param args
 * @throws Exception if input is not integer
 */
	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("enter no to find square root");
			double c = s.nextDouble();
			System.out.println("square root is " + Utility.sqrt(c));
			s.close();
		} catch (Exception e) {
			System.out.println("inter integer value "+e.getMessage());
		}

	}
}
