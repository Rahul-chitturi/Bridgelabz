package com.bridgelabz.loginregistration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	      HttpSession session = request.getSession(false);
	      session.removeAttribute("user");
	      session.getMaxInactiveInterval();
           response.sendRedirect("Logout.jsp");
	   }catch(Exception e) {
		   e.printStackTrace();
		   response.sendRedirect("Logout.jsp");
	   }
	}
}


