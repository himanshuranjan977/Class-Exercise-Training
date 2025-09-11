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

public class ProductDeleteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            // 1. Get product id from request
            int id = Integer.parseInt(req.getParameter("id"));

            // 2. Database connection
            String url = "jdbc:mysql://localhost:3306/wipro_2025_java_web";
            String username = "root";
            String password = "Ashu@0812";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            // 3. SQL Delete query
            String sql = "DELETE FROM product WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("No product found with id: " + id);
            }

            // 4. Redirect back to product list page
            res.sendRedirect("product-list"); // make sure you have a product-list servlet/jsp

            con.close();

        } catch (Exception ex) {
            System.out.println("Error in ProductDeleteServlet : " + ex.getMessage());
        }
    }
}
