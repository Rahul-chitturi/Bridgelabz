package com.bridgelabz.designpattern.creational.prototype.serviceImplement;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.designpattern.utility.Utility;

public class Employee implements Cloneable {
	private List<String> employeeList;

	public Employee() {
		employeeList = new ArrayList<String>();
	}

	public Employee(List<String> list) {
		this.employeeList = list;
	}

	public void loadData() {
		System.out.println("Enter the How many Data you have");
		int number = Utility.inputInteger();
		while (number != 0) {
			System.out.println("Enter the Name of the Employee");
			employeeList.add(Utility.inputString());
			number--;
		}

	}

	public List<String> getEmpList() {
		return employeeList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<String>();
		for (String s : this.getEmpList()) {
			temp.add(s);
		}
		return new Employee(temp);
	}
}
