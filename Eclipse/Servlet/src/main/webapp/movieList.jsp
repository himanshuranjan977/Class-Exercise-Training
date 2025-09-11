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
	
	<table >
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Budget</th>
				<th>Length</th>
				
			</tr>
		</thead>
		<tbody>
			<%
			while(rs.next()){
			%>
				<tr>
					<td><%= rs.getInt("id") %></td>
					<td><%= rs.getString("name") %></td>
					<td><%= rs.getDouble("budget") %></td>
					<td><%= rs.getInt("length") %></td>
					
				</tr>
			<%
			}
			%>	
		</tbody>			
	</table>
</body>
</html>
