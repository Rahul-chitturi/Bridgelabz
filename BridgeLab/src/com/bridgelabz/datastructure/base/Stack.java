package com.bridgelabz.datastructure.base;
/******************************************************************************
 * @purpose: program to create a stack of abstract data type
 * @author :RAHUL CHITTURI
 * @version:1.0
 * @since  :11-11-2019
 * @fileName :Stack.java
 ******************************************************************************/

public class Stack<T extends Comparable<T>>{
Node<T> head ;
/**
 * creates a empty stack
 */
public  Stack() {
	head = null;
}

/**
 *@purpose adds a new item to the top of the stack
 * @param item it needs a item
 * @return it returns nothing 
 */
public void push(T item) { 
	Node<T> node =new Node<T>(item);
	node.next =head;
	head = node;
}
/**
 * @purpose removes the top item from the stack 
 * @param  it needs nothing 
 * @return returns the top item
 */

public T pop() {
	T data = null;
	if(head == null) {
		System.out.println("stack is empty");
		return null;
	}
	else {
		data = (T) head.data;
		head = head.next;
		
	}
	return data;
}
	
/**
 * @purpose returns top item from stack but does not remove it.
 * @param it needs nothing 
 * @return it return top item from stack
 */
	

public  T peek() {
	T data =  null;
	if( head  ==  null) {
		System.out.println(" stack is empty");
		return null;
	}
	else {
		data = (T) head.data;
	}
	return data;
}

/**
 * @purpose tests to see wheather the stack is empty or not
 * @param it needs nothing 
 * @return it returns boolean value 
 */
public boolean isEmpty() {
return head==null?true:false;
}

/**
 * @purpose checks the size of the stack 
 * @param  it needs nothing
 * @return it returns INTEGER to  show size
 */
public int size() {
	Node<T> temp = head;
	int count= 0 ;
	while(temp.next!=null) {
		count++;
		temp = temp.next;
	}
	return count; 
}

/**
 * @purpose :to display the stack
 * @param   :it needs nothing
 * @return  :returns nothing (void)
 */

public void disp() {
	Node<T> temp = head;
	int count = 0  ; 
	while(temp!=null) {
		if(count%2 == 0 ) {
			System.out.println();
		}
		System.out.print(temp.data+" ");
		temp = temp.next;
		count++;
	}
}
}
