<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/18
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    1、获取用户名和记住密码对应的状态
    2、根据状态判断是否要对用户名进行存储
--%>
<%
    //设置字符编码
    request.setCharacterEncoding("utf-8");
    //获取用户名
    String uname = request.getParameter("uname");
    //获取复选框状态
    String flag = request.getParameter("flag");
    if ("true".equals(flag)) {
        //将用户名存储到本地---cookie，中文编码
        Cookie nameCookie = new Cookie("uname", URLEncoder.encode(uname, "utf-8"));
        //将cookie存储到response中进行返回
        response.addCookie(nameCookie);
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>
