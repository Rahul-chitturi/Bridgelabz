package com.bridgelabz.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		
	
	@SuppressWarnings("resource")
	ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

    StudentJDBCTemplete studentJDBCTemplate = 
       (StudentJDBCTemplete)context.getBean("studentJDBCTemplate");
    
    System.out.println("------Records Creation--------" );
    studentJDBCTemplate.create("Zara", 11);
    studentJDBCTemplate.create("Nuha", 2);
    studentJDBCTemplate.create("Ayan", 15);

    System.out.println("------Listing Multiple Records--------" );
    List<StudentJDBC> students = studentJDBCTemplate.listStudents();
    
    for (StudentJDBC record : students) {
       System.out.print("ID : " + record.getId() );
       System.out.print(", Name : " + record.getName() );
       System.out.println(", Age : " + record.getAge());
    }

    System.out.println("----Updating Record with ID = 2 -----" );
    studentJDBCTemplate.update(2, 20);

    System.out.println("----Listing Record with ID = 2 -----" );
    StudentJDBC student = studentJDBCTemplate.getStudent(2);
    System.out.print("ID : " + student.getId() );
    System.out.print(", Name : " + student.getName() );
    System.out.println(", Age : " + student.getAge());
    
    System.out.println("----Delete -----" );
    studentJDBCTemplate.delete(2);
    System.out.println("------Listing Multiple Records--------" );
    List<StudentJDBC> students1 = studentJDBCTemplate.listStudents();
    
    for (StudentJDBC record : students1) {
       System.out.print("ID : " + record.getId() );
       System.out.print(", Name : " + record.getName() );
       System.out.println(", Age : " + record.getAge());
    }
    studentJDBCTemplate.delete();
    
 }
}

