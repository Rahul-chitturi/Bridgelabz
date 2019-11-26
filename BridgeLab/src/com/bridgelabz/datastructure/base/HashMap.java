package com.bridgelabz.datastructure.base;

/******************************************************************************
 * @purpose: Hashing Function to search a Number in a slot
 * @author :RAHUL CHITTURI
 * @version :1.0
 * @since :11-11-2019
 * @fileName :HashMap.java
 ******************************************************************************/

public class HashMap<T> {
	@SuppressWarnings("unchecked")
	/**
	 * Node type Array with size of 11
	 */
	Node<T>[] array = new Node[11];
	/**
	 * T type Node
	 */
	Node<T> next;

	/*
	 * @purpose : to create empty map
	 * 
	 * @param : no parameter need
	 */
	public HashMap() {

	}

	/**
	 * @purpose adds item to list
	 * @param it needs item of any type
	 * @return returns nothing (void)
	 */

	public void add(T data) {
		Node<T> node = new Node<T>(data);
		int da = (int) data;
		int index = da % 11;
		if (array[index] == null) {
			array[index] = node;
		} else {
			Node<T> temp = array[index];

			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	/**
	 * @purpose to display the Hashing function
	 * @param it needs nothing
	 * @return returns nothing (void)
	 */
	public void display() {
		System.out.println("Remainder " + " values:-");
		for (int i = 0; i < array.length; i++) {
			Node<T> temp = array[i];
			boolean flag = true;
			if (temp != null) {
				flag = false;
				System.out.print(" [" + i + "]     ");
				while (temp != null) {
					System.out.print(temp.data + "  ");
					temp = temp.next;
				}
			} else {
				flag = true;
			}

			if (flag) {
				// System.out.println(" ["+i+"]");
			} else {
				System.out.println();
			}
		}
	}
}
