package com.bridgelabz.datastructure.base;

/********************************************************************************************
 * Purpose :Unordered list reusable code with many methods
 * 
 * @author :Rahul C H
 * @version :1.0
 * @date :21-11-2019
 * @Filename :Unordered.java
 ********************************************************************************************/
public class Unordered<T> {

	private Node<T> head;

	/**
	 * creates a empty list
	 * 
	 * @param it need nothing
	 * @return it return nothing (void)
	 */
	public void list() {
		head = null;
	}

	/**
	 * @Purpose adds a new item to the list
	 * @param it need the item
	 * @return it return nothing (void)
	 */
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		if (head == null) {
			head = node;
			return;
		}

		Node<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;
	}

	/**
	 * @purpose :test to see wheather the list is empty or not
	 * @param :it needs nothing
	 * @return :it returns boolean value
	 */

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	/**
	 * @purpose removes the item form the list
	 * @param it need the item
	 * @return it will return nothing
	 */

	public void remove(T item) {
		Node<T> n = head;
		Node<T> prev = null;
		if (head.data.equals(item)) {
			head = head.next;
			return;
		}
		while (!n.data.equals(item)) {
			prev = n;
			n = n.next;
		}
		n = n.next;
		prev.next = n;

	}

	/**
	 * @purpose :it will search for the item and returns boolean
	 * @param :it needs item to search
	 * @return :it will return a boolean
	 */

	public boolean search(T item) {
		Node<T> temp = head;
		while (temp != null) {
			if (temp.data.equals(item)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	/**
	 * @purpose : checks the size of the list
	 * @param : it needs nothing
	 * @return : it returns INTEGER to show size
	 */

	public int size() {
		int count = 0;
		Node<T> temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	/**
	 * @purpose : to find the index number of the item if it is present
	 * @param : it needS item to find its index
	 * @return : it returns the integer defines index
	 */
	public int index(T item) {
		int index = 0;
		Node<T> temp = head;
		while (temp != null) {
			if (item.equals(temp.data)) {
				return index;
			}
			index++;
			temp = temp.next;
		}
		return -1;
	}

	/**
	 * @purpose : insert a item at a specified position
	 * @param : it need position called pos
	 * @param : it need item called item
	 * @return : returns Nothing (void)
	 */
	public void insertAt(int pos, T item) {
		if (pos > size()) {
			System.out.println("out of position");
			return;
		}
		Node<T> node = new Node<T>(item);
		if (pos == 0) {
			node.next = head;
			head = node;
			return;
		}
		Node<T> temp = head;

		for (int i = 0; i < pos - 1; i++) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
	}

	/**
	 * @purpose : program to get the last item from the list
	 * @param : it need nothing
	 * @return : it will return the data at that position
	 */
	public T pop() {
		T data = null;
		if (head.next == null) {

			data = (T) head.data;
			head = null;
			return data;
		}
		Node<T> temp = head;
		Node<T> prev = null;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		data = (T) temp.data;
		prev.next = null;
		return data;
	}

	/**
	 * @purpose : program to get the item from list at a specified position and it
	 *          will remove the item
	 * @param : it need the index number to find the position
	 * @return : it will return the data at that position
	 */

	public T pop(int pos) {
		int index = 0;
		Node<T> n = head;
		if (pos == 0) {
			head = head.next;

			return (T) n.data;
		}
		Node<T> prev = null;
		while (index != pos) {
			prev = n;
			n = n.next;
			index++;
		}
		prev.next = n.next;

		return (T) n.data;
	}

	/**
	 * @purpose : program to get the item from list at a specified position
	 * @param : it need the index number to find the position
	 * @return : it will return the data at that position
	 */
	public T get(int index) {
		Node<T> temp = head;
		Node<T> prev = null;

		for (int i = 0; i <= index; i++) {
			prev = temp;
			temp = temp.next;
		}
		return (T) prev.data;
	}

	/**
	 * @purpose :to display the Unordered list
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

	// public static void main(String[] args) {
	// Unordered t = new Unordered();
	// t.insertAt(0,43);
	// t.disp();
	// }

}