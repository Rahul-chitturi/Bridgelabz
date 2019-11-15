package com.bridgelab.junit;
    /******************************************************************************
	 * Purpose:  To Convert the temperature from celcius to fahreinheit and vice-versa
     *
     * @author  :RAHUL CHITTURI
     * @version :10.0
     * @since   :11-11-2019  
	 ******************************************************************************/
import com.bridgelab.utility.Utility;
public class TempratureConversion {
	public static void main(String[] args) {
		try {
			System.out.println("enter temp in c or f");
			int tem = Utility.scan.nextInt();
			char t = Utility.scan.next().charAt(0);
	
			if (t != 'f' && t != 'F' && t != 'c' && t != 'C') {
				System.out.println("enter correct input");
				main(args);
				return;
			}
			tem = Utility.temperaturConversion(tem, t);
			System.out.println("coverted temp is " + tem);
			Utility.scan.close();
		} catch (Exception e) {
			System.out.println("temperature in format 4545 c");
		}

	}
}
