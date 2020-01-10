<%@ page import="cn.yunhe.beans.User" %>
<%@ page import="cn.yunhe.services.Userservice" %>
<%@ page import="cn.yunhe.services.impl.UserSerImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/24
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户显示</title>
</head>
<body>
<%
    //获取所有的用户
    Userservice usi = new UserSerImpl();
    List<User> list = usi.queryUserList();
%>
<table border="1px" cellpadding="0" cellspacing="0" width="50%" align="center">
    <tr style="text-align: center">
        <td>用户Id</td>
        <td>用户名</td>
        <td>用户性别</td>
        <td>手机号</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <%
        if (list != null) {
            for (User u : list) {

    %>
    <tr style="text-align: center">
        <td><%=u.getUserId()%>
        </td>
        <td><%=u.getUserName()%>
        </td>
        <td><%=u.getUserSex()%>
        </td>
        <td><%=u.getUserPhone()%>
        </td>
        <td><%=u.getUserPassWord()%>
        </td>
        <td>
            <a href="OptionServlet?option=del&userId=<%=u.getUserId()%>">删除</a>
            <a href="option/update.jsp?option=update&userId=<%=u.getUserId()%>">修改</a>
        </td>
    </tr>
    <%
            }
        }
    %>

</table>
<button><a href="option/addUser.jsp">添加</a></button>
</body>
</html>
