<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>502 JSP Study</title>
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");

        String myid = request.getParameter("myid");
        String mypass = request.getParameter("mypass");
        String myname = request.getParameter("myname");
        String driver = request.getParameter("driver");
        String homeaddr = request.getParameter("homeaddr");
        String myfood = request.getParameter("myfood");
        String fcolor = request.getParameter("fcolor");
        String mybirth = request.getParameter("mybirth");

        String[] hobby = request.getParameterValues("hobby");
    %>

    <div style="font-size: 20px; color:<%= fcolor %>">
        <p>아이디: <%= myid %></p>
        <p>비밀번호: <%= mypass %></p>
        <p>이름: <%= myname %></p>

        <p>운전면허: <%= driver == null ? "없음" : "있음" %></p>

        <p>주거지: <%= homeaddr %></p>

        <p>취미: 
        <%
            if (hobby == null) {
                out.print("<b>없음</b>");
            } else {
                StringBuilder s = new StringBuilder("나의 취미는 ");
                for (String h : hobby) {
                    s.append("[").append(h).append("]");
                }
                s.append("입니다");
                out.print("<b>" + s.toString() + "</b>");
            }
        %>
        </p>

        <p>좋아하는 음식: <img src="../image/food/<%= myfood %>" width="100" height="100" border="1"></p>

        <p>글자 색상: <%= fcolor %></p>
        <p>생년월일: <%= mybirth %></p>
    </div>
</body>
</html>
