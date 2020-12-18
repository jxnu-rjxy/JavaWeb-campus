<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/17
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<form action="login" method="post">
    用户名：<input type="text" name="user_phone">
    密码：<input type="password" name="user_password">
    <input type="submit" value="提交">
</form>

<a href="selectDynamic" >getAll</a>
<div class="name">
    <a href="postDynamic.html">发表动态</a>
</div>
<div>
    <a href="myDynamic.html">我的动态</a>
</div>
<button class="btn">点击</button>
<script>
    $(".btn").click(function () {
        $.ajax({
            url:"http://localhost:80/campus/login",
            data:{user_phone:"13340116773",user_password:"123456"},
            type:"POST",
            success: function a(data) {
                console.log("hahahahha");
                $(".name").html("<p>"+data+"</p>");
            }
        });
    })
</script>
</body>
</html>
