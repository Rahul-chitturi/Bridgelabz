package com.bridgelabz.datastructure.base;

/******************************************************************************
 * @purpose :program to create a Queue and Deque
 * @author :RAHUL CHITTURI
 * @version :1.0
 * @since :21-11-2019
 * @fileName :Queue.java
 ******************************************************************************/

public class Queue<T extends Comparable<T>> {
	Node<T> head;
	Node<T> tail;

	/**
	 * @purpose creates a empty Deque
	 * @param it needs nothing
	 */
	public void Deque() {
		head = null;
	}

	/**
	 * @purpose creates a empty queue
	 * @param it needs nothing
	 */
	public Queue() {
		head = null;
	}

	/**
	 * @purpose :adds a new item in Queue
	 * @param   :item it needs a item
	 * @return  :it returns nothing
	 */
	public void enqueue(T item) {
		Node<T> node = new Node<T>(item);
		if (head == null) {
			head = node;
			head.next = null;
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			node.next = null;
		}

	}

	/**
	 * @purpose :to display the queue or deque
	 * @param :it needs nothing
	 * @return :returns nothing (void)
	 */

	public void disp() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * @purpose :to display the queue
	 * @param :it needs nothing
	 * @return :returns nothing (void)
	 */

	public void dispPrime() {
		int count = 0;
		Node<T> temp = head;
		while (temp != null) {
			if (count % 2 == 0) {
				System.out.println();
			}
			System.out.print(temp.data + " ");
			temp = temp.next;
			count++;

		}
	}

	/**
	 * @purpose removes the top item from the queue
	 * @param it needs nothing
	 * @return returns the first item
	 */

	public T dequeue() {
		Node<T> temp = head;
		if (head == null) {
			System.out.println("queue is empty");
			return null;
		}

		head = head.next;
		return (T) temp.data;

	}

	/**
	 * @purpose test to see wheather the queue is empty or not
	 * @param it needs nothing
	 * @return it returns boolean value
	 */
	public boolean isEmpty() {
		return head == null ? true : false;
	}

	/**
	 * @purpose adds a new item at front in DeQue
	 * @param item it needs a item
	 * @return it returns nothing
	 */
	public void addFront(T item) {
		Node<T> node = new Node<T>(item);
		node.next = head;
		head = node;

	}

	/**
	 * @purpose adds a new item at rear in DeQue
	 * @param item it needs a item
	 * @return it returns nothing
	 */
	public void addRear(T item) {
		enqueue(item);
	}

	/**
	 * @purpose removes the top item from the queue
	 * @param it needs nothing
	 * @return returns the first item
	 */

	public T removeFront() {
		T data = dequeue();
		return data;
	}

	/**
	 * @purpose removes the rear item from the queue
	 * @param it needs nothing
	 * @return returns the rear item
	 */
	public T removeRear() {
		T data = null;
		Node<T> temp = head;
		if (head.next == null) {
			data = (T) head.data;
			head = null;
			return data;
		}
		while (temp.next.next != null) {
			temp = temp.next;
		}

		data = (T) temp.next.data;
		temp.next = null;
		return data;
	}

	/**
	 * @purpose checks the size of the queue
	 * @param it needs nothing
	 * @return it returns INTEGER to show size
	 */
	public int size() {
		Node<T> temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
}
