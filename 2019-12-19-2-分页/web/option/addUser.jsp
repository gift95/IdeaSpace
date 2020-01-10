<%@ page import="cn.yunhe.beans.User" %>
<%@ page import="cn.yunhe.service.impl.UserSerImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="CUD.jsp?option=add" method="post">
    <table border="1px" cellpadding="0" cellspacing="0" width="50%" align="center">
        <tr style="text-align: center">
            <td>用户Id</td>
            <td>用户名</td>
            <td>用户性别</td>
            <td>手机号</td>
            <td>密码</td>
        </tr>
        <tr style="text-align: center">
            <td><input type="text" name="userId">
            </td>
            <td><input type="text" name="userName">
            </td>
            <td><input type="text" name="userSex">
            </td>
            <td><input type="text" name="userPhone">
            </td>
            <td><input type="text" name="userPassword">
            </td>
        </tr>
</table>
<button type="submit">提交</button>
</form>
