package com.bridgelabz.loginregistration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.loginregistration.model.LoginModel;
import com.bridgelabz.loginregistration.repository.JDBC;
import com.mysql.cj.protocol.Resultset;


public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    String email=(String) request.getParameter("delete");
	JDBC jdbc = new JDBC();
	 String name="";
	 LoginModel n = new LoginModel();
	 try {
		
    HttpSession session = request.getSession(false);
    if(session.getAttribute("user")!=(null)) {
    	    name =(String) session.getAttribute("user");
    }else {
    	 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    	 rd.forward(request, response);
    }
    session.removeAttribute("user");
    session.getMaxInactiveInterval(); 
    n.setEmail(name);
	request.setAttribute("rahul", n );
 jdbc.delete(email);
Resultset fulltable =  (Resultset) JDBC.getFullTable();
request.setAttribute("email", name);
request.setAttribute("fulltable", fulltable);
RequestDispatcher rd = request.getRequestDispatcher("Success");
rd.forward(request, response);
	 }catch (Exception e) {
		 RequestDispatcher rd = request.getRequestDispatcher("err.jsp");
		 try {
			rd.forward(request, response);
		} catch (ServletException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	}
     
	}

}
