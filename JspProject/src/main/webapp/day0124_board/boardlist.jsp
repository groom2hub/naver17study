<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>502 JSP Study</title>
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }

        .tabboard th {
            background-color: orange;
        }

        .btn {
            width: 100px;
        }
    </style>
</head>
<body>
<div class="container mt-5" style="max-width: 400px;">
    <form action="./insertaction.jsp" method="post">
        <table class="table table-bordered tabboard">
            <caption class="text-center mb-2">
                <h5><strong>글쓰기</strong></h5>
            </caption>
            <tr>
                <th scope="row" style="width: 100px;">작성자</th>
                <td>
                    <input type="text" name="writer" class="form-control" autofocus required>
                </td>
            </tr>
            <tr>
                <th scope="row">제목</th>
                <td>
                    <input type="text" name="subject" class="form-control" required>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea name="content" class="form-control" style="height: 150px;" required></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="text-center">
                    <button type="submit" class="btn btn-sm btn-outline-secondary">글저장</button>
                    <button type="reset" class="btn btn-sm btn-outline-secondary">초기화</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary" onclick="history.back()">취소</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
