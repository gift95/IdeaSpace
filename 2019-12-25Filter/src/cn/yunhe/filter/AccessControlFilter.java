package cn.yunhe.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 页面访问控制过滤器
 * 需求：
 * 依据：如果用户登录成功，则会将用户的信息存储到session域中
 * 在其它页面中去获取session域中存储的用户信息，如果有该信息
 * 就代表用户是已登录的，那么可以访问指定页面，为null就跳转到登录页面
 */
public class AccessControlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("--AccessControlFilter--init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--AccessControlFilter--doFilter");
        //获取session对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        //获取用户输入的用户名和密码
        Object obj = session.getAttribute("uname");
        //判断用户是否已登录，依据：不为null就代表已登录
        if (null != obj) {
            //放过该请求
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("../login.jsp");
        }
    }

    @Override
    public void destroy() {
        System.out.println("--AccessControlFilter--destroy");
    }
}
