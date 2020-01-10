<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/17
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<%
    //获取错误信息
    Object obj = session.getAttribute("msg");
    if (null != obj) {
%>
<p style="color: red;"><%=session.getAttribute("msg")%>
</p>

<%
        session.removeAttribute("msg");
    }
%>
<form action="login_check.jsp" method="post">

    userPhone: &nbsp; &nbsp; &nbsp;<input type="text" name="userPhone"/><br>
    userPassword: <input type="password" name="pwd"/><br>
    <input type="checkbox" name="hobbies" value="basketball"/>篮球<br>
    <input type="checkbox" name="hobbies" value="football"/>足球<br>
    <input type="checkbox" name="hobbies" value="pingpang"/>乒乓<br>
    <input type="submit" value="login">
</form>
</body>
</html>
