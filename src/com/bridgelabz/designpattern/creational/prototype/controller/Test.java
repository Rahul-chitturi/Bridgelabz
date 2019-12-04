package com.bridgelabz.designpattern.creational.prototype.controller;

import java.util.List;

import com.bridgelabz.designpattern.creational.prototype.serviceImplement.Employee;
import com.bridgelabz.designpattern.utility.Utility;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee employee = new Employee();
		employee.loadData();

		Employee empsNew = (Employee) employee.clone();
		Employee empsNew1 = (Employee) employee.clone();

		List<String> list = empsNew.getEmpList();

		
		System.out.println("Enter the choice"
				+ "\n1.add more"
				+ "\n2.remove"
				+ "\n3.exit");
		int ch=Utility.inputInteger();
		System.out.println("Enter the How many Data you have");
		int number = Utility.inputInteger();
		List<String> list1 = empsNew1.getEmpList();
		while (number != 0) {
			switch(ch)
			{
			case 1:
			System.out.println("Enter the Name of the Employee to add more ");
			list.add(Utility.inputString());
			number--;
			break;
			
			case 2:
			System.out.println("Enter the Name of the Employee to remove");
			list.remove(Utility.inputString());
			number--;
			break;
			
			case 3:
				ch=4;
				number=0;
				System.out.println("ThankYou!!!");
				break;
			default:
				System.out.println("Thank You!!!");
				break;
		}
		}
		System.out.println("emps List: " + employee.getEmpList());
		System.out.println("empsNew List: " + list);
		System.out.println("empsNew1 List: " + list1);
	}
}
