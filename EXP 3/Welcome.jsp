<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%
    HttpSession session = request.getSession(false);
    String username = (String) session.getAttribute("username");

    if (username != null) {
%>
        <h1>Welcome, <%= username %>!</h1>
        <p>Session Creation Time: <%= new java.util.Date(session.getCreationTime()) %></p>
        <p>Session Last Accessed Time: <%= new java.util.Date(session.getLastAccessedTime()) %></p>
        <p>Session will expire after: <%= session.getMaxInactiveInterval() / 60 %> minutes</p>
        <a href="LogoutServlet">Logout</a>
<%
    } else {
        response.sendRedirect("login.jsp");
    }
%>
