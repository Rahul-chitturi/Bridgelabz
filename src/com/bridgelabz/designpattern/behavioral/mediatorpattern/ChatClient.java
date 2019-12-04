package com.bridgelabz.designpattern.behavioral.mediatorpattern;

public class ChatClient {
	public static void main(String[] args) {
		ChatMediator mediator=new ChatMediatorImpl();
		
		User user1=new UserImpl(mediator, "raj");
		User user2=new UserImpl(mediator, "sanju");
		User user3=new UserImpl(mediator, "manju");
		User user4=new UserImpl(mediator, "karna");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		
		user1.send("hi all");
		
		
	}
}