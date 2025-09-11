<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator Form</title>
</head>
<body>
   <h2>Simple Calculator</h2>
   <form action="add.jsp" method="get">
      A : <input type="number" name="a" required />
      <br><br>
      B : <input type="number" name="b" required />
      <br><br>
      Choice : 
      <select name="choice" required>
         <option value="1">Addition</option>
         <option value="2">Subtraction</option>
         <option value="3">Multiplication</option>
         <option value="4">Division</option>
      </select>
      <br><br>
      <button type="submit">Calculate</button>
   </form>
</body>
</html>