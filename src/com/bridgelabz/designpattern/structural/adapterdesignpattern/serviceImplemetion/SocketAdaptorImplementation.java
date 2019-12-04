package com.bridgelabz.designpattern.structural.adapterdesignpattern.serviceImplemetion;

import com.bridgelabz.designpattern.structural.adapterdesignpattern.model.Socket;
import com.bridgelabz.designpattern.structural.adapterdesignpattern.model.Volt;
import com.bridgelabz.designpattern.structural.adapterdesignpattern.service.SocketAdapter;

public class SocketAdaptorImplementation extends Socket implements SocketAdapter{
	@Override
	public Volt get240Volts() {
		return getVolt();
	}

	@Override
	public Volt get120Volts() {
		Volt v = getVolt();
		return convertVolt(v, 10);
	}

	@Override
	public Volt get12Volts() {
		Volt v = getVolt();
		return convertVolt(v, 40);
	}

	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolt() / i);
	}
}
