package com.cm.controller;

import com.cm.model.Contact;
import com.cm.store.ContactStore;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AddContactServlet extends HttpServlet {
    private static final long serialVersionUID = -4593465619540137223L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = trim(req.getParameter("name"));
        String phone = trim(req.getParameter("phone"));
        String email = trim(req.getParameter("email"));

        // Simple validation
        if (isBlank(name) || isBlank(phone) || isBlank(email)) {
            req.setAttribute("error", "All fields are required.");
            req.setAttribute("prefillName", name);
            req.setAttribute("prefillPhone", phone);
            req.setAttribute("prefillEmail", email);
            req.getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
            return;
        }

        ContactStore.getInstance().add(new Contact(name, phone, email));

        // Flash success message
        HttpSession session = req.getSession();
        session.setAttribute("flashSuccess", "Contact added successfully.");
        resp.sendRedirect(req.getContextPath() + "/list");
    }

    private static String trim(String s) { return s == null ? null : s.trim(); }
    private static boolean isBlank(String s) { return s == null || s.trim().isEmpty(); }
}
