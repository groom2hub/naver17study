<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String amho = request.getParameter("amho");
    
    if (amho != null && amho.equals("bitcamp")) {
        Cookie cookie = new Cookie("loginok", amho);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);

        response.sendRedirect("./cookiemain.jsp");
    } else {
%>
        <script>
            alert("암호가 맞지 않습니다");
            history.back();
        </script>
<%
    }
%>
