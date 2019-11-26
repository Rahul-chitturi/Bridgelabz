package com.bridgelabz.datastructure.base;
/********************************************************************************************
 * Purpose :Unordered list reusable code with many methods
 * 
 * @author  :Rahul C H
 * @version :1.0
 * @date    :21-11-2019
 * @Filename:Node.java
 ********************************************************************************************/
public class Node<T> {

	public Node<T> head;
	private Node<T> front;
	private Node<T> rear;
	public Node<T> next;
	public T data;

	/**
	 * @purpose : it will store the data and make next = null
	 * @param   : data
	 */
	public Node(T data) {
		super();
		this.data = data;
		this.next = null;
	}

	
	public Node<T> getFront() {
		return front;
	}

	public void setFront(Node<T> front) {
		this.front = front;
	}

	public Node<T> getRear() {
		return rear;
	}

	public void setRear(Node<T> rear) {
		this.rear = rear;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
