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

//修改汽车信息
@WebServlet("/car/update.do")
public class UpdateCarServlet extends HttpServlet {
    //处理修改前查询
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //修改id
        String id = req.getParameter("id");
        //查询服务
        CarService carService = new CarServiceImpl();
        
        try {
            Car car = carService.findById(Integer.valueOf(id));

            //把car对象数据渲染到网页上
           //render(car,resp);
            //把数据存入域中
            req.setAttribute("updateCar",car);

            //跳转页面显示数据
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //渲染修改页面的方法
//    private void render(Car car, HttpServletResponse resp) throws IOException {
//
//        PrintWriter ps = resp.getWriter();
//        ps.println("<!DOCTYPE html>\n" +
//                "<html>\n" +
//                "\t<head>\n" +
//                "\t\t<meta charset=\"utf-8\">\n" +
//                "\t\t<title></title>\n" +
//                "\t\t<link href=\"css/add.css\" rel=\"stylesheet\" />\n" +
//                "\t</head>\n" +
//                "\t<body>\n" +
//                "\t\t<h1>当当二手车<span style=\"font-size: 20px;\">信息管理平台</span></h1>\n" +
//                "\t\t<hr color=\"gold\" size=\"4\" />\n" +
//                "\t\t<h4 align=\"center\">修改页面</h4>\n" +
//                "\t\t<form action=\"/car/update.do\" method=\"post\">\n" +
//                "\t\t\t<div class=\"box\">");
//
//        ps.println("<input name=\"id\" type='hidden' value="+car.getId()+" />");
//
//        ps.println("<div class=\"row\">\n" +
//                "\t\t\t\t\t<div>名字</div>\n" +
//                "\t\t\t\t\t<div> <input type=\"text\" name=\"carName\" placeholder=\"请输入汽车名称\" value=\""+car.getCarName()+"\"/>\n" +
//                "\t\t\t\t\t</div>\n" +
//                "\t\t\t\t</div>\n" +
//                "\t\t\t\t<div class=\"row\">\n" +
//                "\t\t\t\t\t<div>排量</div>\n" +
//                "\t\t\t\t\t<div> \n" +
//                "\t\t\t\t\t\t<input name=\"pl\" type=\"text\" placeholder=\"请输入排量\" value=\""+car.getPl()+"\"/>\n" +
//                "\t\t\t\t\t</div>\n" +
//                "\t\t\t\t</div>\n" +
//                "\t\t\t\t<div class=\"row\">\n" +
//                "\t\t\t\t\t<div>类型</div>\n" +
//                "\t\t\t\t\t<div> \n" +
//                "\t\t\t\t\t\t<select name=\"carType\">\n" +
//                "\t\t\t\t\t\t\t<option value=\"轿车\" "+( car.getCarType().equals("轿车")?"selected":"")+">轿车</option>\n" +
//                "\t\t\t\t\t\t\t<option value=\"SUV\" "+(car.getCarType().equals("SUV")?"selected":"")+">SUV</option>\n" +
//                "\t\t\t\t\t\t\t<option value=\"MPV\" "+(car.getCarType().equals("MPV")?"selected":"")+">MPV</option>\n" +
//                "\t\t\t\t\t\t\t<option value=\"卡车\" "+(car.getCarType().equals("卡车")?"selected":"")+">卡车</option>\n" +
//                "\t\t\t\t\t\t</select>\n" +
//                "\t\t\t\t\t</div>\n" +
//                "\t\t\t\t</div>\n" +
//                "\t\t\t\t<div class=\"row\">\n" +
//                "\t\t\t\t\t<div>价格</div>\n" +
//                "\t\t\t\t\t<div> \n" +
//                "\t\t\t\t\t\t<input name=\"price\" type=\"text\" placeholder=\"请输入价格\" value=\""+car.getPrice()+"\"/>\n" +
//                "\t\t\t\t\t</div>\n" +
//                "\t\t\t\t</div>\n" +
//                "\t\t\t\t\n" +
//                "\t\t\t\t<div class=\"row\">\n" +
//                "\t\t\t\t\t<div>里程</div>\n" +
//                "\t\t\t\t\t<div> \n" +
//                "\t\t\t\t\t\t<input name=\"mileage\" type=\"text\" placeholder=\"请输入里程\" value=\""+car.getMileage()+"\" />\n" +
//                "\t\t\t\t\t</div>\n" +
//                "\t\t\t\t</div>\n" +
//                "\t\t\t\t<div class=\"row\">\n" +
//                "\t\t\t\t\t<div>出厂日期</div>\n" +
//                "\t\t\t\t\t<div> \n" +
//                "\t\t\t\t\t\t<input name=\"productionDate\" type=\"text\" placeholder=\"请输入出厂日期\" value=\""+car.getProductionDate()+"\"/>\n" +
//                "\t\t\t\t\t</div>\n" +
//                "\t\t\t\t</div>\n" +
//                "\t\t\t\t<div class=\"row\">\n" +
//                "\t\t\t\t\t<div>车架号</div>\n" +
//                "\t\t\t\t\t<div> \n" +
//                "\t\t\t\t\t\t<input name=\"serial\" type=\"text\" placeholder=\"请输入车架号\" value=\""+car.getSerial()+"\"/>\n" +
//                "\t\t\t\t\t</div>\n" +
//                "\t\t\t\t</div>\n" +
//                "\t\t\t\t<div class=\"row\">\n" +
//                "\t\t\t\t\t<div>&nbsp;</div>\n" +
//                "\t\t\t\t\t<div> \n" +
//                "\t\t\t\t\t\t<input type=\"submit\" value=\"提交\" />\n" +
//                "\t\t\t\t\t</div>\n" +
//                "\t\t\t\t</div>");
//
//
//        ps.println("</div>\n" +
//                "\t\t</form>\n" +
//                "\t</body>\n" +
//                "</html>");
//
//
//
//
//    }

    //处理修改后保存
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受参数
        Car car = new Car();
        car.setId(Integer.valueOf(req.getParameter("id")));
        car.setCarName(req.getParameter("carName"));
        car.setPl(req.getParameter("pl"));
        car.setCarType(req.getParameter("carType"));
        car.setPrice(Double.valueOf(req.getParameter("price")));
        car.setMileage(Integer.valueOf(req.getParameter("mileage")));
        car.setProductionDate(req.getParameter("productionDate"));
        car.setSerial(req.getParameter("serial"));

        //调用修改服务
        CarService carService = new CarServiceImpl();
        try {
            boolean isOk = carService.update(car);
            if(isOk){
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
