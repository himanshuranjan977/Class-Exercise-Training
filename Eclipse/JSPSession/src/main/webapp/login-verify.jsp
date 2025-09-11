<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Verification Page</title>
</head>
<body>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Hardcoded check (username=admin, password=admin)
    if("admin".equals(username) && "admin".equals(password)) {
              session.setAttribute("loginuser","admin");
              response.sendRedirect("home.jsp");
    } else {
    	response.sendRedirect("login.jsp");

    }
%>

</body>
</html>