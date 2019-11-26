package com.bridgelabz.datastrure;
/********************************************************************************************
 * Purpose :banking cah counter
 * @author :Rahul C H
 * @version:1.0
 * @date   :21-11-2019
 * @Filename:BankingCash.java
 ********************************************************************************************/
import com.bridgelabz.datastructure.base.Queue;
import com.bridgelabz.utility.Utility;

public class BankingCash {

	public static void main(String[] args) {
		
		System.out.println("Enter number of persons");
      int person = Utility.scanInt();		
		int cash=100000;
		Queue<Integer> queue=new Queue<Integer>();
		for (int i =1; i <=person; i++) {
			queue.enqueue(i);
		}

		while(person!=0)
		{
			System.out.println("Cash present "+cash);
			int count=0,option=0;

			while(count==0)
			{
				System.out.println("\nEnter option \n1.Withdrawal\n2.Deposit");
				option=Utility.inputInteger();
				if(option==1)
				{
					count+=1;
				}
				else if(option==2) {
					count+=2;
				}
				else {
					System.err.println("Invalied Option");
				}
			}

			if(count==1)
			{
				int amount1=0;
				int countWithdrawal=0;
				while(countWithdrawal==0)
				{
					System.out.println("Enter the amount to be Withdrawal:");
					amount1=Utility.inputInteger();

					if(amount1>cash)
						System.err.println("Sorry, you Enter wrong amount\n");	
					else
						cash=cash-amount1;
					countWithdrawal++;
				}
				queue.dequeue();
			}
			else if(option==2)
			{
				int amount2=0;
				int countdeposit=0;
				while(countdeposit==0)
				{
					System.out.println("Enter the Deposited amount:");
					amount2=Utility.inputInteger();
					countdeposit++;
					if(amount2<0)
						System.err.println("Your enter amount is not valied\n");
					else
						cash=cash+amount2;
				}
				queue.dequeue();
			}
			person--;
		}
		System.out.println("remaing :" + cash);

	}

}
