package cn.yunhe.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FilterServlet extends HttpServlet {

    public FilterServlet() {
        System.out.println("---FilterServlet--构造器");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        //req.setCharacterEncoding("utf-8");
        String uname = req.getParameter("uname");
        System.out.println("uname=" + uname);
        resp.setContentType("text/html;charset=utf-8");
        //获取PrintWriter对象
        PrintWriter out = resp.getWriter();
        out.write("<html>");
        out.write("<head></head>");
        out.write("<body>");
        out.write(uname);
        out.write("</body>");
        out.write("</html>");
        out.close();
    }

    @Override
    public void destroy() {
        System.out.println("---FilterServlet--destory");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("---FilterServlet--init");
        super.init();
    }
}
