<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/20
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //获取图片的相对路径地址
    String picPath = (String) session.getAttribute("picPath");
%>
<img src="<%=picPath%>">
</body>
</html>
