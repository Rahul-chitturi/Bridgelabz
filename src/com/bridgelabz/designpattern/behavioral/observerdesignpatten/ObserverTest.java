package com.bridgelabz.designpattern.behavioral.observerdesignpatten;

public class ObserverTest {
	public static void main(String[] args) {
		Observer obj1=new MySubscrib("Obj1");
		Observer obj2=new MySubscrib("Obj2");
		Observer obj3=new MySubscrib("Obj3");
		
		MySubject subject=new MySubject();
		
		subject.register(obj1);
		subject.register(obj2);
		subject.register(obj3);
//		subject.register(null);
		
		obj1.setSubject(subject);
		obj2.setSubject(subject);
		obj3.setSubject(subject);
		
		obj1.update();
		subject.postMessage("fgsfg");
		subject.postMessage("This is new message!!!");
	}
}
