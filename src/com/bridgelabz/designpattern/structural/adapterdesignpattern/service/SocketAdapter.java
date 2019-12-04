package com.bridgelabz.designpattern.structural.adapterdesignpattern.service;

import com.bridgelabz.designpattern.structural.adapterdesignpattern.model.Volt;

public interface SocketAdapter {
		public Volt get240Volts();

		public Volt get120Volts();

		public Volt get12Volts();
	}

