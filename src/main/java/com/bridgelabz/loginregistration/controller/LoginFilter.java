package com.bridgelabz.loginregistration.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 String Email = (String) request.getParameter("email");
		 System.out.println("inside the Filter");
		 if(Email.length()>7) {
			 RequestDispatcher rs = request.getRequestDispatcher("Login");
			 rs.forward(request, response);
		 }else {
			 RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			 rs.forward(request, response);
		 }
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
