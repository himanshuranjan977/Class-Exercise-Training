package com.gl.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProductUpdateServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            // 1. Read updated product data from request
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            double discount = Double.parseDouble(req.getParameter("discount"));
            double unit = Double.parseDouble(req.getParameter("unit"));

            // 2. Database connection
            String url = "jdbc:mysql://localhost:3306/wipro_2025_java_web";
            String username = "root";
            String password = "Ashu@0812";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            // 3. SQL Update query
            String sql = "UPDATE product SET name=?, price=?, discount=?, unit=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setDouble(3, discount);
            ps.setDouble(4, unit);
            ps.setInt(5, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("No product found with id: " + id);
            }

            // 4. Redirect back to product list page
            res.sendRedirect("product-list");

            con.close();

        } catch (Exception ex) {
            System.out.println("Error in ProductUpdateServlet : " + ex.getMessage());
        }
    }
}
