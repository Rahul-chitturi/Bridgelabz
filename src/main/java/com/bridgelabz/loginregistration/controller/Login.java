package com.bridgelabz.loginregistration.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.ResultSet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
    	request.setAttribute("fulltable", fulltable);
    	  String Username[] =Email.split("@");
    		 n.setEmail(Username[0]);
    	request.setAttribute("rahul",n );

  RequestDispatcher rd = request.getRequestDispatcher("Success");
  rd.forward(request, response);
     }
     
     else {
    	request.setAttribute("myname","Invalid Email Or PassWord");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.include(request, response);
     } 
     }

	}




