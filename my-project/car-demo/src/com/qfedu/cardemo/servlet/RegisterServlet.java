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

@WebServlet("/user/reg.do")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("user");
        String pwd = req.getParameter("pw");
        String realpwd = req.getParameter("repwd");
        if(realpwd.equals(pwd)){
            //判断用户名是否存在
            UserService userService = new UserServiceImpl();
            try {
                boolean exsit = userService.checkName(name);
                if(!exsit){
                    //不存在则注册
                    User regUser = new User();
                    regUser.setUserName(name);
                    regUser.setPassword(pwd);
                    int row = userService.register(regUser);
                    if(row>0){
                        //注册成功
                        resp.sendRedirect("/login.jsp");
                    }else{
                        resp.sendRedirect("/register.html");
                    }
                }else {
                    resp.setContentType("text/html;utf-8");
                    resp.getWriter().println("用户名已存在，请直接登录");
                }
            } catch (Exception e) {
                e.printStackTrace();
                resp.getWriter().println("服务器内部错误");
            }
        }else{
            resp.setContentType("text/html;utf-8");
            resp.getWriter().println("密码不一致，请重新输入");
        }
    }
}
