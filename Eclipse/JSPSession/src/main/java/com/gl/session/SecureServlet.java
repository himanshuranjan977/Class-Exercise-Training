package com.gl.session;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SecureServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            HttpSession session = req.getSession();
            String loginUser = (String) session.getAttribute("loginuser");

            if (loginUser == null) {
                res.sendRedirect("login.jsp");
                return; // stop execution after redirect
            }

            PrintWriter pw = res.getWriter();
            pw.write("I am secure");
            pw.close();

        } catch (Exception ex) {
            System.err.println("Error : " + ex.getMessage());
        }
    }
}