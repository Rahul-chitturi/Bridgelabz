package com.bridgelabz.designpattern.creational.singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {
	 public static void main(String[] args) {
	        Eagerinitialization instanceOne = Eagerinitialization.getInstance();
	        Eagerinitialization instanceTwo = null;
	        try {
	            Constructor[] constructors = Eagerinitialization.class.getDeclaredConstructors();
	            for (Constructor constructor : constructors) {
	                //Below code will destroy the singleton pattern
	                constructor.setAccessible(true);
	                instanceTwo = (Eagerinitialization) constructor.newInstance();
	                break;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.out.println(instanceOne.hashCode());
	        System.out.println(instanceTwo.hashCode());
	    }
}
