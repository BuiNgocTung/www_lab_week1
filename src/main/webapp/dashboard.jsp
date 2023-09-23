<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/23/2023
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
</head>
<body>
<section class="container ">

<%--menu admin--%>
<div class="navbar bg-light navbar-expand-md">

    <ul class="nav navbar-nav col-md-7">
        <li class="nav-item"><a href="" class="nav-link"> Account</a></li>
        <li class="nav-item"><a href="" class="nav-link"> Role</a></li>
        <li class="nav-item"><a href="" class="nav-link"> Profile</a></li>


    </ul>
    <ul class="nav navbar-expand col-2">
        <%
            String roleID = request.getAttribute("roleID") + "";
        %>
        <H5 >Hello <%=roleID%></H5>  </ul>
    <ul class="nav navbar-expand col-4">

        <li class="nav-item">
            <button onclick="logout()">Logout</button></li>

    </ul>
</div>

<%--table account--%>
<div class="container mt-5 mx-auto">
    <h1>List Account</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Account id</th>
            <th scope="col">Full Name</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
            <th scope="col">Action</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                String accountID = request.getAttribute("accountID") + "";
            %>
            <td><%=accountID%></td>
            <%
                String fullName = request.getAttribute("fullName") + "";
            %>
            <td><%=fullName%></td>
            <%
                String pwd = request.getAttribute("psw") + "";
            %>
            <td><%=pwd%></td>

            <%
                String phone = request.getAttribute("phone") + "";
            %>
            <td><%=phone%></td>


        </tr>

        </tbody>
    </table>
</div>
</section>
<script>
    function logout() {
        // Thực hiện chuyển hướng đến trang cụ thể (ví dụ: index.jsp)
        window.location.href = "index.jsp";
    }
</script>
</body>
</html>
