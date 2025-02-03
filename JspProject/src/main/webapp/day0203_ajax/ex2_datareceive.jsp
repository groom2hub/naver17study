<%@page import="org.json.simple.JSONObject" %>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%
    String myname = request.getParameter("myname");

    JSONObject ob = new JSONObject();
    ob.put("myname", myname);
    ob.put("address", "서울시 강남구");
    ob.put("hp", "010-2222-3333");

    response.setContentType("application/json");
    response.getWriter().write(ob.toString());
%>
