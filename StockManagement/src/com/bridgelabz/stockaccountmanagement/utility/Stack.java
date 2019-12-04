package com.bridgelabz.stockaccountmanagement.utility;

public class Stack<T> {
MyLinkedList<T> myLinkedList;
	
	public Stack(){
		myLinkedList = new MyLinkedList<T>();
	}
	
	public void push(T data){
		myLinkedList.add(data);
	}
	
	public T pop(){
		return myLinkedList.pop();
	}
	
	public T peek(){
		T temp = myLinkedList.pop();
		myLinkedList.add(temp);
		return temp;
	}
	
	public boolean isEmpty(){
		return myLinkedList.isEmpty();
	}
	
	public int size(){
		return myLinkedList.size();
	}
}
