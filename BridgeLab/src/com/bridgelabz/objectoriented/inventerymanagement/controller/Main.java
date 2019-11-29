package com.bridgelabz.objectoriented.inventerymanagement.controller;


import com.bridgelabz.objectoriented.inventerymanagement.Service.service_implementation.InventryImplementation;
import com.bridgelabz.utility.Utility;

public class Main {

	public static void main(String[] args){

	
			InventryImplementation inventoryImplemantaion = new InventryImplementation();
			System.out.println("Inventory present\n");
			inventoryImplemantaion.displayInventory();
			long resultWeight = 0;
			double resultPrice = 0;

			int temp = 0;
			while (temp == 0) {
				System.out.println("\nTo perform operation ");
				System.out.println("Enter the Choice...\n");
				System.out.println("1.Add Inventory");
				System.out.println("2.Calculate Total Weight");
				System.out.println("3.Calculate Total Price");
				System.out.println("4.Remove Inventory");
				System.out.println("5.Save Inventory");
				System.out.println("6.Display Inventory");
				System.out.println("7.Exit");

				int choice = Utility.inputInteger();
				boolean result = Utility.checkChoice(choice);
				if (result == false) {
					System.out.println("Invalied choice");
					break;
				}


				switch (choice) {
				case 1:
					inventoryImplemantaion.addInventory();
					break;

				case 2:
					resultWeight = inventoryImplemantaion.totalWeight();
					System.out.println("Total weight of an inventory is : " + resultWeight);
					break;

				case 3:
					resultPrice = inventoryImplemantaion.totalPrice();
					System.out.println("Total Price of an inventory is : " + resultPrice);
					break;

				case 4:
					inventoryImplemantaion.removeInventory();
					break;

				case 5:
					InventryImplementation.save();
					break;

				case 6:
					inventoryImplemantaion.displayInventory();
					break;
				case 7:
					System.out.println("\nInventory Close...!!! Thank You ");
					temp = 1;
					break;

				default:
					System.err.println("\nInvalied choice");
					break;
				}
			}
		
	}
}
