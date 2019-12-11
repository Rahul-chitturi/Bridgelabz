package com.bridgelabz.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Base64;

import com.bridgelabz.designpattern.utility.Utility;
import com.bridgelabz.jdbc.model.jdbcGetterSetter;
import com.bridgelabz.jdbc.seviceimple.ServiceImple;

public class Mysqlcon {

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

	public static void main(String[] args) {
		try {
			int i = 1;
			while (i != 0) {
				System.out.println("enter 1 to insert \nenter 2 to display");
				String r = Utility.inputString();
				if (r.equals("1")) {
					jdbcGetterSetter n = new jdbcGetterSetter();
					System.out.print("enter name: ");

					n.setName(Utility.inputString());
					System.out.print("enter class: ");

					n.setClasss(Utility.inputString());
					System.out.print("enter age: ");

					n.setAge(Utility.inputString());
					System.out.print("enter city:");

					n.setCity(Utility.inputString());
					System.out.print("enter father name:");

					n.setFathername(Utility.inputString());

					ServiceImple.edit(n);
				} else {
					ServiceImple.display();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}