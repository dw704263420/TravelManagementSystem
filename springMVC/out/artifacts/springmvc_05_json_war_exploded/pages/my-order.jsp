<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>路线详情</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/route-detail.css">
</head>

<body>
<!--引入头部-->
<div id="header">
    <jsp:include page="user_header.jsp"></jsp:include>
</div>

<!-- 详情 start -->
<div class="wrap">

</div>
<div class="you_need_konw">
    <span>我的订单</span>
    <div class="notice">
        <c:forEach items="${orderList}" var="order">
            <div class="alert alert-warning" role="alert">
                <a  href="${pageContext.request.contextPath}/orders/findUserOrder?orderId=${order.id}">
                <p>订单号：${order.orderNum}</p>
                <p>订单人数：${order.peopleCount}</p>
                <p>总计价格：${order.orderPrice}</p>
                <p>时间：${order.orderTime}</p>
            </a></div>
        </c:forEach>

    </div>
</div>
</div>
<!-- 详情 end -->

<!--引入头部-->
<div id="footer">
    <jsp:include page="user_footer.jsp"></jsp:include>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!--导入布局js，共享header和footer-->

</body>

</html>