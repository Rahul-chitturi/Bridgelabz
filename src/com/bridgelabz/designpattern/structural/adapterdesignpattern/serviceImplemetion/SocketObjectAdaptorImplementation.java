package com.bridgelabz.designpattern.structural.adapterdesignpattern.serviceImplemetion;

import com.bridgelabz.designpattern.structural.adapterdesignpattern.model.Socket;
import com.bridgelabz.designpattern.structural.adapterdesignpattern.model.Volt;
import com.bridgelabz.designpattern.structural.adapterdesignpattern.service.SocketAdapter;

public class SocketObjectAdaptorImplementation implements SocketAdapter {
	private Socket socket = new Socket();

	@Override
	public Volt get240Volts() {
		return socket.getVolt();
	}

	@Override
	public Volt get120Volts() {
		Volt v = socket.getVolt();
		return convertVolt(v, 10);
	}

	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolt() / i);
	}

	@Override
	public Volt get12Volts() {
		return null;
	}

}
