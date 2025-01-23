<%@page import="sawon.data.SawonDto"%>
<%@page import="java.util.List"%>
<%@page import="sawon.data.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>502 JSP Study</title>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body {
            font-family: 'Jua';
        }

        .tab th {
            background-color: #ddd;
            text-align: center;
        }

        .tab .photo {
            width: 40px;
            height: 40px;
            border: 1px solid black;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<%
    SawonDao dao = new SawonDao();
    List<SawonDto> list = dao.getAllDatas();
%>
<div style="margin: 30px;">
    <table class="tab table table-bordered" style="width: 450px;">
        <caption align="top">
            <b>[사원목록 (<%= list.size() %>명)]</b>
            <button type="button" class="btn btn-sm btn-success" style="float: right;"
                    onclick="location.href='./sawonform.jsp'">사원등록</button>
        </caption>
        <thead>
            <tr>
                <th width="50">번호</th>
                <th width="150">사원명</th>
                <th width="150">입사일</th>
                <th>상세보기</th>
            </tr>
        </thead>
        <tbody>
        <%
            if (list.isEmpty()) {
        %>
            <tr height="50">
                <td colspan="4" align="center"><b>등록된 사원이 없습니다</b></td>
            </tr>
        <%
            } else {
                int no = 0;
                for (SawonDto dto : list) {
        %>
            <tr align="center">
                <td><%= ++no %></td>
                <td align="left">
                    <img src="<%= dto.getSphoto() %>" class="photo">
                    <%= dto.getSname() %>
                </td>
                <td><%= dto.getIpsaday() %></td>
                <td>
                    <button type="button" class="btn btn-sm btn-info"
                            onclick="location.href='./sawondetail.jsp?num=<%= dto.getNum() %>'">상세보기</button>
                </td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
