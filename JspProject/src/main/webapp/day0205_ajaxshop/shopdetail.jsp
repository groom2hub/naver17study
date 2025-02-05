<%@page import="java.text.SimpleDateFormat"%>
<%@page import="shop.data.ShopDto"%>
<%@page import="shop.data.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>502 JSP Study</title>
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
        .btn {
            width: 100px;
        }
    </style>
</head>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    ShopDao dao = new ShopDao();
    ShopDto dto = dao.getSangpum(num);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
<div class="modal" id="shopDeleteModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">상품 삭제 확인</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <p>정말로 "<%=dto.getSangpum()%>" 상품을 삭제하시겠습니까?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="confirmDelete">삭제</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
            </div>
        </div>
    </div>
</div>

<div style="margin: 20px; width: 500px;">
    <table class="table">
        <tr>
            <td><img src="<%=dto.getSphoto()%>" width="230" height="300" border="1"></td>
            <td valign="middle">
                <h6>상품명 : <%=dto.getSangpum()%></h6>
                <h6>상품 색상 : <span style="background-color: <%=dto.getScolor()%>"><%=dto.getScolor()%></span></h6>
                <h6>수 량 : <%=dto.getScnt()%>개</h6>
                <h6>단 가 : <%=dto.getSprice()%>원</h6>
                <h6>입고일 : <%=dto.getIpgoday()%></h6>
                <h6>등록일 : <%=sdf.format(dto.getWriteday())%></h6>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="button" class="btn btn-success btn-sm" data-bs-toggle="modal" data-bs-target="#shopUpdateModal">수정</button>
                <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#shopDeleteModal">삭제</button>
                <button type="button" class="btn btn-secondary btn-sm" onclick="location.href='./shopmain.html'">목록</button>
            </td>
        </tr>
    </table>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $('#confirmDelete').click(function() {
            $.ajax({
                type: "get",
                dataType: "html",
                data: {"num": <%=num%>},
                url: "./deleteshop.jsp",
                success: function() {
                    alert("상품이 성공적으로 삭제되었습니다.");
                    location.href = "./shopmain.html";
                },
                error: function() {
                    alert("상품 삭제 중 오류가 발생했습니다.");
                }
            });
        });
    });
</script>
</body>
</html>
