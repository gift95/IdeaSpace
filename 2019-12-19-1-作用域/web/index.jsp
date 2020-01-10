<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //设置属性
    pageContext.setAttribute("pageContext", "pageVal");
    request.setAttribute("request", "requestVal");
    session.setAttribute("session", "sessionVal");
    request.getRequestDispatcher("other.jsp").forward(request, response);
%>
pageContext：<%=pageContext.getAttribute("pageContext")%><br>
request:<%=request.getAttribute("request")%><br>
session:<%=session.getAttribute("session")%>
</body>
</html>
