<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // session variable called "loginuser"
    String loginUser = (String) session.getAttribute("loginuser");

    if (loginUser == null) {
        response.sendRedirect("login.jsp");
    } else {
        PrintWriter pw = response.getWriter();
        pw.write("testing");
        pw.close();
    }
%>
