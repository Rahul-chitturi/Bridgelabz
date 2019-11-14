package dataStructure;

/**
 * @author Rahul C H
 *
 */
public class OrderdList<T extends Comparable<T>> {
 Node head ; 

 @SuppressWarnings("unchecked")
public void add(T data) {
	 Node node = new Node(data);
	 if(head == null) {
		 head  = node;
		 return;
	 }
	 
	 if(data.compareTo((T) head.data)<0) {
		 node.next = head;
			head = node;
			return;
	 }
	 Node temp = head ; 
	 Node prev =  null; 
	 while( data.compareTo((T) temp.data) > 0 &&  temp.next!=null ) {
		 prev  =  temp;
		 temp = temp.next;
	 }
	 prev.next= node;
	 node.next = temp;
 }
 public void disp() {
	 Node temp = head;
	 while(temp!= null) {
		 System.out.println(temp.data);
		 temp = temp.next;
	
	 }
 }
 
 public static void main(String[] args) {
	 OrderdList<Integer> or =new OrderdList<Integer>();
	 or.add(78);
	 
	or.disp();
 }
 
}
