<%--
  Created by IntelliJ IDEA.
  User: yuanh
  Date: 2022/6/11
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>网店后台</title>
</head>
<body>

<h1>${login.username}.欢迎你,网店后台商品</h1>

<input type="button" value="新增商品" id="add" >
<input type="button" value="为员工注册" id="zdd" >
<div class="sousuo">
    <form action="/brandshoping/selectByNameServlet" methed="post">
        <input type="text" id="input" autocomplete="off" name="productName"  placeholder="请输入商品名">
        <input type="submit" id="sousuo_kuan" value="搜索">
    </form>
</div>
<br>
<hr>
<table border="1" cellspacing="0" width="100%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>类别</th>
        <th>品牌介绍</th>
        <th>剩余</th>
        <th>状态</th>
        <th>操作</th>

    </tr>


    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${brand.brandname}</td>
            <td>${brand.companyname}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <td>${brand.quantity}</td>
            <c:if test="${brand.status == 1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>

            <td><a href="/brandshoping/selectByIdServlet?brandid=${brand.brandid}">修改</a>
                <a href="/brandshoping/deleteByidServlet?brandid=${brand.brandid}">删除</a></td>
        </tr>

    </c:forEach>




</table>
<script>
    document.getElementById("add").onclick = function () {
        location.href = "/brandshoping/addbrand.jsp";
    }

    document.getElementById("zdd").onclick = function () {
        location.href = "/brandshoping/regih.jsp";
    }

</script>
</body>
</html>
