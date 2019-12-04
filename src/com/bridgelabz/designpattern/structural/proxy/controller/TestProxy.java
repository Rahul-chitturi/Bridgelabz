package com.bridgelabz.designpattern.structural.proxy.controller;

import com.bridgelabz.designpattern.structural.proxy.repository.CommandExcecutorProxy;
import com.bridgelabz.designpattern.structural.proxy.service.CommandExcecutor;
import com.bridgelabz.designpattern.utility.Utility;

public class TestProxy {
	public static void main(String[] args) {
		System.out.println("Enter your User Id");
		String userId = Utility.inputStringLine();
		System.out.println("Enter your password");
		String password = Utility.inputStringLine();

		CommandExcecutor execute = new CommandExcecutorProxy(userId, password);
		try {
			execute.runCommand("ls -ltr");
			execute.runCommand("rm proxy.txt");
		} catch (Exception e) {
			System.out.println("Exception Message");
		}
	}
}
