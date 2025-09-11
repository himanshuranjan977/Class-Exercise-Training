<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Add New Hotel</h2>
    
    <form action="savehotel" method="post">
        <label for="name">Hotel Name:</label>
        <input type="text" id="name" name="name" required />
        <br><br>

        <label for="address">Hotel Address:</label>
        <input type="text" id="address" name="address" required />
        <br><br>

        <input type="submit" value="Save Hotel" />
    </form>

</body>
</html>