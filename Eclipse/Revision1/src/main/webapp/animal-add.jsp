<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Animal</title>
</head>
<body>
    <h2>Add Animal</h2>

    <!-- Show success message if available -->
    <c:if test="${not empty message}">
        <p style="color:green;">${message}</p>
    </c:if>

    <form action="addAnimal" method="post">
        <!-- Animal Name -->
        <label for="name">Animal Name:</label>
        <input type="text" id="name" name="name" required />
        <br><br>
        
        <!-- Animal Age -->
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" min="0" required />
        <br><br>
        
        <!-- Animal Color -->
        <label for="color">Color:</label>
        <select id="color" name="color" required>
            <option value="">-- Select Color --</option>
            <option value="Black">Black</option>
            <option value="White">White</option>
            <option value="Brown">Brown</option>
            <option value="Gray">Gray</option>
            <option value="Golden">Golden</option>
        </select>
        <br><br>
        
        <!-- Submit Button -->
        <input type="submit" value="Add Animal" />
    </form>
</body>
</html>
