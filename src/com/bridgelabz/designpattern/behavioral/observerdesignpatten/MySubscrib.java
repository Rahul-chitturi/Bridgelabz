package com.bridgelabz.designpattern.behavioral.observerdesignpatten;

public class MySubscrib implements Observer {

	private String name;
	private Subject topic;

	public MySubscrib(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		String message = (String) topic.getUpdate(this);
		if (message == null)
			System.out.println("No new Message!!!");
		else
			System.out.println("Message " + message);
	}

	@Override
	public void setSubject(Subject subject) {
		this.topic = subject;
	}

}
