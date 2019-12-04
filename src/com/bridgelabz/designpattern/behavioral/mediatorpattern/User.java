package com.bridgelabz.designpattern.behavioral.mediatorpattern;

public abstract class User {

	protected ChatMediator mediator;
	protected String name;
	
	public User(ChatMediator med,String name)
	{
		this.mediator=med;
		this.name=name;
	}
	
	public abstract void send(String msg);  // to send the message
	
	public abstract void recive(String msg);	// to recive the message sent by sender
	
}