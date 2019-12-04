package com.bridgelabz.designpattern.creational.factory.model;

import com.bridgelabz.designpattern.creational.factory.service.Computerinfr;

public class Pc implements Computerinfr {
	private String RAM;
	private String HDD;
	private String CPU;

	public Pc(String hdd,String cpu,String ram)
	{
		this.HDD=hdd;
		this.RAM=ram;
		this.CPU=cpu;
	}
	
	public String getRAM() {
		return RAM;
	}


	public String getHDD() {
		return HDD;
	}


	public String getCPU() {
		return CPU;
	}


	@Override
	public String toString() {
		return "Pc [RAM=" + RAM + ", HDD=" + HDD + ", CPU=" + CPU + "]";
	}
}
