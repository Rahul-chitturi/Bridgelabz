package com.bridgelabz.designpattern.structural.adapterdesignpattern.controller;

import com.bridgelabz.designpattern.structural.adapterdesignpattern.model.Volt;
import com.bridgelabz.designpattern.structural.adapterdesignpattern.service.SocketAdapter;
import com.bridgelabz.designpattern.structural.adapterdesignpattern.serviceImplemetion.SocketAdaptorImplementation;

public class Test {
	public static void main(String[] args) {

		testClassAdapter();
		testObjectAdapter();
	}

	private static void testObjectAdapter() {
		SocketAdapter sockAdapter = new SocketAdaptorImplementation();
		Volt v12 = getVolt(sockAdapter, 12);
		Volt v120 = getVolt(sockAdapter, 120);
		Volt v240 = getVolt(sockAdapter, 240);
		System.out.println("v12 volts using Class Adapter=" + v12.getVolt());
		System.out.println("v120 volts using Class Adapter=" + v120.getVolt());
		System.out.println("v240 volts using Class Adapter=" + v240.getVolt());
	}

	private static void testClassAdapter() {
		SocketAdapter sockAdapter = new SocketAdaptorImplementation();
		Volt v12 = getVolt(sockAdapter, 12);
		Volt v120 = getVolt(sockAdapter, 120);
		Volt v240 = getVolt(sockAdapter, 240);
		System.out.println("v12 volts using Class Adapter=" + v12.getVolt());
		System.out.println("v120 volts using Class Adapter=" + v120.getVolt());
		System.out.println("v240 volts using Class Adapter=" + v240.getVolt());
	}

	private static Volt getVolt(SocketAdapter sockAdapter, int i) {
		switch (i) {
		case 12:
			return sockAdapter.get12Volts();
		case 120:
			return sockAdapter.get120Volts();
		case 240:
			return sockAdapter.get240Volts();

		default:
			return sockAdapter.get120Volts();
		}
	}
}
