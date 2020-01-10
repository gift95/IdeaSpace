<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/20
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<%
    String msg = "";
    Object obj = session.getAttribute("picMsg");
    String fileSizeMsg = "";
    Object fileObj = session.getAttribute("sizeMsg");
    if (null != obj) {
        msg = (String) obj;
        session.removeAttribute("picMsg");
    }
    if (null != fileObj) {
        fileSizeMsg = (String) fileObj;
        session.removeAttribute("sizeMsg");
    }
%>
<span><%=msg%></span>
<span><%=fileSizeMsg%></span>
<form action="pic-upload.jsp" method="post" enctype="multipart/form-data">
    名字<input type="text" name="uname"><br>
    id:<input type="text" name="uid"><br>
    Sex <input type="text" name="uss"><br>
    PWD<input type="text" name="pwd"><br>
    <input type="file" name="pic">
    <input type="submit" value="提交">
</form>
</body>
</html>
