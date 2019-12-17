package com.bridgelabz.loginregistration.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import com.bridgelabz.loginregistration.model.LoginModel;
import com.bridgelabz.loginregistration.model.RegistrationModel;

import com.bridgelabz.loginregistration.utility.Utility;
public class JDBC {
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginRegistration", "Rahul",
					new String(Base64.getDecoder().decode(Utility.getPassword())));
			return con;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
	public static ResultSet getEdit(String id) {
		ResultSet rs=null;
		try {
		Statement stmt=getConnect().createStatement();  
		 rs=stmt.executeQuery("select * from User_Details where Id = "+id);
		 
	getConnect().close();  
		return rs;
		}catch(Exception e){ System.out.println(e);}   
		return rs;
	}
	public static ResultSet getFullTable() {
		ResultSet rs=null;
		try {
		Statement stmt=getConnect().createStatement();  
		 rs=stmt.executeQuery("select * from User_Details");
//while(rs.next())  
	//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" " +rs.getString(4)+" "+rs.getString(5)+" " +rs.getString(6) );  
		getConnect().close();  
		return rs;
		}catch(Exception e){ System.out.println(e);}   
		return rs;
	}
	
	public int getLoginEmailPassword(LoginModel o) {
	String email=	o.getEmail();
	String pass = o.getPass() ;
	try {
		Statement stmt=getConnect().createStatement();  
		ResultSet rs=stmt.executeQuery("select * from User_Details");  
		while(rs.next()) {
	    if(email.equalsIgnoreCase(rs.getString("email")) && pass.equals(rs.getString("Password")))	{
	    	return 1;
	    }
	}
	
		 
		getConnect().close();  
		return 0;
		}catch(Exception e){ System.out.println(e);}  
	return -1;
	}
	
	public int delete(String email) {
		try {
			PreparedStatement stmt=getConnect().prepareStatement("delete from User_Details where Id=? ");
			stmt.setString(1,email);
			int i=stmt.executeUpdate(); 
			return i;  
		}catch(Exception e){ System.out.println(e);}  	  
		return 0;
		}
		
	public static int update(RegistrationModel n) {
		try {
		PreparedStatement stmt=getConnect().prepareStatement("update User_Details set  email = ? , First_Name = ?, Last_Name =? , Contact_Number =? where Id = ?");  
		stmt.setString(1,n.getEmail());  
		stmt.setString(2,n.getFirstName());
		stmt.setString(3,n.getLastName()); 
		stmt.setLong(4, n.getNumber());
		stmt.setInt(5, n.getId());
		int i=stmt.executeUpdate();  
		return i;  
		}catch(Exception e){ System.out.println(e);}  	  
	return 0;
	}
	public int edit(RegistrationModel n) {
		try {
		PreparedStatement stmt=getConnect().prepareStatement("insert into User_Details( email , First_Name, Last_Name , Password , Contact_Number  ) values(?,?,?, ?, ?);");  
		stmt.setString(1,n.getEmail());  
		stmt.setString(2,n.getFirstName());
		stmt.setString(3,n.getLastName()); 
		stmt.setString(4,n.getPass());
		stmt.setLong(5, n.getNumber());
		int i=stmt.executeUpdate();  
		return i;  
		}catch(Exception e){ System.out.println(e);}  	  
	return 0;
	}
	
}
