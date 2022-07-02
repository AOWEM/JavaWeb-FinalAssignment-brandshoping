<%--
  Created by IntelliJ IDEA.
  User: yuanh
  Date: 2022/6/11
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>register</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="box" >
    <form action="/brandshoping/changeServlet" method="post">
        <h2>Change</h2>${user_cw}
        <div class="input-box">
            <label>账号</label>
            <input name="username" type="username"/>
        </div>
        <div class="input-box">
            <label>原密码</label>
            <input  name="password" type="password"/>
        </div>
        <div class="input-box">
            <label>修改密码</label>
            <input  name="passwords" type="password"/>
        </div>
        <div class="btn-box">
            <div>
                <button>修改</button>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript">

</script>
</body>
</html>
