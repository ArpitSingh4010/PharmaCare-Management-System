<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    // Session validation for protected pages
    HttpSession userSession = request.getSession(false);
    String currentUser = null;
    
    if (userSession != null) {
        currentUser = (String) userSession.getAttribute("currentuser");
    }
    
    // If no session or no user, redirect to login
    if (userSession == null || currentUser == null || currentUser.trim().isEmpty()) {
        response.sendRedirect("Login.html");
        return;
    }
    
    // Optional: Check session timeout (30 minutes)
    userSession.setMaxInactiveInterval(30 * 60);
%>
