package cn.yunhe.servlet;

import cn.yunhe.beans.User;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jQueryAjaxServlet.do")
public class jQueryAjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");


        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);

        String userJson = JSON.toJSONString(user);

        System.out.println("name=" + name + "--sex=" + sex + "--age=" + age);
        PrintWriter out = resp.getWriter();
        out.print(userJson);
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
