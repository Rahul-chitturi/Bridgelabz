package com.bridgelabz.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

import com.bridgelabz.designpattern.utility.Utility;

public class Mysqlcon {
	public static void main(String[] args) {
		
	try{  

	
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/Myfistdatabase","Rahul",new String( Base64.getDecoder().decode(Utility.getPassword())));
		PreparedStatement stmt=con.prepareStatement("insert into student values(?,?,'5')");
		stmt.setInt(1, 11);
		stmt.setString(2, "raghu");
		Statement stgmt=con.createStatement();  
	int a =	 stmt.executeUpdate();
//	System.out.println(a);
		ResultSet rs=stmt.executeQuery("select * from student");  
		while(rs.next())  
		System.out.println(rs.getString(2)+"  "+rs.getInt(1)+"  "+rs.getString(3));  
		con.close();  
		}catch(Exception e){ System.out.println(e);
		e.printStackTrace();}  
		}  
}