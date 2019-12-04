package com.bridgelabz.designpattern.structural.proxy.repository;

import com.bridgelabz.designpattern.structural.proxy.service.CommandExcecutor;
import com.bridgelabz.designpattern.structural.proxy.service.serviceimplementation.CommandExcecutorImplementation;
import com.bridgelabz.designpattern.utility.Utility;

public class CommandExcecutorProxy implements CommandExcecutor {
	private boolean admin;
	private CommandExcecutor excecute;

	public CommandExcecutorProxy(String user, String password) {

		System.out.println("Enter the id");
		String id = Utility.inputStringLine();
		System.out.println("Enter the pass");
		String pass = Utility.inputStringLine();

		if (id.equalsIgnoreCase(user) && pass.equalsIgnoreCase(password))
			admin = true;
		excecute = new CommandExcecutorImplementation();
	}

	public void runCommand(String cmd) throws Exception {
		if (admin) {
			excecute.runCommand(cmd);
		} else {
			if (cmd.trim().startsWith("rm")) {
				throw new Exception("rm command not there");
			} else {
				excecute.runCommand(cmd);
			}
		}
	}
}
