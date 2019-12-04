package com.bridgelabz.designpattern.structural.adapterdesignpattern.model;

public class Socket {
	public Volt getVolt() {
		return new Volt(120);
	}
}
