<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>收藏排行榜</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ranking-list.css">
        <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    </head>
    <body>
    <!--引入头部-->
    <div id="header">
        <jsp:include page="user_header.jsp"></jsp:include>
    </div>
        <div class="contant">

            <div class="list clearfix">
                <ul>
                    <c:forEach  items="${productList}" var="product" varStatus="xh">
                    <li>

                        <span class="num one">${xh.index+1}</span>
                        <a href="${pageContext.request.contextPath}/product/findProductById?id=${product.id}">
                            <img src="${pageContext.request.contextPath}/${product.rimage}" alt="">
                            <h4><a href="${pageContext.request.contextPath}/product/findProductById?id=${product.id}">${product.productName}</a></h4>
                        <p>
                            <b class="price">&yen;<span>${product.productPrice}</span>起</b>
                            <span class="shouchang">已收藏${product.isFavourTimes}次</span>
                        </p>
                    </li>
                </c:forEach>
                </ul>
            </div>
        </div>
    	
         <!--导入底部-->
    <div id="footer">
        <jsp:include page="user_footer.jsp"></jsp:include>
    </div>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/include.js"></script>
    </body>
</html>