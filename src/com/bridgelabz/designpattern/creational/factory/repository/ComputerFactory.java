package com.bridgelabz.designpattern.creational.factory.repository;

import com.bridgelabz.designpattern.creational.factory.model.Pc;
import com.bridgelabz.designpattern.creational.factory.model.Server;
import com.bridgelabz.designpattern.creational.factory.service.Computerinfr;

public class ComputerFactory {
	

	public static Computerinfr createComputer(String type, String hDD, String cPU, String rAM) {

		if ("Pc".equalsIgnoreCase(type)) {
			return new Pc(hDD,cPU,rAM);
		}
		else if("Server".equalsIgnoreCase(type))
		{
			return new Server(hDD,cPU,rAM);
		}// TODO Auto-generated method stub
		return null;
	}
}
