<%@ page import="cn.yunhe.beans.PageInfo" %>
<%@ page import="cn.yunhe.beans.User" %>
<%@ page import="cn.yunhe.services.Userservice" %>
<%@ page import="cn.yunhe.services.impl.UserSerImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    Userservice usi = new UserSerImpl();
    PageInfo pageInfo = new PageInfo();
    //初始化页码为1
    int pageIndex = 1;
    //获取显示页面a标签的pageIndex
    String index = request.getParameter("pageIndex");
    if (index != null) {
        pageIndex = Integer.parseInt(index);
    }
    //每页显示3条
    int pageSize = 3;
    //获取总条数
    int count = usi.getCount();

    pageInfo.setCount(count);
    pageInfo.setList(usi.queryByPageIndex(pageIndex, pageSize));
    pageInfo.setPageIndex(pageIndex);
    pageInfo.setPageSize(pageSize);
    //将对象放入session域中
    session.setAttribute("pageInfo", pageInfo);
    request.setCharacterEncoding("utf-8");
    UserSerImpl us = new UserSerImpl();
    int result = -1;
    String option = request.getParameter("option");
    if ("del".equals(option)) {
        String userId = request.getParameter("userId");
        result = us.delUser(userId);
        if (1 == result) {
            response.sendRedirect("../index.jsp");
            return;
        } else {
            out.print("删除失败");
        }
    } else if ("add".equals(option)) {
        //获取User属性
        User user = new User();
        int userId = Integer.parseInt(request.getParameter("userId"));
        user.setUserId(userId);
        user.setUserName(request.getParameter("userName"));
        user.setUserSex(request.getParameter("userSex"));
        user.setUserPhone(request.getParameter("userPhone"));
        user.setUserPassword(request.getParameter("userPassword"));
        result = us.addUser(user);
        if (1 == result) {
            response.sendRedirect("../index.jsp");
        } else {
            response.sendRedirect("addUser.jsp");
        }
    } else if ("update".equals(option)) {
        User user = new User();
        int userId = Integer.parseInt(request.getParameter("userId"));
        user.setUserId(userId);
        user.setUserName(request.getParameter("userName"));
        user.setUserSex(request.getParameter("userSex"));
        user.setUserPhone(request.getParameter("userPhone"));
        user.setUserPassword(request.getParameter("userPassword"));
        result = us.addUser(user);
        if (1 == result) {
            response.sendRedirect("../index.jsp");
        } else {
            response.sendRedirect("update.jsp");
        }
    } else {
        response.sendRedirect("../index.jsp");
    }

%>
