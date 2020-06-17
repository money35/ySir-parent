package com.qfedu.cardemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        System.out.println(httpReq.getRequestURL());

        //放行的集合
        List<String> ignore = new ArrayList<>();
        ignore.add("/css/");
        ignore.add("/js/");
        ignore.add("/img/");
        ignore.add("/user/login.do");
        ignore.add("/login.jsp");
        ignore.add("/register.html");
        ignore.add("/reg.do");

        //当前请求是否在白名单内
        boolean isIgnore = false;
        //遍历(直接放行) 白名单
       for (String path : ignore){
           String reqPath = httpReq.getRequestURL().toString();//请求的路径
           if(reqPath.contains(path)){
               isIgnore = true;
               //直接放行，不拦截
               filterChain.doFilter(req,resp);
           }
       }
       //
       if (!isIgnore){
           //处理
           if( ((HttpServletRequest) req).getSession().getAttribute("curr_user") ==null){
           //没有登录 Session内容为努力了，跳转到登录页面
           ((HttpServletResponse) resp).sendRedirect("/login.jsp");
       }else{
               //登录过Session有东西，放行
           }
           filterChain.doFilter(req,resp);
       }

    }

    @Override
    public void destroy() {

    }
}
