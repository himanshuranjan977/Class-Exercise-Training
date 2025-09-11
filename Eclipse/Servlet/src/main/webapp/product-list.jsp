<%@page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
</head>
<body>
	<%
	ResultSet rs= (ResultSet) request.getAttribute("resultset");
	%>
	
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Discount</th>
				<th>Unit</th>
				<th>Delete</th>
				
				
			</tr>
		</thead>
		<tbody>
			<%
			while(rs.next()){
			%>
				<tr>
					<td><%= rs.getInt("id") %></td>
					<td><%= rs.getString("name") %></td>
					<td><%= rs.getDouble("price") %></td>
					<td><%= rs.getDouble("discount") %></td>
					<td><%= rs.getDouble("unit") %></td>
					<td>
                        <a href="product-edit?id=<%= rs.getInt("id") %>">Edit</a> |
                        <a href="product-delete?id=<%= rs.getInt("id") %>">Delete</a>
                    </td>

					
					
				</tr>
			<%
			}
			%>	
		</tbody>			
	</table>
</body>
</html>