<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đăng Nhập</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
		  integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script>
</head>
<body>
<h1>Đăng Nhập</h1>

<form action="action" method="get">
	<input type="hidden" name="action" value="login">
	<label for="email">Email:</label>
	<input type="text" id="email" name="email" required><br>
	<label for="password">Mật Khẩu:</label>
	<input type="password" id="password" name="psw" required><br>
	<button type="submit" name="login">Đăng Nhập</button>
</form>


</body>
</html>
