package com.bridgelabz.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Base64;
import com.bridgelabz.designpattern.utility.Utility;

public class getConnection {
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Myfistdatabase", "Rahul",
					new String(Base64.getDecoder().decode(Utility.getPassword())));
			return con;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
}
