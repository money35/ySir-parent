package com.qfedu.cardemo.servlet;


import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//这是一个负责响应一个图片验证码的Servlet
//你请求它，它就响应你一个图片验证码
@WebServlet("/img/pic.do")
public class CaptchaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //落地实现，生成图片验证码
        //创建一个验证码
        GifCaptcha captcha = new GifCaptcha(120,30,4);
        //保存这个验证码到Session空间
        req.getSession().setAttribute("code",captcha.text());

        System.out.println(captcha.text());
        captcha.out(resp.getOutputStream());//把这个验证码输出某地
    }





}
