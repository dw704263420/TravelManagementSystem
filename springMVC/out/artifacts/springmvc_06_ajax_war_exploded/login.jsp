<%--
  Created by IntelliJ IDEA.
  User: 70426
  Date: 2021/4/10
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js"></script>
<script>
    function a1()
    {
        $.post({
            url:"${pageContext.request.contextPath}/a3",
            data:{
                "name":$("#username").val(),

                },
            success:function (data) {
                if (data.toString()==="ok")
                {   $("#userInfo").css("color","green");
                    $("#userInfo").text("ok");
                }
                else
                {   $("#userInfo").css("color","red");
                    $("#userInfo").text("用户名有误");
                }
            }
            }
        )
    }
</script>
<body>
<p>用户名</p>
<input type="text" name="username" id="username" onblur="a1()">
<span id="userInfo"></span>
<p>密码</p>
<input type="text" name="password" id="password" onblur="a2()">
<span id="pwdInfo"></span>

</body>
</html>
