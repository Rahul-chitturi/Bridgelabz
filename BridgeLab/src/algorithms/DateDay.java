package algorithms;
/******************************************************************************
	 * 
	 * Purpose:  to read a date from user and give the on that day as out put
     *
 * @author RAHUL CHITTURI
 * @version 10.0
 * @since 11-11-2019
	 *
	 ******************************************************************************/

import java.util.Scanner;
import com.bridge.lab.Utility;;
public class DateDay {
	
	
 /**
  *    main function to test the class
  */
	public static void main(String[] args) {
		int d, m, y;
		Scanner s = new Scanner(System.in);
		System.out.println("enter date in day month year");
		d = s.nextInt();
		m = s.nextInt();
		y = s.nextInt();
		System.out.println("day is "+Utility.dayOfWeek(d, m, y));
		s.close();
		
	}
}
