<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculation Result</title>
</head>
<body>
  <%
    int a = Integer.parseInt(request.getParameter("a"));
    int b = Integer.parseInt(request.getParameter("b"));
    int choice = Integer.parseInt(request.getParameter("choice"));
    int c = 0;

    if (choice == 1) {
        c = a + b;
        out.print("Answer (Addition): " + c);
    } else if (choice == 2) {
        c = a - b;
        out.print("Answer (Subtraction): " + c);
    } else if (choice == 3) {
        c = a * b;
        out.print("Answer (Multiplication): " + c);
    } else if (choice == 4) {
        if (b != 0) {
            double d = (double)a / b;
            out.print("Answer (Division): " + d);
        } else {
            out.print("Error: Division by zero!");
        }
    } else {
        out.print("Invalid Choice!");
    }
  %>
</body>
</html>
