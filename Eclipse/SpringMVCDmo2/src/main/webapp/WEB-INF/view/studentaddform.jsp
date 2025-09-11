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
    <h2>Add Student</h2>
    <form method="post" action="${pageContext.request.contextPath}/student/studentsave">
        Name: <input type="text" name="name" required /> <br><br>
        Age: <input type="number" name="age" required /> <br><br>
        <button type="submit">Save Student</button>
    </form>
    

</body>
</html>