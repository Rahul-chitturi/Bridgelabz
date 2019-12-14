 <%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success</title>

 <link rel="stylesheet" type="text/css" href="resp/vendor/bootstrap/css/bootstrap.min.css"> 
	<link rel="stylesheet" type="text/css" href="resources/Successe/css/Success.css">
</head>
<body>

    <%
   String name ="";
      if (session != null) {
    	  
         if (session.getAttribute("user") != null) {
             name = (String) session.getAttribute("user");
         } else {
            response.sendRedirect("index.jsp");
         }
      }
   %> 
<nav class="navbar navbar-expand-sm bg-secondary justify-content-end ">
  <ul class="navbar-nav">
  <li class="nav-item">
   <div class="nav-link"> <h4>Welcome, < <%= name %> </h4></div>
    </li>
    <li class="nav-item">  
      <form action="Logout" method="post">
    <button type="submit" class=" nav-link btn btn-info">Logout</button>
   </form>

    </li>
    

  </ul>
</nav>
   <div class="table-users">
   <div class="header">Users</div>
   <table >
      <tr>
         <th>First Name</th>
         <th>Last Name</th>
         <th>Email</th>
         <th>Phone</th>
         <th width="230">Comments</th>
      </tr>
       <% String name1="";
     ResultSet full = (ResultSet)request.getAttribute("fulltable");
     out.print(full);
      while(full.next()){
    	 name1= full.getString("Fname");
      
      %> 
      <tr>
         <td><%=name1 %></td>
         <td>jane.doe@foo.com</td>
         <td>01 800 2000</td>
         <td></td>
      </tr>
     <%} %> 
   </table>
</div>


</body>
</html>