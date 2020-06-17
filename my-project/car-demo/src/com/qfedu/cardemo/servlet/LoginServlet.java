package com.qfedu.cardemo.servlet;


import com.qfedu.cardemo.entity.User;
import com.qfedu.cardemo.service.UserService;
import com.qfedu.cardemo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//接收登录请求的Servlet
@WebServlet("/user/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("user");
        String pwd = req.getParameter("pw");
        String code = req.getParameter("code");

        //正确的验证码
        String realCode = req.getSession().getAttribute("code").toString();
        if(realCode.equalsIgnoreCase(code)){
           //判断用户名密码
            UserService userService = new UserServiceImpl();
            User loginUser = new User();
            loginUser.setUserName(name);
            loginUser.setPassword(pwd);

            try {
                User user = userService.login(loginUser);
                if(user!=null){
                  //登录成功把用户信息存在Session中
                  req.getSession().setAttribute("curr_user",user);
                  resp.sendRedirect("/car/list.do");
                  req.getSession().removeAttribute("code");//移除code验证码
                }else{
                    //登录失败
                    req.getSession().setAttribute("msg","账号或密码错误!");
                    resp.sendRedirect("/login.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
                req.getSession().setAttribute("msg","服务器繁忙!");
                resp.sendRedirect("/login.jsp");
            }
        }else{
            req.getSession().setAttribute("msg","验证码错误!");
            resp.sendRedirect("/login.jsp");
        }
    }
}
