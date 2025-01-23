<%@page import="sawon.data.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
	SawonDao dao = new SawonDao();
	dao.deleteSawon(num);
	response.sendRedirect("./sawonlist.jsp");
%>
