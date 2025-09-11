package com.cm.controller;

import com.cm.model.Contact;
import com.cm.store.ContactStore;

import javax.servlet.ServletException;

import javax.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")

public class EditContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        ContactStore store = ContactStore.getInstance();

        try {
            int id = Integer.parseInt(idStr);
            Contact c = store.findById(id);
            if (c == null) {
                setFlash(req, "flashError", "Contact not found.");
                resp.sendRedirect(req.getContextPath() + "/list");
                return;
            }
            req.setAttribute("contact", c);
            req.getRequestDispatcher("/edit.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            setFlash(req, "flashError", "Invalid contact id.");
            resp.sendRedirect(req.getContextPath() + "/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        String name = trim(req.getParameter("name"));
        String phone = trim(req.getParameter("phone"));
        String email = trim(req.getParameter("email"));

        try {
            int id = Integer.parseInt(idStr);

            if (isBlank(name) || isBlank(phone) || isBlank(email)) {
                req.setAttribute("error", "All fields are required.");
                Contact existing = new Contact(id, name, phone, email);
                req.setAttribute("contact", existing);
                req.getRequestDispatcher("/jsp/edit.jsp").forward(req, resp);
                return;
            }

            Contact updated = new Contact(id, name, phone, email);
            boolean ok = ContactStore.getInstance().update(updated);

            if (ok) {
                setFlash(req, "flashSuccess", "Contact updated successfully.");
            } else {
                setFlash(req, "flashError", "Contact not found.");
            }
            resp.sendRedirect(req.getContextPath() + "/list");

        } catch (NumberFormatException e) {
            setFlash(req, "flashError", "Invalid contact id.");
            resp.sendRedirect(req.getContextPath() + "/list");
        }
    }

    private static void setFlash(HttpServletRequest req, String key, String msg) {
        req.getSession().setAttribute(key, msg);
    }
    private static String trim(String s) { return s == null ? null : s.trim(); }
    private static boolean isBlank(String s) { return s == null || s.trim().isEmpty(); }
}

