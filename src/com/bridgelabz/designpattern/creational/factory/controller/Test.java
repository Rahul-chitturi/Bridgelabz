package com.bridgelabz.designpattern.creational.factory.controller;

import com.bridgelabz.designpattern.creational.factory.repository.ComputerFactory;
import com.bridgelabz.designpattern.creational.factory.service.Computerinfr;
import com.bridgelabz.designpattern.utility.Utility;

public class Test {
	
	public static void main(String[] args) {
	System.out.println("Enter the type");
	String type=Utility.inputString();
	System.out.println("Enter hdd");
	String HDD=Utility.inputString();
	System.out.println("Enter cpu");
	String CPU=Utility.inputString();
	System.out.println("Enter ram");
	String RAM=Utility.inputString();
	Computerinfr string;
	
	if("Pc".equalsIgnoreCase(type))
	{
		string=ComputerFactory.createComputer(type, HDD, CPU, RAM);
		System.out.println(type+" "+HDD);
		System.out.println(string);
	}
	else if("Server".equalsIgnoreCase(type))
	{
		string=ComputerFactory.createComputer(type, HDD, CPU, RAM);
		System.out.println(string);
	}
	else
	{
		System.out.println("Invalied Type");
	}
	
}
}

