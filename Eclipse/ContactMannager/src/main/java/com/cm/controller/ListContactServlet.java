package com.cm.controller;

import com.cm.store.ContactStore;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class ListContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("contacts", ContactStore.getInstance().findAll());
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
