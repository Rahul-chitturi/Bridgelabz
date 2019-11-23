package com.bridgelabz.datastructure.base;

public class Queue<T extends Comparable<T>> {
Node head;
Node tail;
/**
 * @purpose creates a empty queue
 * @param it needs nothing
 */
    public void Deque() {
    	head = null;
    }
       
	public Queue() {
		head = null;
	}	
	
	public void enqueue( T item) {
	Node node  = new Node(item);	
		if(head ==  null) {
			head = node;
			head.next=null;
		}
		else {
	Node temp = head;
	while(temp.next!=null)
	{
	temp = temp.next;
	}
	temp.next = node;
	node.next = null;
		}
		
	}
	
	public void disp() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
		temp = temp.next;
		}
	}
	 
	@SuppressWarnings("unchecked")
	public T dequeue() {
		Node temp = head;
	if(head == null) {
		System.out.println("queue is empty");
		return null;
	}
	
	head = head.next;
	return (T)temp.data;
		
	}
	
	public boolean isEmpty() {
		return head==null?true:false;		
	}
	
	public void addFront(T item) {
      Node node = new Node(item);
      node.next =head; 
      head  = node;
      
	}
	public void addRear(T item) {
	enqueue(item);
	}
	
	public T removeFront() {
		T data = dequeue();
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public T removeRear() {
		T data = null;
		Node temp = head; 
		if(head.next ==  null) {
			data = (T) head.data;
			head = null;
			return data;
		}
		while(temp.next.next != null){
			temp = temp.next ; 
		}
		
		data = (T)temp.next.data;
		temp.next = null;
		return data;
	}
	public int size() {
		Node temp = head; 
		int count  = 0;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
}
