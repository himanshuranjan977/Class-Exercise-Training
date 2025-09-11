<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
</head>
<body>

        <jsp:include page="login-checker.jsp"></jsp:include>

        <h2>Welcome to my secure application</h2>
        
        <a href="logout.jsp">Logout</a>


</body>
</html>
