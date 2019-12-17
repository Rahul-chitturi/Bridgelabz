<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int i =Integer.parseInt(request.getParameter("otp"));
out.print(i);
%>
<form action="validateotp" method="post">
<input type="text"  >
<button type="submit">submit</button>
</form>
</body>
</html>