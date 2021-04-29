<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>黑马旅游网-收藏列表</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
       <style>
           .tab-content .row>div {
            margin-top: 16px;
           } 
           .tab-content {
            margin-bottom: 36px;
           }
       </style>
       <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    </head>
    <body>
    <!--引入头部-->
    <div id="header">
        <jsp:include page="user_header.jsp"></jsp:include>
    </div>
         <!-- 排行榜 start-->
        <section id="content">            
            <section class="hemai_jx">
                <div class="jx_top">
                    <div class="jx_tit">
                        <img src="${pageContext.request.contextPath}/images/icon_5.jpg" alt="">
                        <span>收藏列表</span>
                    </div>                    
                </div>
                <div class="jx_content">
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <div class="row">
<%--                                以下为模板--%>
                                <c:if test="${fn:length(productList)<1}">

                                    <h1>暂时还没有发现任何收藏哦，快去挑选喜欢的产品收藏吧~</h1>
                                </c:if>

                                <c:forEach  items="${productList}" var="product">
                                <div class="col-md-3">
                                    <a href="${pageContext.request.contextPath}/product/findProductById?id=${product.id}">
                                        <img src="${pageContext.request.contextPath}/${product.rimage}" alt="">
                                        <div class="has_border">
                                            <h3>${product.productName}</h3>
                                            <div class="price">网付价<em>￥</em><strong>${product.productPrice}</strong><em>起</em></div>
                                        </div>
                                    </a>
                                </div>
                                </c:forEach>
                            </div>
                        </div>                       
                    </div>
                </div>
            </section>                      
        </section>
        <!-- 排行榜 end-->
    	
         <!--引入尾部-->
    <div id="footer">
        <jsp:include page="user_footer.jsp"></jsp:include>
    </div>
        <!--导入布局js，共享header和footer-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/include.js"></script>
    </body>
</html>