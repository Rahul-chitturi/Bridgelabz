package com.bridgelabz.designpattern.behavioral.mediatorpattern;

public class UserImpl extends User{

	public UserImpl(ChatMediator med, String name) {
		super(med, name);
 
	}

	@Override
	public void send(String msg) {
		
 
		System.out.println(this.name+" sending message : "+msg);
		mediator.sendMessage(msg, this);
		
	}

	@Override
	public void recive(String msg) {
	
		System.out.println("the recived message is : "+msg);
		
	}

}