<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="memo.data.MemoDao, memo.data.MemoDto" %>

<%
    String avata = request.getParameter("avata");
    String nickname = request.getParameter("nickname");
    String message = request.getParameter("message");

    MemoDto dto = new MemoDto();
    dto.setAvata(avata);
    dto.setNickName(nickname);
    dto.setMessage(message);

    MemoDao dao = new MemoDao();
    dao.insertMemo(dto);
%>

<data>
    <result><%= nickname %>님의 메모가 DB에 추가되었습니다.</result>
</data>
