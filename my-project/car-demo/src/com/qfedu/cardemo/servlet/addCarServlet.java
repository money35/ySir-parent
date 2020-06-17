package com.qfedu.cardemo.servlet;


//添加汽车信息

import com.qfedu.cardemo.entity.Car;
import com.qfedu.cardemo.service.CarService;
import com.qfedu.cardemo.service.impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car/add.do")
public class addCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //接收添加请求，调用相应服务

        CarService carService = new CarServiceImpl();
        //接收参数
        Car car = new Car();
        car.setCarName(req.getParameter("carName"));
        car.setPl(req.getParameter("pl"));
        car.setCarType(req.getParameter("carType"));
        car.setPrice(Double.valueOf(req.getParameter("price")));
        car.setMileage(Integer.valueOf(req.getParameter("mileage")));
        car.setProductionDate(req.getParameter("productionDate"));
        car.setSerial(req.getParameter("serial"));

        ////调用添加方法
        try {
            boolean isOk = carService.save(car);
            if(isOk){
                //跳转到列表页面
                resp.sendRedirect("/car/list.do");
            }else{
                //添加页面
                resp.sendRedirect("/add.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //添加页面
            resp.sendRedirect("/add.html");
        }

    }
}
