<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login-checker.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <jsp:include page="login-checker.jsp"></jsp:include>
    
    <h2>Welcome to my Secure application - Gallery page </h2>
    <a href="logout.jsp">Logout</a>

</body>
</html>