<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String chksave = request.getParameter("chksave");
    String myid = request.getParameter("myid");
    String mypass = request.getParameter("mypass");

    if (myid.equals("angel") && mypass.equals("1234")) {
        if (chksave != null) {
            session.setAttribute("myid", myid);
            session.setAttribute("chksave", "yes");			
        } else {
            session.removeAttribute("chksave");
            session.removeAttribute("myid");
        }
        session.setAttribute("loginok", "yes");

        session.setMaxInactiveInterval(60 * 60);

        response.sendRedirect("./sessionmain.jsp");
    } else {
%>
        <script>
            alert("아이디와 비밀번호가 맞지 않습니다.");
            history.back();
        </script>
<%
    }
%>
