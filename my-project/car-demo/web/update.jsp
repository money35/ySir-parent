<%--
  Created by IntelliJ IDEA.
  User: 15649
  Date: 2020/5/10
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link href="css/add.css" rel="stylesheet" />
</head>
<body>
<h1>当当二手车<span style="font-size: 20px;">信息管理平台</span></h1>
<hr color="gold" size="4" />
<h4 align="center">修改页面</h4>
<form action="/car/update.do" method="post">
    <div class="box">

        <input type="hidden" name="id" value="${updateCar.id}"/>

        <div class="row">
            <div>名字</div>
            <div> <input type="text" name="carName" placeholder="请输入汽车名称" value="${updateCar.carName}" /></div>
        </div>
        <div class="row">
            <div>排量</div>
            <div>
                <input name="pl" type="text" placeholder="请输入排量" value="${updateCar.pl}" />
            </div>
        </div>
        <div class="row">
            <div>类型</div>
            <div>
                <select name="carType">
                    <option value="轿车" ${updateCar.carType=="轿车"?"selected":""} >轿车</option>
                    <option value="SUV" ${updateCar.carType=="SUV"?"selected":""} >SUV</option>
                    <option value="MPV" ${updateCar.carType=="MPV"?"selected":""} >MPV</option>
                    <option value="卡车" ${updateCar.carType=="卡车"?"selected":""} >卡车</option>
                </select>
            </div>
        </div>

        <div class="row">
            <div>价格</div>
            <div>
                <input name="price" type="text" placeholder="请输入价格" value="${updateCar.price}"/>
            </div>
        </div>



        <div class="row">
            <div>里程</div>
            <div>
                <input name="mileage" type="text" placeholder="请输入里程" value="${updateCar.mileage}" />
            </div>
        </div>

        <div class="row">
            <div>出厂日期</div>
            <div>
                <input name="productionDate" type="text" placeholder="请输入出厂日期" value="${updateCar.productionDate}" />
            </div>
        </div>

        <div class="row">
            <div>车架号</div>
            <div>
                <input name="serial" type="text" placeholder="请输入车架号" value="${updateCar.serial}" />
            </div>
        </div>

        <div class="row">
            <div>&nbsp;</div>
            <div>
                <input type="submit" value="提交" />
            </div>
        </div>
    </div>

</form>
</body>
</html>
