package com.bridgelabz.designpattern.annotations;

import java.lang.annotation.Documented;

@interface TestTwo {
	String name();

	int num();
}

@Documented
@interface TestAnnotation {
	String Developer() default "Rahul";

	String Expirydate();
} // will be retained at runtime

public class CostumAnnotation {

	@TestAnnotation(Developer = "rahul", Expirydate = "12-09-2020")
	public static void add() {
		System.out.println("Test method 1");
	}

	@TestAnnotation(Developer = "Anil", Expirydate = "01-10-2021")
	static void fun2() {
		System.out.println("Test method 2");
	}

	@TestTwo(name = "rahul", num = 123)

	static void fun3() {
		System.out.println("Test method 3");
	}

	public static void main(String args[]) {
		add();
		fun2();
		fun3();
		System.out.println("Hello");
	}
}
