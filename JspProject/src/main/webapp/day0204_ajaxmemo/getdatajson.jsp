<%@ page import="org.json.simple.JSONObject, memo.data.MemoDto, memo.data.MemoDao" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int idx = Integer.parseInt(request.getParameter("idx"));
    MemoDao dao = new MemoDao();
    MemoDto dto = dao.getOneMemo(idx);

    JSONObject ob = new JSONObject();
    ob.put("idx", dto.getIdx());
    ob.put("nickname", dto.getNickName());
    ob.put("avata", dto.getAvata());
    ob.put("message", dto.getMessage());
%>
<%= ob %>
