package BasicCoreTestCases;

interface same{
	void add();
 default void sub() {
 }
}
interface same1 extends same{
	void sub();	
}
public class Interface {
	public static void main(String[] args) {	
	}
}
 class A implements same {
	 public void add() {
	 }
 }
 class B implements same1{
	 public void add() {
		 
	 }
	 public void sub() {
		 
	 }
 }
