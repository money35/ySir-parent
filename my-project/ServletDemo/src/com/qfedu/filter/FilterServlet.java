package com.qfedu.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init初始化");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");

        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy损毁");
    }
}
