package com.bridgelabz.designpattern.creational.prototype.model;

public class Employe {
	private String name;
	private String newName;

	@Override
	public String toString() {
		return "Employee [name=" + name + ", newName=" + newName + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}
}
