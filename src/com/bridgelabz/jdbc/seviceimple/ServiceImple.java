package com.bridgelabz.jdbc.seviceimple;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.bridgelabz.jdbc.controller.Mysqlcon;
import com.bridgelabz.jdbc.model.jdbcGetterSetter;
import com.bridgelabz.jdbc.repository.getConnection;
import com.bridgelabz.jdbc.sevice.service;
public class ServiceImple implements service{
	public static void display() {
		try {
		Statement stmt=Mysqlcon.getConnect().createStatement();  
		ResultSet rs=stmt.executeQuery("select * from student");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" " +rs.getString(4)+" "+rs.getString(5)+" " +rs.getString(6) );  
		Mysqlcon.getConnect().close();  
		}catch(Exception e){ System.out.println(e);}   
	}
	
	public static void edit(jdbcGetterSetter n) {
		try {
		PreparedStatement stmt=getConnection.getConnect().prepareStatement("insert into student(name , class ,age ,city,father_name) values(?,?,?,?,?)");  
		stmt.setString(1,n.getName());  
		stmt.setString(2,n.getClasss());
		stmt.setString(3,n.getAge()); 
		stmt.setString(4,n.getCity());
		stmt.setString(5,n.getFathername()); 
		int i=stmt.executeUpdate();  
		System.out.println(i+" records inserted");  
		}catch(Exception e){ System.out.println(e);}  	  
	}
}

