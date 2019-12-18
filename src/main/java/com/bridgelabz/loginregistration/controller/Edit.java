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

public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Id = (String) request.getParameter("edit");

		String name = "";
		LoginModel n = new LoginModel();
		try {

			HttpSession session = request.getSession(false);
			if (session.getAttribute("user") != (null)) {

				name = (String) session.getAttribute("user");

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			session.removeAttribute("user");
			session.getMaxInactiveInterval();
			n.setEmail(name);
			request.setAttribute("rahul", n);
			HttpSession session1 = request.getSession(true);
			session1.setAttribute("user", n.getEmail());
			session1.setMaxInactiveInterval(10);
			Resultset fulltable = (Resultset) JDBC.getEdit(Id);
			request.setAttribute("email", name);
			request.setAttribute("fulltable", fulltable);
			RequestDispatcher rd = request.getRequestDispatcher("Edit.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
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
