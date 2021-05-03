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
    <div class="bread_box">
        <a href="/">首页</a>
        <span> &gt;</span>
        <a href="#">国内游</a><span> &gt;</span>
        <a href="#">${product.productName}</a><span> &gt;订单填写</span><span> &gt;为订单 ${orderNum} 支付</span>



        <%--    支付--%>
        <form action="${pageContext.request.contextPath}/orders/payFinished" method="post">
            <input type="hidden" name="orderNum" value="${orderNum}"/>
      <c:choose>
          <c:when test="${payType==1}"><span>使用微信支付向我付款</span>
              <img src="${pageContext.request.contextPath}/images/payment/wechatPay.jpg" width="500px" height="500px" alt="">
          </c:when>
          <c:when test="${payType==0}"><span>使用支付宝支付向我付款</span>
              <img src="${pageContext.request.contextPath}/images/payment/wechatPay.jpg" width="500px" height="500px" alt="">
          </c:when>
      </c:choose>
            <input type="hidden" name="payType" value="${payType}">

            <div class="btn-group"style="align-content: center">
                <input type="submit" class="btn btn-primary dropdown-toggle" value="支付完成">

            </div>

        </form>

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