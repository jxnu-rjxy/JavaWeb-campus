<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/10
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<form action="login" method="post">
    用户名：<input type="text" name="user_id">
    密码：<input type="password" name="user_password">
    <input type="submit" value="提交">
</form>
<a href="login" >getAll</a>
<div class="name">

</div>
<button class="btn">点击</button>
<script>
    $(".btn").click(function () {
        $.ajax({
            url:"http://localhost:8888/campus/login",
            data:{user_id:2,user_password:"123456"},
            type:"POST",
            success: function a(data) {
                console.log("hahahahha");
                $(".name").html("<p>"+data.u+"</p>");
            }
        });
    })
</script>
</body>
</html>
