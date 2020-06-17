
<%--
  Created by IntelliJ IDEA.
  User: 15649
  Date: 2020/5/10
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>汽车信息列表</title>
</head>
<body>
    <a href="/add.html">新增</a>
    <table width="1000px">
        <tr>
        <td>编号</td>
        <td>名称</td>
        <td>排量</td>
        <td>类型</td>
        <td>价格</td>
        <td>里程</td>
        <td>出厂日期</td>
        <td>车架号</td>
        <td>操作</td>
        </tr>
    <c:forEach items="${carsData}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.carName}</td>
            <td>${c.pl}</td>
            <td>${c.carType}</td>
            <td>${c.price}</td>
            <td>${c.mileage}</td>
            <%--<c:if test="${c.mileage<=10000}">
                <td>一万公里内</td>
            </c:if>
            <c:if test="${c.mileage<=50000 and c.mileage>10000}">
                <td>一到五万公里内</td>
            </c:if>
            <c:if test="${c.mileage<=100000 and c.mileage>50000}">
                <td>五到十万公里内</td>
            </c:if>
            <c:if test="${ c.mileage>100000}">
                <td>十万公里以上</td>
            </c:if>--%>
            <td>${c.productionDate}</td>
            <td>${c.serial}</td>
            <td><a onclick=" return confirm('确定删除？')" href="/car/delete.do?id=${c.id}">删除</a><a  href="/car/update.do?id=${c.id}">修改</a></td>
        </tr>

    </c:forEach>

    </table>
</body>
</html>
