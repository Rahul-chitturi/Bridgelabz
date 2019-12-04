package com.bridgelabz.designpattern.behavioral.mediatorpattern;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator{
	
	
	private List<User> users;
	
	public void CharMediatorImpl() 
	{

		this.users=new ArrayList<>();
	}
	@Override
	public void sendMessage(String msg, User user) {
		
		for (User u : this.users) {
			
			if(u!=user)
			{
				u.recive(msg);
			}
		}
		
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

}