package com.bridgelabz.loginregistration.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.loginregistration.model.LoginModel;
public class Forget extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
		String Email = (String) request.getParameter("email");
		 LoginModel n = new LoginModel();
	     n.setEmail(Email);
	     System.out.println(Email);

	   RequestDispatcher ne =request.getRequestDispatcher ("enterotp.jsp");
	   ne.forward(request, response);
	}catch (Exception e) {
	response.sendRedirect("err.jsp");
	}
	}

}



