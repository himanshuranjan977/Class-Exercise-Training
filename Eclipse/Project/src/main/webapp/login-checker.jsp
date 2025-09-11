<%
    String loginUser = (String) session.getAttribute("loginuser");

    if (loginUser == null) {
        // User not logged in → redirect to login page
        response.sendRedirect("login.jsp");
    }
%>

