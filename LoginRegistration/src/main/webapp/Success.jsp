
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success</title>

<link rel="stylesheet" type="text/css"
	href="resp/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/Successe/css/Success.css">
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");

		String name = "";
		if (session != null) {

			if (session.getAttribute("user") != null) {
				name = (String) session.getAttribute("user");
			} else {

				response.sendRedirect("index.jsp");
			}
		}
	%>
	<div class="row">
		<div class="col-sm-2">
			<nav
				class="navbar navbar-expand-sm bg-secondary justify-content-end fixed-top ">
				<ul class="navbar-nav">
					<li class="nav-item">
						<div class="nav-link">
							<h5>
								Welcome,
								<%=name%>
							</h5>
						</div>
					</li>
					<li class="nav-item">
						<form action="Logout" method="post">
							<button type="submit" class=" nav-link btn btn-info">Logout</button>

						</form>
					</li>


				</ul>
			</nav>
		</div>
	</div>

	<div class="table-users">
		<div class="header">Users</div>
		<table>
			<tr>
				<th align="left">First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th></th>
				<th></th>
			</tr>
			<%
				try {
					String name1 = "";

					ResultSet full = (ResultSet) request.getAttribute("fulltable");

					while (full.next()) {
			%>
			<tr>
				<td><%=full.getString("First_Name")%></td>
				<td><%=full.getString("Last_Name")%></td>
				<td><%=full.getString("email")%></td>
				<td><%=full.getString("Contact_Number")%></td>
				<td><form action="Edit" method="post">
						<input type="hidden" name="edit" value="<%=full.getString("Id")%>">
						<button type="submit" class=" nav-link btn btn-info">Edit
						</button>
					</form></td>
				<td><form action="Delete" method="post">
						<input type="hidden" name="delete"
							value="<%=full.getString("Id")%>">
						<button type="submit" class=" nav-link btn btn-info">Delete
						</button>
					</form></td>
			</tr>
			<%
				}
				} catch (Exception e) {
				}
			%>
		</table>
	</div>
</body>
</html>