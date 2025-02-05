<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.text.SimpleDateFormat, org.json.simple.JSONObject, org.json.simple.JSONArray, shop.data.ShopDto, java.util.List, shop.data.ShopDao" %>

<%
    int order = Integer.parseInt(request.getParameter("order"));
    ShopDao dao = new ShopDao();
    List<ShopDto> list = dao.getAllSangpums(order);

    JSONArray arr = new JSONArray();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    for (ShopDto dto : list) {
        JSONObject ob = new JSONObject();
        ob.put("num", dto.getNum());
        ob.put("sangpum", dto.getSangpum());
        ob.put("scolor", dto.getScolor());
        ob.put("scnt", dto.getScnt());
        ob.put("sprice", dto.getSprice());
        ob.put("sphoto", dto.getSphoto());
        ob.put("ipgoday", dto.getIpgoday());
        ob.put("writeday", sdf.format(dto.getWriteday()));
        
        arr.add(ob);
    }
%>
<%= arr %>
