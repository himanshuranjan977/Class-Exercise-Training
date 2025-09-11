<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table >
	<tr>
		<th>Name</th>
		<td><%= request.getAttribute("name") %></td>
	</tr>
	<tr>
		<th>Price</th>
		<td><%= request.getAttribute("price") %></td>
	</tr>
	<tr>
		<th>Discount</th>
		<td><%= request.getAttribute("discount") %></td>
	</tr>
	<tr>
		<th>Product Price</th>
		<td><%= request.getAttribute("productPrice") %></td>
	</tr>
	<tr>
		<th>Unit</th>
		<td><%= request.getAttribute("unit") %></td>
	</tr>
	<tr>
		<th>Total</th>
		<td><%= request.getAttribute("productTotal") %></td>
	</tr>
</table>

</body>
</html>