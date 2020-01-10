package cn.yunhe.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterTest2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("--FilterTest2--init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--FilterTest2--doFilter--start");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("--FilterTest2--doFilter--end");
    }

    @Override
    public void destroy() {
        System.out.println("--FilterTest2--destroy");
    }
}
