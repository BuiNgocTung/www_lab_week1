<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/22/2023
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
<h1>Trang Dashboard</h1>

<c:if test="${sessionScope.loggedIn == true}">
    <p>Xin chào, ${sessionScope.userEmail}!</p>
    <!-- Hiển thị nút Logout -->
    <form action="ControlServlet" method="post">
        <input type="hidden" name="action" value="logout">
        <button type="submit">Đăng Xuất</button>
    </form>

    <!-- Hiển thị nội dung Dashboard -->
    <!-- Đặt nội dung của trang Dashboard ở đây -->
</c:if>

<c:if test="${sessionScope.loggedIn != true}">
    <p>Vui lòng đăng nhập để truy cập trang này.</p>
    <a href="index.jsp">Đăng Nhập</a>
</c:if>
</body>
</html>

