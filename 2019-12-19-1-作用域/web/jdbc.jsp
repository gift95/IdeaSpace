<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //注册驱动
    Class.forName("com.mysql.jdbc.Driver");
    /**
     * 定义数据库位置
     */
    String URL = "jdbc:mysql://localhost:3306/dataemp?useUnicode=true&characterEncoding=utf8";
    /**
     * 定义常量数据库用户名
     */
    String USER = "root";
    /**
     *定义常量数据库密码
     */
    String PASSWORD = "0000";
    Connection con = null;
    try {
        con = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    out.print(con);

%>
</body>
</html>
