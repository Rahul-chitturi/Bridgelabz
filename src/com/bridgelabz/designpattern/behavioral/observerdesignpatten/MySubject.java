package com.bridgelabz.designpattern.behavioral.observerdesignpatten;

import java.util.ArrayList;
import java.util.List;

public class MySubject implements Subject {

	private List<Observer> observers;
	private String message;
	private boolean change;
	private final Object object = new Object();

	public MySubject() {
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer obj) {
		if (obj == null) {
			throw new NullPointerException("Null Pointer Exception");
		}
		synchronized (object) {
			if (!observers.contains(obj)) {
				observers.add(obj);
			}
		}
	}

	@Override
	public void deregister(Observer obj) {
		synchronized (object) {
			observers.remove(obj);
		}
	}

	@Override
	public void notifyObserver() {
		List<Observer> observerLocal = null;
		synchronized (object) {
			if (!change)
				return;
			observerLocal = new ArrayList<>(this.observers);
			this.change = false;
		}
		for (Observer observer : observerLocal) {
			observer.update();
		}
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}

	public void postMessage(String message) {
		System.out.println("Message " + message);
		this.message = message;
		this.change = true;
		notifyObserver();
	}

}
