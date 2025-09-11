package com.gl.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnimalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles GET request → just show the form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("animal-add.jsp");
        rd.forward(req, res);
    }

    // Handles POST request → process form
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {

        try {
            // Get parameters from form
            String name = req.getParameter("name");
            String age = req.getParameter("age");
            String color = req.getParameter("color");

            // Debug printing
            System.out.println("Animal Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Color: " + color);

            // Add success message
            req.setAttribute("message", "Animal added successfully!");

            // Forward back to form page
            RequestDispatcher rd = req.getRequestDispatcher("animal-add.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Error occurred: " + e.getMessage());
        }
    }
}


