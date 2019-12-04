package com.bridgelabz.designpattern.creational.factory.model;

import com.bridgelabz.designpattern.creational.factory.service.Computerinfr;

public class Server implements Computerinfr {
	private String RAM;
	private String HDD;
	private String CPU;
	
	public Server(String hdd,String cpu,String ram)
	{
		this.HDD=hdd;
		this.RAM=ram;
		this.CPU=cpu;
	}

	@Override
	public String toString() {
		return "Server [RAM=" + RAM + ", HDD=" + HDD + ", CPU=" + CPU + "]";
	}

	public String getRAM() {
		return RAM;
	}

	public void setRAM(String rAM) {
		RAM = rAM;
	}

	public String getHDD() {
		return HDD;
	}

	public void setHDD(String hDD) {
		HDD = hDD;
	}

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}
	
}
