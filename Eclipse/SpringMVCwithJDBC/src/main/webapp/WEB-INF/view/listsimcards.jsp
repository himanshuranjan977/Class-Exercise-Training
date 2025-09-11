<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Simcards</title>
</head>
<body>
   <h2>All SimCards</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Company</th>
            <th>Plan Name</th>
        </tr>
        <c:forEach var="s" items="${simcards}">
            <tr>
                <td>${s.id}</td>
                <td>${s.company}</td>
                <td>${s.planName}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="addsimcard">Add New Simcard</a>
</body>
</html>
