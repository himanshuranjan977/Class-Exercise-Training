<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hot Page</title>
</head>
<body>

     <!-- Protect this page -->
     <jsp:include page="login-checker.jsp"></jsp:include>

     <h2> Welcome to the HOT Page </h2>
     <p>This is a special page that only logged-in users can see.</p>

     <p>Hello, <b><%= session.getAttribute("loginuser") %></b> </p>

     <a href="login.jsp">Login</a>

</body>
</html>
