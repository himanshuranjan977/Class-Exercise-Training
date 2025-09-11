package com.gl.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/student-read")*/
public class StudentReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Read form data
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String mobile = req.getParameter("mobile");
        String email = req.getParameter("email");

        // Log to console (for debugging)
        System.out.println("=== Student Data Received ===");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Mobile : " + mobile);
        System.out.println("Email  : " + email);
        System.out.println("=============================");

        // Set attributes for JSP
        req.setAttribute("name", name);
        req.setAttribute("age", age);
        req.setAttribute("mobile", mobile);
        req.setAttribute("email", email);

        // Forward request to JSP
        RequestDispatcher rd = req.getRequestDispatcher("printstudent.jsp");
        rd.forward(req, res);
    }
}


