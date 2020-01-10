package cn.yunhe.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤字符编码
 */
public class FilterTest implements Filter {

    public FilterTest() {
        System.out.print("---FilterTest--构造器");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("--FilterTest---init--");
    }

    /**
     * 具体的业务处理
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain     doFilter()用于处理请求或响应是否允许通过
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--FilterTest--doFilter--start");
        //System.out.println(((HttpServletRequest)servletRequest).getRequestURI());
        //统一编码处理
        servletRequest.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("--FilterTest--doFilter--end");
    }

    @Override
    public void destroy() {
        System.out.println("--FilterTest---destroy--");
    }
}
