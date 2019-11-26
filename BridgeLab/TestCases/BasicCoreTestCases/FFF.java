package BasicCoreTestCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FFF {

	public static void rock() {
		List<Integer> l = new  ArrayList<Integer>();
		l.add(90);
		l.add(60);
		l.add(54);
		l.add(23);
		l.add(80);
		 System.out.println(l);
		 Comparator<Integer> c  = (t,r)->{return t>r?1:(t<r)?-1:0;};
        Collections.sort(l , c);
        l.stream().forEach(System.out::println);
        List<Integer> l2 = l.stream().filter(i->i%3==0).collect(Collectors.toList());
        System.out.println(l2);
	}
	
	
	
	public static void main(String[] args) {
		FFF.rock();
	Runnable r  = ()->{ for(int i  = 0 ; i < 10 ; i++) {
		System.out.println("interface");
	}
	};
	Thread t = new Thread(r);
	t.start();
	
		for(int i  = 0 ; i <  10 ; i++) {
			System.out.println("main");
		}
	in i = (a , b )-> {return a+b;};	
System.out.println(	i.add(200,300));
	i.add(500,800);
	}
	
	
	@FunctionalInterface
	interface in{
		int add(int a ,int  b);
		default void man() {
			
		}
		static void bu() {
			
		}
	}
	

}
class Myclass implements Runnable {
public	void run() {
	for(int i  = 0 ; i < 10 ; i++) {
		System.out.println("interface");
	}
	}
}
