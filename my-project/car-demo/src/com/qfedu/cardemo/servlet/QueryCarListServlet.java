package com.qfedu.cardemo.servlet;

import com.qfedu.cardemo.entity.Car;
import com.qfedu.cardemo.service.CarService;
import com.qfedu.cardemo.service.impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/car/list.do")
public class QueryCarListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接收查询请求,调用相关服务
        CarService carService = new CarServiceImpl();
        try {
            List<Car> carlist = carService.list();
            //拿到数据，渲染页面
            //render(carlist,resp);
            req.setAttribute("carsData",carlist);
            //跳转到指定页面区渲染
            req.getRequestDispatcher("/list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //渲染网页的方法
//    private void render(List<Car> carlist, HttpServletResponse resp) throws IOException {
//
//        PrintWriter ps = resp.getWriter();
//        ps.println("<!DOCTYPE html>\n" +
//                "<html>\n" +
//                "\t<head>\n" +
//                "\t\t<meta charset=\"utf-8\">\n" +
//                "\t\t<title>当当二手车</title>\n" +
//                "\t</head>\n" +
//                "\t<body>\n" +
//                "\t\t\n" +
//                "\t\t<h1>当当二手车<span style=\"font-size: 20px;\">信息管理平台</span></h1>\n" +
//                "\t\t<hr color=\"gold\" size=\"4\" />\n" +
//                "\t\t<a href=\"/add.html\">新增</a>\n" +
//                "\t\t<table style=\"width: 800px;\">\n" +
//                "\t\t\t<tr>\n" +
//                "\t\t\t\t<td>编号</td>\n" +
//                "\t\t\t\t<td>名称</td>\n" +
//                "\t\t\t\t<td>排量</td>\n" +
//                "\t\t\t\t<td>类型</td>\n" +
//                "\t\t\t\t<td>价格</td>\n" +
//                "\t\t\t\t<td>里程</td>\n" +
//                "\t\t\t\t<td>出厂日期</td>\n" +
//                "\t\t\t\t<td>车架号</td>\n" +
//                "\t\t\t\t<td>操作</td>\n" +
//                "\t\t\t</tr>");
//
//        //遍历数据
//        carlist.forEach((car)->{
//           ps.println("<tr>\n" +
//                   "\t\t\t\t<td>"+car.getId()+"</td>\n" +
//                   "\t\t\t\t<td>"+car.getCarName()+"</td>\n" +
//                   "\t\t\t\t<td>"+car.getPl()+"</td>\n" +
//                   "\t\t\t\t<td>"+car.getCarType()+"</td>\n" +
//                   "\t\t\t\t<td>"+car.getPrice()+"</td>\n" +
//                   "\t\t\t\t<td>"+car.getMileage()+"</td>\n" +
//                   "\t\t\t\t<td>"+car.getProductionDate()+"</td>\n" +
//                   "\t\t\t\t<td>"+car.getSerial()+"</td>\n" +
//                   "\t\t\t\t<td>\n" +
//                   "\t\t\t\t\t<a onclick=\"return confirm('确认删除？')\" href=\"/car/delete.do?id="+car.getId()+"\">删除</a>\n" +
//                   "\t\t\t\t\t<a href=\"/car/update.do?id="+car.getId()+"\">修改</a>\n" +
//                   "\t\t\t\t</td>\n" +
//                   "\t\t\t</tr>");
//        });
//
//
//        ps.println("</table>\n" +
//                "\t</body>\n" +
//                "</html>\n");
//    }
}
