package com.bridgelabz.annotations;

public class AnnotationOne {
	@Deprecated
	public static void add() {
		System.out.println("added");
	}
public static void main(String[] args) {
	AnnotationOne.add();
}
}
