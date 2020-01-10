package cn.yunhe.services;

import cn.yunhe.beans.User;
import cn.yunhe.services.impl.UserSerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OptionServlet extends HttpServlet {
    private UserSerImpl us = new UserSerImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        int result = -1;
        String option = request.getParameter("option");
        if ("del".equals(option)) {
            delServlet(result, request, response, session);
        } else if ("add".equals(option)) {
            creatUserServlet(result, request, response, session);
        } else if ("update".equals(option)) {
            User user = creatUser(request);
            result = us.updateUser(user);
            if (1 == result) {
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("./option/update.jsp");
            }
        }
    }

    /**
     * 创建对象返回结果
     *
     * @param request
     * @return
     */
    public User creatUser(HttpServletRequest request) {
        User user = new User();
        int userId = Integer.parseInt(request.getParameter("userId"));
        user.setUserId(userId);
        user.setUserName(request.getParameter("userName"));
        user.setUserSex(request.getParameter("userSex"));
        user.setUserPhone(request.getParameter("userPhone"));
        user.setUserPassWord(request.getParameter("userPassword"));
        return user;
    }

    public void delServlet(int result, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String userId = request.getParameter("userId");
        result = us.delUser(userId);
        if (1 == result) {
            response.sendRedirect("../index.jsp");
        } else {
            session.setAttribute("msg", "删除失败");
        }
    }

    public void creatUserServlet(int result, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        //获取User属性
        User user = creatUser(request);
        result = us.addUser(user);
        if (1 == result) {
            response.sendRedirect("../index.jsp");
        } else {
            response.sendRedirect("addUser.jsp");
        }
    }
}
