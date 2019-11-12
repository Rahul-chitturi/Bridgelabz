package algorithms;
import java.io.PrintWriter;
import java.util.*;
public class PrintPrime {

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner scan = new Scanner(System.in);
	   System.out.println("enter number in 0- 1000");
       int n =   scan.nextInt();
       for(int i = 2 ; i<= n ; i++) {
    	   if(isPrime(i)) {
    	   pw.print(i+" ");
    	   pw.flush();
    	   }
       }
	}
	/*
	 * 
	 */
static boolean isPrime(int n ) {
	 for(int i  = 2 ; i<=n/2 ; i++ ) {
    	 if(n%i == 0 ) {
    		 return  false;
    	 }
       }
       return  true;
}
}
