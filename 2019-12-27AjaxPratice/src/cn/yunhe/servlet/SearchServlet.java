package cn.yunhe.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String search = req.getParameter("search");
        //根据获取到的值在数据库中做模糊查询，将数据返回
        switch (search) {
            case "aa":
                out.print("aa,aab,baab");
                break;
            case "ab":
                out.print("aba,abab,babab");
                break;
            default:
                out.print("fail");
                break;
        }
        out.close();
    }
}
