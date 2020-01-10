<%@ page import="cn.yunhe.beans.User" %>
<%@ page import="cn.yunhe.utils.JDBCUtil" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/17
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    //获取用户名和密码
    String userPhone = request.getParameter("userPhone");
    String pwd = request.getParameter("pwd");
    /**
     * 调用JDBCUtil中的查询方法返回一个User对象
     */
    User user = JDBCUtil.quire("select * from usertable where userPhone = ? and userPassword = ?;", userPhone, pwd);
    /**
     * 判断是否得到对象 若未得到返回登陆
     */
    if (null != user.getUserPhone()) {
        session.setAttribute("user", user);
        //设置session失效时间为30s
        session.setMaxInactiveInterval(30);
        response.sendRedirect("info.jsp");
    } else {
        session.setAttribute("msg", "账号密码错误");
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>
