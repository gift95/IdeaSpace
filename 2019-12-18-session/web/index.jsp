<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/18
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ti</title>
</head>
<body>
<%
    Object obj = application.getAttribute("count");
    int count;
    if (obj == null) {
        count = 1;
    } else {
        count = (Integer) obj;
        count++;
    }
    application.setAttribute("count", count);
%>
访问次数<%=obj%>
</body>
</html>
