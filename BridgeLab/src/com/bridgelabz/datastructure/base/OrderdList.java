package com.bridgelabz.datastructure.base;

/********************************************************************************************
 * Purpose :ordered list reusable code with many methods
 * 
 * @author :Rahul C H
 * @version :1.0
 * @date :21-11-2019
 * @Filename :Ordered.java
 ********************************************************************************************/
public class OrderdList<T extends Comparable<T>> {
	Node<T> head;
	Node<T> tail;

	/**
	 * creates a empty list
	 * 
	 * @param it need nothing
	 * @return it return nothing (void)
	 */
	public OrderdList() {
		head = null;
	}

	/**
	 * @Purpose adds a new item to the list
	 * @param it need the item
	 * @return it return nothing (void)
	 */

	public void add(T data) {
		Node<T> n = head;
		Node<T> temp = new Node<T>(data);
		if (head == null) {
			head = temp;
			head.next = tail;
			tail = head;
		} else if (data.compareTo((T) head.data) < 0) {
			temp.next = head;
			head = temp;
		} else {
			if (data.compareTo((T) tail.data) > 0) {
				tail.next = temp;
				tail = temp;
				return;
			}
			Node<T> prev = null;
			while (data.compareTo((T) n.data) > 0 && n.next != null) {
				prev = n;
				n = n.next;
			}
			prev.next = temp;
			temp.next = n;
		}
	}

	/**
	 * @purpose : removes the item form the list
	 * @param : it need the item
	 * @return : it will return nothing
	 */

	public void remove(T item) {
		Node<T> n = head;
		Node<T> prev = null;
		if (head.data.equals(item)) {
			head = head.next;
			return;
		} else if (tail.data.equals(item)) {
			while (!n.next.data.equals(tail.data)) {
				n = n.next;
			}
			n.next = null;
			tail = n;
			return;
		} else {
			while (!n.data.equals(item)) {
				prev = n;
				n = n.next;
			}
			n = n.next;
			prev.next = n;
			n = null;

		}
	}

	/**
	 * @purpose :to display the Ordered list
	 * @param :it needs nothing
	 * @return :returns nothing (void)
	 */

	public void disp() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;

		}
	}

	/**
	 * @purpose :it will search for the item and returns boolean
	 * @param :it needs item to search
	 * @return :it will return a boolean
	 */

	public boolean search(T item) {
		Node<T> n = head;
		if (head.data.equals(item)) {
			return true;
		}
		while (n != null) {
			if (n.data.equals(item)) {
				return true;
			}
			n = n.next;
		}
		return false;
	}

	/**
	 * @purpose : checks the size of the list
	 * @param : it needs nothing
	 * @return : it returns INTEGER to show size
	 */
	public int size() {
		if (head == null) {
			return 0;
		}
		Node<T> temp = head;
		int count = 0;
		while (temp.next != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	/**
	 * function to check if the list is empty or not
	 * 
	 * @return true if empty and false if not empty
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	/**
	 * Function to return the index of the item assuming it is present
	 * 
	 * @param item the item to return the index of
	 * @return the index of the passed item
	 */
	public int index(T item) {
		int index = 0;
		Node<T> n = head;
		while (!n.data.equals(item)) {
			n = n.next;
			index++;
		}
		return index;

	}

	/**
	 * function to remove the item from the last of list and return it
	 * 
	 * @return the last element of list after removing
	 */

	public T pop() {
		Node<T> n = head;
		Node<T> prev = null;
		while (n.next != null) {
			prev = n;
			n = n.next;
		}
		prev.next = null;
		tail = prev;
		return (T) n.data;
	}

	/**
	 * Function to return the element at the given position
	 * 
	 * @param pos the index at which the item to return
	 * @return the element at the given index after removing it
	 */
	public T pop(int pos) {
		int index = 0;
		Node<T> prev = null;
		Node<T> n = head;
		if (head == null) {
			return null;
		}
		if (pos == 0) {
			head = head.next;
			return (T) n.data;
		} else {
			while (index != pos) {
				prev = n;
				n = n.next;
				index++;
			}
			prev.next = n.next;

			return (T) n.data;
		}
	}

}
