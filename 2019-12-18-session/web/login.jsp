<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/17
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
    判断用户是否已存储了用户名，如果有就在用户名一栏显示，没有就不显示
--%>
<%
    out.println(session.getId());
    String uname = "";
    //获取所有的cookie
    Cookie[] cookies = request.getCookies();
    if (null != cookies) {
        //遍历找到对应的用户名
        for (Cookie cookie : cookies) {
            //获取key
            String key = cookie.getName();
            if ("uname".equals(key)) {
                //cookie获取值，对中文进行解码操作
                uname = URLDecoder.decode(cookie.getValue(), "utf-8");
                System.out.println("uname=" + uname);
            }
        }
    }
%>
<form action="SessionDemo.jsp" method="post">
    username：<input type="text" name="uname" value="<%=uname%>"/><br/>
    password：<input type="password" name="pwd"/><br/>
    <input type="checkbox" name="flag" value="true"/>记住密码<br/>
    <input type="submit" value="login">
</form>
</body>
</html>
