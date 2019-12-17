package com.bridgelabz.loginregistration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.loginregistration.model.LoginModel;
import com.bridgelabz.loginregistration.model.RegistrationModel;
import com.bridgelabz.loginregistration.repository.JDBC;
import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
		String Fname = (String) request.getParameter("Fname");
	     String Lname =  (String) request.getParameter("Lname"); 
		 String email = (String) request.getParameter("email"); 
		 String number = (String) request.getParameter("num");
		 String Id = (String) request.getParameter("id");
		 int id = Integer.parseInt(Id);
		 long num = Long.parseLong(number);
		 RegistrationModel GetSet = new RegistrationModel(); 
		 GetSet.setFirstName(Fname);
		 GetSet.setLastName(Lname);
		 GetSet.setEmail(email);
		 GetSet.setNumber(num);
		 GetSet.setId(id);
int i = JDBC.update(GetSet);
if(i>0) {
		 String name="";
		 LoginModel n = new LoginModel();
	
    HttpSession session = request.getSession(false);
    if(session.getAttribute("user")!=(null)) {
    	    name =(String) session.getAttribute("user");
    	    System.out.println("sdf");
    }else {
    	System.out.println("out");
    	 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    	 rd.forward(request, response);
    }
    session.removeAttribute("user");
    session.getMaxInactiveInterval(); 
    n.setEmail(name);
	request.setAttribute("rahul", n );
	Resultset fulltable =  (Resultset) JDBC.getFullTable();
	request.setAttribute("email", name);
	request.setAttribute("fulltable", fulltable);
	RequestDispatcher rd = request.getRequestDispatcher("Success");
	rd.forward(request, response);
	
}else {
response.sendRedirect("err.jsp");
	}

}catch(Exception e ) {
	
}
	}
}
	
