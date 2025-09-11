package com.cm.controller;

import com.cm.store.ContactStore;

import javax.servlet.ServletException;

import javax.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")

public class DeleteContactServlet extends HttpServlet {

    // For simplicity allow GET; for production prefer POST/DELETE with CSRF protection
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        try {
            int id = Integer.parseInt(idStr);
            boolean removed = ContactStore.getInstance().delete(id);
            if (removed) {
                req.getSession().setAttribute("flashSuccess", "Contact deleted.");
            } else {
                req.getSession().setAttribute("flashError", "Contact not found.");
            }
        } catch (NumberFormatException e) {
            req.getSession().setAttribute("flashError", "Invalid contact id.");
        }
        resp.sendRedirect(req.getContextPath() + "/list");
    }
}

