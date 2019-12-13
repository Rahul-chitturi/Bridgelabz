package com.bridgelabz.loginregistration.controller;

import java.io.IOException;

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
		
	 String Email = (String) request.getParameter("email");
     String Pass =  (String) request.getParameter("pass"); 
     LoginModel n = new LoginModel();
     n.setEmail(Email);
     n.setPass(Pass);
     JDBC j = new JDBC();
     int i= j.getLoginEmailPassword(n);
     if(i==1) {
   	    RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
           rd.forward(request, response);
     }
     else {
   	  System.out.println("not ");
     }

	}



}
