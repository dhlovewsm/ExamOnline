<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/22
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
<form action="/applicant/login" method="post">
    username:<input type="text" name="applicantAccount"><p>
    password:<input type="password" name="applicantPassword">
    <input type="submit">
    <p>
        <span>${sessionScope.errorMessage}</span>
</form>
</body>
</html>
