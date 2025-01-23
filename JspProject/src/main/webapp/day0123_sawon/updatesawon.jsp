<%@page import="sawon.data.SawonDao"%>
<%@page import="sawon.data.SawonDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    String sname = request.getParameter("sname");
    String sphoto = request.getParameter("sphoto");
    String ipsaday = request.getParameter("ipsaday");
    String sblood = request.getParameter("sblood");
    int sbirth = Integer.parseInt(request.getParameter("sbirth"));

    SawonDto dto = new SawonDto();
    dto.setNum(num);
    dto.setSname(sname);
    dto.setSbirth(sbirth);
    dto.setSblood(sblood);
    dto.setSphoto(sphoto);
    dto.setIpsaday(ipsaday);

    SawonDao dao = new SawonDao();
    dao.updateSawon(dto);

    response.sendRedirect("./sawondetail.jsp?num=" + num);
%>
