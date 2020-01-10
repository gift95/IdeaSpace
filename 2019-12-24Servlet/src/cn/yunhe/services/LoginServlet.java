package cn.yunhe.services;

import cn.yunhe.beans.User;
import cn.yunhe.util.JDBCUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        //获取用户名和密码
        String userPhone = request.getParameter("userPhone");
        String pwd = request.getParameter("pwd");
        /**
         * 调用JDBCUtil中的查询方法返回一个User对象
         */
        User user = JDBCUtil.quire("select * from usertable where userPhone = ? and userPassword = ?;", userPhone, pwd);
        /**
         * 判断是否得到对象
         */
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        //设置session失效时间为30s
        session.setMaxInactiveInterval(30);
        if ("remove".equals(request.getParameter("option"))) {
            session.removeAttribute("user");
        }
        if (user == null) {
            session.setAttribute("msg", "账号密码错误");
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("info.jsp");
        }
    }
}
