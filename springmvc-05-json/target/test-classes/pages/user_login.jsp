<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>黑马旅游网-登录</title>  
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
      <!--导入angularJS文件-->
    <script src="${pageContext.request.contextPath}/js/angular.min.js" type="javascript"></script>
	<!--导入jquery-->
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<script>
	$(function () {
		$("#btn_login").click(function () {
			$.post("${pageContext.request.contextPath}/user/userLogin",$("#loginForm").serialize(),function (data) {
                data = JSON.parse(data);

				if(data.flag===true)
				{   console.log("成功le ");
					location.href="${pageContext.request.contextPath}/forIndex";
				}else
				{
					console.log("出错了");
					$("#errorMsg").html(data.msg);
				}
				console.log(data)
			})
		})
	})

</script>
<body>
<!--引入头部-->
<div id="header">
<jsp:include page="user_header.jsp"></jsp:include>
</div>
    <!-- 头部 end -->
    <section id="login_wrap">
        <div class="fullscreen-bg" style="background: url(${pageContext.request.contextPath}/images/login_bg.png);height: 532px;">
        	
        </div>
        <div class="login-box">
        	<div class="title">
        		<img src="${pageContext.request.contextPath}/images/login_logo.png" alt="">
        		<span>欢迎登录黑马旅游账户</span>
        	</div>
        	<div class="login_inner">
				
				<!--登录错误提示消息-->
        		<div id="errorMsg" class="alert alert-danger" ></div>
				<form id="loginForm" action="${pageContext.request.contextPath}/login.do" method="post" accept-charset="utf-8">
        			<input type="hidden" name="action" value="login"/>
					<input name="username" type="text" placeholder="请输入账号" autocomplete="off">
        			<input name="password" type="password" placeholder="请输入密码" autocomplete="off">
        			<div class="verify">
					<input name="checkCode" type="text" placeholder="请输入验证码" autocomplete="off">
						<img src="${pageContext.request.contextPath}/checkCode" height="32px" alt="" onclick="changeCheckCode(this)">
						<script type="text/javascript">
							//图片点击事件
							function changeCheckCode(img) {
								img.src="${pageContext.request.contextPath}/checkCode?"+new Date().getTime();
							}
						</script>
			</div>
			<div class="submit_btn">

        				<button type="button" id="btn_login">登录</button>
        				<div class="auto_login">

        				</div>
        			</div>        			       		
        		</form>
        		<div class="reg">没有账户？<a href="${pageContext.request.contextPath}/pages/user_register.jsp">立即注册</a></div>
        	</div>
        </div>
    </section>
<div id="footer">
	<jsp:include page="user_footer.jsp"></jsp:include>
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="j${pageContext.request.contextPath}/s/bootstrap.min.js"></script>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/include.js"></script>
</body>

</html>