<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Add Tag Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <body>
    Name: ${student.name}
    <br>
    Age: ${student.age}
    <br>

    <c:if test="${student.age < 18}">
        <b>This student is minor</b>
    </c:if>

    <c:if test="${student.age >= 18}">
        <b>This student is major</b>
    </c:if>
</body>

</body>
</html>