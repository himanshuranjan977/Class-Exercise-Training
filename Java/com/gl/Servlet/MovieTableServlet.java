package com.gl.Servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieTableServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String url="jdbc:mysql://localhost:3306/wipro_2025_java_web";
			String username="root";
			String password="Ashu@0812";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			String selectSql="select * from Movie";
			
			Statement stmt= con.createStatement();
			ResultSet rs= stmt.executeQuery(selectSql);
			
			req.setAttribute("resultset",rs);
			RequestDispatcher rd=req.getRequestDispatcher("movieList.jsp");
			rd.forward(req,res);
		}
		catch(Exception ex) {
			System.err.println("Error in productviewservlet : "+ex.getMessage());
		}
	}
	
	

}


