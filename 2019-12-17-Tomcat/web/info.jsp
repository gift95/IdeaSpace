<%@ page import="cn.yunhe.beans.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/17
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object obj = application.getAttribute("count");
    int count = 0;
    if (obj == null) {
        count = 1;
    } else {
        count = (Integer) obj;
        count++;
    }
    application.setAttribute("count", count);
    User user = (User) session.getAttribute("user");
%>
访问次数<%=count%>
你好 &nbsp;<%=user.getUserName()%>;<br>
你的密码是 :<%=user.getUserPassWord()%><br>
<br>
欢迎来到我的世界;<br>
<button><a href="hello.html" style="text-decoration: none">点击进入新世界</a></button>
<button><a href="login.jsp" style="text-decoration: none">点击注销登陆</a></button>
</body>
</html>
