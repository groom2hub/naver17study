<%@page import="sawon.data.SawonDao"%>
<%@page import="sawon.data.SawonDto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    try {
        String sname = request.getParameter("sname");
        String sphoto = request.getParameter("sphoto");
        String ipsaday = request.getParameter("ipsaday");
        String sblood = request.getParameter("sblood");
        int sbirth = Integer.parseInt(request.getParameter("sbirth"));

        if (sname == null || sname.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }

        SawonDto dto = new SawonDto();
        dto.setSname(sname);
        dto.setSphoto(sphoto);
        dto.setIpsaday(ipsaday);
        dto.setSbirth(sbirth);
        dto.setSblood(sblood);

        SawonDao dao = new SawonDao();
        dao.insertSawon(dto);

        response.sendRedirect("./sawonlist.jsp");
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>
