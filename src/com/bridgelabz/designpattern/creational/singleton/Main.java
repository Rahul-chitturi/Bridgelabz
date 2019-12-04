package com.bridgelabz.designpattern.creational.singleton;

public class Main {

	public static void main(String[] args) {
		System.out.println(" Eager initialization hashcode:" +Eagerinitialization.getInstance().hashCode());
		System.out.println(" Static block initialization hashcode:" +Staticblockinitialization.getInstance().hashCode());
		System.out.println(" Lazy Initialization hashcode:" +LazyInitializedSingleton.getInstance().hashCode());
		System.out.println(" Thread Safe Singleton hashcode:" +ThreadSafeSingleton.getInstance().hashCode());		
		System.out.println(" Bill Pugh Singleton Implementation hashcode:" +BillPughSingleton.getInstance().hashCode());
		System.out.println(" Serialization and Singleton hashcode:" +SerializedSingleton.getInstance().hashCode());
	
	}
}


