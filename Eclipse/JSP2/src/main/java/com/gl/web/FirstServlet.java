package com.gl.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet mapped to a URL pattern
@SuppressWarnings("serial")
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Setting response type
        response.setContentType("text/html");
        
        // Getting PrintWriter object
        PrintWriter pw = response.getWriter();
        
        // Writing response
        pw.write("<h2>I am from servlet Hello  </h2>");
        
        // Closing writer
        pw.close();
    }
}

