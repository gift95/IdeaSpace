<%@ page import="cn.yunhe.beans.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/20
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    User user = new User();
    int userId = Integer.parseInt(request.getParameter("userId"));
    user.setUserId(userId);
    user.setUserName(request.getParameter("userName"));
    user.setUserSex(request.getParameter("userSex"));
    user.setUserPhone(request.getParameter("userPhone"));
    user.setUserPassword(request.getParameter("userPassword"));
    int result = us.addUser(user);
%>