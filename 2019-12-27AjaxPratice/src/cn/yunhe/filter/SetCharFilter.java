package cn.yunhe.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetCharFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
