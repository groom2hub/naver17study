<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Get all cookies from the request
    Cookie[] cookies = request.getCookies();
    
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            String name = cookies[i].getName();
            if (name.equals("loginok")) {
                Cookie loginCookie = cookies[i];
                loginCookie.setPath("/");
                loginCookie.setMaxAge(0);
                response.addCookie(loginCookie);
                break;
            }
        }
    }
    
    response.sendRedirect("./cookiemain.jsp");
%>
