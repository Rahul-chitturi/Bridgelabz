package com.bridgelabz.loginregistration.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.loginregistration.model.LoginModel;
import com.bridgelabz.loginregistration.repository.JDBC;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//PrintWriter Out = response.getWriter();
	 String Email = (String) request.getParameter("email");
     String Pass =  (String) request.getParameter("pass"); 
     LoginModel n = new LoginModel();
     n.setEmail(Email);
     n.setPass(Pass);
     JDBC j = new JDBC();
     int i= j.getLoginEmailPassword(n);
     if(i==1) {
    	ResultSet fulltable= JDBC.getFullTable();
    	try {
    		while(fulltable.next())
			System.out.println(fulltable.getString("First_Name").toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 request.setAttribute("fulltable", fulltable);
  String Username[] =Email.split("@");
  HttpSession session = request.getSession(true);
  session.setAttribute("user", Username[0]);
  session.setMaxInactiveInterval(10250); 
  RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
  rd.forward(request, response);
     }
     
     else {
    	request.setAttribute("myname","Invalid Email Or PassWord");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.include(request, response);
     } 
     }

	}




