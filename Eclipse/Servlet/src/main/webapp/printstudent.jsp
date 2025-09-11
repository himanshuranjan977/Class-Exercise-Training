<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Printing Data from the Servlet</title>
</head>
<body>
    <h2>Student Information Received</h2>

    Name   : <%= request.getAttribute("name") %> <br>
    Age    : <%= request.getAttribute("age") %> <br>
    Mobile : <%= request.getAttribute("mobile") %> <br>
    Email  : <%= request.getAttribute("email") %> <br>
    

</body>
</html>
