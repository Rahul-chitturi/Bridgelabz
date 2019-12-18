<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="resources/register/fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" type="text/css"
	href="resp/vendor/bootstrap/css/bootstrap.min.css">
<!-- Main css -->
<link rel="stylesheet" href="resources/register/css/style.css">
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
					<div class="row">
						<div class="col-sm-3">

							<button type="submit" class=" nav-link btn btn-info">Logout</button>
						</div>
					</div>
				</form>

			</li>


		</ul>
	</nav>
	<div class="main">

		<section class="signup">

			<div class="container">
				<div class="signup-content">
					<%
						try {
							ResultSet table = (ResultSet) request.getAttribute("fulltable");
							while (table.next()) {
					%>
					<form method="POST" id="signup-form" class="signup-form "
						action="Update" class="was-validated"">
						<h2 class="form-title">Update Details</h2>
						<div class="form-group ">
							<input type="text" class="form-input" name="Fname" id="Fname"
								placeholder="First Name"
								value=<%=table.getString("First_Name")%> required />
						</div>
						<div class="form-group ">
							<input type="text" class="form-input" name="Lname" id="Lname"
								placeholder="Last Name" value=<%=table.getString("Last_Name")%>
								required />
						</div>
						<div class="form-group ">
							<input type="email" class="form-input" name="email" id="email"
								placeholder="Your Email" value=<%=table.getString("email")%>
								required />
						</div>

						<div class="form-group">
							<input type="hidden" id="id" name="id"
								value=<%=table.getString("Id")%>></input> <input type="text"
								class="form-input" name="num" id="num"
								pattern="[7-9]{1}[0-9]{9}" placeholder="Contact Number"
								value=<%=table.getString("Contact_Number")%> required />
						</div>



						<div class="form-group">
							<input type="submit" name="submit" id="submit"
								class="form-submit" value="Update" />
						</div>
					</form>
					<%
						}
						} catch (Exception e) {
						}
					%>
				</div>
			</div>
		</section>

	</div>
	<script>
		function valid() {

			var pass = document.getElementById('password').value;
			var repass = document.getElementById('re_password').value;
			if (pass != repass) {
				document.getElementById('repass').innerHTML = "Pass word not mched";
			} else {
				document.getElementById('repass').innerHTML = "";
			}

			return false;
		}
	</script>

	<script src="resources/register/vendor/jquery/jquery.min.js"></script>
	<script src="resources/register/js/main.js"></script>
</body>
</html>