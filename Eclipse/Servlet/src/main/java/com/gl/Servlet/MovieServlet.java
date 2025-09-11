package com.gl.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            // Read inputs
            String name = req.getParameter("name");
            double budget = Double.parseDouble(req.getParameter("budget"));
            int length = Integer.parseInt(req.getParameter("length"));

            String url = "jdbc:mysql://localhost:3306/wipro_2025_java_web";
            String username = "root";
            String password = "Ashu@0812";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);

                String insertSql = "INSERT INTO Movie (name, budget, length) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(insertSql);

                ps.setString(1, name);
                ps.setDouble(2, budget);
                ps.setInt(3, length);

                ps.executeUpdate();

                ps.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error in DB action: " + ex.getMessage());
            }

            // Pass data to JSP
            req.setAttribute("name", name);
            req.setAttribute("budget", budget);
            req.setAttribute("length", length);

            RequestDispatcher rd = req.getRequestDispatcher("displayMovie.jsp");
            rd.forward(req, res);

        } catch (NumberFormatException e) {
            e.printStackTrace(); // invalid number input
        }
    }
}
