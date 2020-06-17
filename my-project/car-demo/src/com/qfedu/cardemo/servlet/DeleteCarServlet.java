package com.qfedu.cardemo.servlet;


import com.qfedu.cardemo.service.CarService;
import com.qfedu.cardemo.service.impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//删除汽车信息
@WebServlet("/car/delete.do")
public class DeleteCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收删除请求，调用删除服务

        //获得删除id
        String id = req.getParameter("id");

        //引入服务
        CarService carService = new CarServiceImpl();
        try {
            boolean isOk = carService.delete(Integer.parseInt(id));
            if(isOk){
                //跳转到列表页面
                resp.sendRedirect("/car/list.do");
            }else{
                resp.getWriter().println("option error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("option error");

        }
    }
}
