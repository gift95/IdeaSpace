<%@ page import="cn.yunhe.beans.PageInfo" %>
<%@ page import="cn.yunhe.beans.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户显示</title>
</head>
<body>
<%
    Object obj = session.getAttribute("pageInfo");
    //如果obj为空跳转到CUD.jsp页面
    if (null == obj) {
        response.sendRedirect("./option/CUD.jsp");
        return;
    }
    PageInfo pageInfo = (PageInfo) obj;
    //获取当前的页码数
    int pageIndex = pageInfo.getPageIndex();
    int pageCount = pageInfo.getPageCount();
    List<User> list = (List<User>) pageInfo.getList();
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
        <td><%=u.getUserPassword()%>
        </td>
        <td>
            <a href="./option/CUD.jsp?option=del&userId=<%=u.getUserId()%>">删除</a>
            <a href="./option/update.jsp?option=update&userId=<%=u.getUserId()%>">修改</a>
        </td>
    </tr>
    <%
            }
        }
    %>

</table>
<div id="page" style="text-align: center">
    <%
        if (pageIndex != 1) {
    %>

    <a href="./option/CUD.jsp?pageIndex=<%=pageIndex-1%>">上一页</a>
    <%
        }
        for (int i = 0; i < pageCount; i++) {
    %>
    <a href="./option/CUD.jsp?pageIndex=<%=i+1%>" style="color:black;background:white;"><%=i + 1%>
    </a>
    <%
        }
        if (pageIndex != pageCount) {
    %>

    <a href="./option/CUD.jsp?pageIndex=<%=pageIndex+1%>">下一页</a>
    <%
        }
    %>
</div>
<button><a href="option/addUser.jsp">添加</a></button>
</body>
</html>
