<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/17
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<c:if test="${not empty msg}">
    <p style="color: red">${msg}</p>
</c:if>
<form action="loginServlet" method="post">
    userPhone: &nbsp; &nbsp; &nbsp;<input type="text" name="userPhone"/><br>
    userPassword: <input type="password" name="pwd"/><br>
    <input type="submit" value="login">
    <c:remove var="msg"/>
</form>
</body>
</html>
