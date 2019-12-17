package com.bridgelabz.loginregistration.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.loginregistration.model.LoginModel;

/**
 * Servlet implementation class Success
 */
public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	LoginModel n = (LoginModel) request.getAttribute("rahul");  

	ResultSet fulltable = (ResultSet)request.getAttribute("fulltable");
		HttpSession session = request.getSession(true);
		  session.setAttribute("user", n.getEmail());
		  session.setMaxInactiveInterval(10); 
	    request.setAttribute("fulltable", fulltable);
	    RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
	    rd.forward(request, response);
	    
	    
	}

}
