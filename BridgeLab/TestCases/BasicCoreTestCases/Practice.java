package BasicCoreTestCases;
import java.time.LocalDate;
import java.util.Base64;
import java.util.StringJoiner;
import java.util.stream.Stream;

interface Sayable{  
    void say();  
    
}  
public class Practice{  
	public static void thread() {
	
		for(int i = 0 ; i < 10; i++) {
		System.out.println("running");
	}}
	
	
    public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }  
    public static void main(String[] args) {
     
    	LocalDate date = LocalDate.now();
    	LocalDate  todY = date.withDayOfMonth(5);
    	System.out.println(date);
    	System.out.println(todY);
    	
    	System.out.println(LocalDate.now());
    StringJoiner ne  =  new StringJoiner("rahyk");
    	ne.add("rahul");
    	ne.add("sgdgdfg");
    	ne.add("sdfsdfF");
    	 StringJoiner nee  =  new StringJoiner("k");
     	ne.add("rahul");
     	ne.add("sgdgdfg");
     	ne.add("sdfsdfF");
    	nee.merge(ne);
    	System.out.println(nee);
    
    Base64.Encoder n = Base64.getEncoder();
    String str = n.encodeToString(ne.toString().getBytes());
    
  
    System.out.println(str);
    Base64.Decoder  m  = Base64.getDecoder();
    String ms  =new String( m.decode(str.getBytes()));
    System.out.println(ms);
    
    
    	 Stream.iterate(1, element->element+1)  
         .filter(element->element%20==0)  
         .limit(10)
         .forEach(System.out::println);  
    	
        Thread ng = new Thread(Practice::thread);
        ng.start();
        // Referring static method  
        Sayable sayable = Practice::saySomething;  
        // Calling interface method  
        sayable.say();  
    }  
}  
