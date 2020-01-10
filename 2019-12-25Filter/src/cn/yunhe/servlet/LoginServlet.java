package cn.yunhe.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--LoginServlet--doPost");
        String uname = req.getParameter("uname");
        if ("juni".equals(uname)) {
            req.getSession().setAttribute("uname", uname);
            resp.sendRedirect("access/success.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}
