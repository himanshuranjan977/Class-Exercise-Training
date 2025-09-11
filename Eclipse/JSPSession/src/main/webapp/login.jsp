<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="login-checker.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login page</title>
</head>
<body>
    <h2>Login into my secure application</h2>

    <form action="login-verify.jsp" method="post">
        <label>Username : </label>
        <input type="text" required name="username" />
        <br><br>
        <label>Password : </label>
        <input type="password" required name="password" />
        <br><br>
        <button type="submit">Login</button>
    </form>
</body>
</html>