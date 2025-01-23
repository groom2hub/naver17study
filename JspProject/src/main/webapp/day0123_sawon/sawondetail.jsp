<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="sawon.data.SawonDto"%>
<%@page import="sawon.data.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
        .btn {
            width: 90px;
        }
        .employee-photo {
            width: 250px;
        }
    </style>
</head>
<body>
<div style="margin: 20px;">
    <%
        String num = request.getParameter("num");
        if (num == null || num.trim().isEmpty()) {
            out.println("<h3>Error: Invalid employee ID.</h3>");
            return;
        }

        SawonDao dao = new SawonDao();
        SawonDto dto = dao.getSawon(num);

        if (dto == null) {
            out.println("<h3>Error: Employee not found.</h3>");
            return;
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    %>
    <h3><b>[<%=dto.getSname()%>] Employee Details</b></h3>
    <img src="<%=dto.getSphoto() %>" class="employee-photo" alt="Employee Photo" align="left" hspace="10" border="2">
    <br><br><br>
    <h5>Joining Date: <%=dto.getIpsaday() %></h5>
    <h5>Age: <%=currentYear - dto.getSbirth()%> years (<%=dto.getSbirth()%> born)</h5>
    <h5>Blood Type: <%=dto.getSblood()%></h5>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    %>
    <h5>Registration Date: <%=sdf.format(dto.getWriteday()) %></h5>
</div>
<div style="margin-left: 50px;">
    <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='./sawonform.jsp'">Register</button>
    <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='./sawonlist.jsp'">List</button>
    <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='./updateform.jsp?num=<%=dto.getNum()%>'">Edit</button>
    <button type="button" class="btn btn-sm btn-outline-secondary" onclick="deleteEmployee(<%=dto.getNum()%>)">Delete</button>

    <script type="text/javascript">
        function deleteEmployee(num) {
            let confirmation = confirm("Are you sure you want to delete this employee?");
            if (confirmation) {
                location.href = "./sawondel.jsp?num=" + num;
            }
        }
    </script>
</div>
</body>
</html>
