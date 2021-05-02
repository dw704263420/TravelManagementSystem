<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>注册</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
		<!--导入jquery-->
		<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    </head>
    <body>
    <!--引入头部-->
    <div id="header">
        <jsp:include page="user_header.jsp"></jsp:include>
    </div>
        <!-- 头部 end -->
    	<div style="text-align:center;red:yellow;font-weight:bold;height:150px;padding-top:100px;font-size:30px;">
    		<h4>恭喜，注册成功！请登录您的注册邮箱进行激活您的账号，激活后才能登录。</h4>
    	</div>
        <!--引入尾部-->
    <div id="footer">
        <jsp:include page="user_footer.jsp"></jsp:include>
    </div>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/include.js"></script>
    </body>
</html>