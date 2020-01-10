<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<%
    String count = "sout";
    session.setAttribute("count", count);
%>
${count}1212122
<c:choose>

</c:choose>
</body>
</html>
