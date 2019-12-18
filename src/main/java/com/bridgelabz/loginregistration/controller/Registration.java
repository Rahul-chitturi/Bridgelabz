package com.bridgelabz.loginregistration.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridgelabz.loginregistration.model.RegistrationModel;
import com.bridgelabz.loginregistration.repository.JDBC;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Fname = (String) request.getParameter("Fname");
		String Lname = (String) request.getParameter("Lname");
		String email = (String) request.getParameter("email");
		String pass = (String) request.getParameter("password");
		String number = (String) request.getParameter("num");
		long num = Long.parseLong(number);
		RegistrationModel GetSet = new RegistrationModel();
		GetSet.setFirstName(Fname);
		GetSet.setLastName(Lname);
		GetSet.setEmail(email);
		GetSet.setPass(pass);
		GetSet.setNumber(num);
		JDBC jdbc = new JDBC();
		int i = jdbc.edit(GetSet);
		if (i == 1) {
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("Registration.jsp");
			rs.forward(request, response);
		}

	}

}
