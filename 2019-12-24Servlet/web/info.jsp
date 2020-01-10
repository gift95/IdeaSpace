<%--@elvariable id="user" type="cn.yunhe.beans.User"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty user.userName}">
    <c:redirect url="login.jsp"/>
</c:if>
你好 &nbsp;${user.userName};<br>
你的密码是 :${user.userPassWord}<br>
<br>
欢迎来到我的世界;<br>
<button><a href="login.jsp?option=remove" style="text-decoration: none">点击注销登陆</a></button>
</body>
</html>
