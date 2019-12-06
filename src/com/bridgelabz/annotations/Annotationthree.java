package com.bridgelabz.designpattern.annotations;

class base{ 
	base(){
		System.out.println("parent constructer");
	}
	public  void sub() {
		System.out.println("inside");
	}
}
public class Annotationthree extends base {

	@Override 
	public void sub() {
		System.out.println("child ");
		super.sub();
	}
	
	public static void main(String[] args) {
		Annotationthree nd = new Annotationthree();
		nd.sub();
	}
}
