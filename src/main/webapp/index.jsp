<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đăng Nhập</title>
</head>
<body>
<h1>Đăng Nhập</h1>

<form action="ControlServlet" method="post">
	<input type="hidden" name="action" value="login">
	<label for="email">Email:</label>
	<input type="text" id="email" name="email" required><br>
	<label for="password">Mật Khẩu:</label>
	<input type="password" id="password" name="password" required><br>
	<button type="submit">Đăng Nhập</button>
</form>

<!-- Hiển thị thông báo lỗi nếu có -->
<c:if test="${param.error == 'true'}">
	<p style="color: red;">Sai tài khoản hoặc mật khẩu.</p>
</c:if>
</body>
</html>
