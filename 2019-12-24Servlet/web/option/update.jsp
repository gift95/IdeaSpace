<%@ page import="cn.yunhe.beans.User" %>
<%@ page import="cn.yunhe.services.impl.UserSerImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<%
    String userId = request.getParameter("userId");
    UserSerImpl us = new UserSerImpl();
    User user = us.queryUserById(userId);
%>
<form action="CUD.jsp?option=update" method="post">
    <input type="hidden" name="hid" value="<%=request.getParameter("userId")%>"/>>
    <table border="1px" cellpadding="0" cellspacing="0" width="50%" align="center">
        <tr style="text-align: center">
            <td>用户Id</td>
            <td>用户名</td>
            <td>用户性别</td>
            <td>手机号</td>
            <td>密码</td>
        </tr>
        <tr style="text-align: center">
            <td><input type="text" name="userId" value=<%=user.getUserId()%>>
            </td>
            <td><input type="text" name="userName" value=<%=user.getUserName()%>>
            </td>
            <td><input type="text" name="userSex" value=<%=user.getUserSex()%>>
            </td>
            <td><input type="text" name="userPhone" value=<%=user.getUserPhone()%>>
            </td>
            <td><input type="text" name="userPassword" value=<%=user.getUserPassWord()%>>
            </td>
        </tr>
    </table>
    <button type="submit">提交</button>

</form>
</body>
</html>
