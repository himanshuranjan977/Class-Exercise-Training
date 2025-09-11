package com.gl.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProductEditServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            // 1. Read product id from request
            int id = Integer.parseInt(req.getParameter("id"));

            // 2. Database connection
            String url = "jdbc:mysql://localhost:3306/wipro_2025_java_web";
            String username = "root";
            String password = "Ashu@0812";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            // 3. SQL query
            String sql = "SELECT * FROM product WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            String name="";
            double price =0;
            double discount =0;
            double unit =0;

            while(rs.next()) {
                // 4. Extract product details
                name = rs.getString("name");
                price = rs.getDouble("price");
                discount = rs.getDouble("discount");
                unit = rs.getDouble("unit");

                // 5. Put data into request attributes
                req.setAttribute("id", id);
                req.setAttribute("name", name);
                req.setAttribute("price", price);
                req.setAttribute("discount", discount);
                req.setAttribute("unit", unit);

                // 6. Forward to JSP form
                RequestDispatcher rd = req.getRequestDispatcher("product-edit.jsp");


                rd.forward(req, res);
            }

            

        } catch (Exception ex) {
            System.out.println("Error in ProductEditServlet : " + ex.getMessage());
        }
    }
}

