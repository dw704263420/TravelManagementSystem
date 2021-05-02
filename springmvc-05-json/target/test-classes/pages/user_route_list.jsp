<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>黑马旅游-搜索</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->
<div id="header">
    <jsp:include page="user_header.jsp"></jsp:include>
</div>
    <div class="page_one">
        <div class="contant">
            <div class="crumbs">
                <img src="${pageContext.request.contextPath}/images/search.png" alt="">
                <p>黑马旅行><span>${cname}</span></p>
            </div>
            <div class="xinxi clearfix">
                <div class="left">
                    <div class="header">
                        <span>商品信息</span>
                        <span class="jg">价格</span>
                    </div>
                    <ul>
                        <c:forEach items="${pageInfo.list}" var="product">
                        <li>
                            <div class="img"><img src="${pageContext.request.contextPath}/${product.rimage}" height="170px"  width="300px" alt=""></div>
                            <div class="text1" >
                                <p >${product.productName}</p>
                                <br/>
                                <p>${product.productDesc}</p>
                            </div>
                            <div class="price">
                                <p class="price_num">
                                    <span>&yen;</span>
                                    <span>${product.productPrice}</span>
                                    <span>起</span>
                                </p>
                                <p><a href="${pageContext.request.contextPath}/product/findProductById?id=${product.id}">查看详情</a></p>
                            </div>
                        </li>
                        </c:forEach>
                    </ul>
                    <div class="page_num_inf">
                        <i></i> 共
                        <span>${pageInfo.pages}</span>页
                    </div>
                    <div class="pageNum">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/product/findAllProduct?page=1&&size=${pageInfo.pageSize}&&keyWord=${keyWord}&&cid=${cid}">首页</a></li>
                            <li class="threeword"><a href="${pageContext.request.contextPath}/product/findAllProduct?page=${pageInfo.pageNum-1}&&size=${pageInfo.pageSize}&&keyWord=${keyWord}&&cid=${cid}">上一页</a></li>
                            <c:if test="${pageInfo.pageNum gt 5}">
                                <c:forEach begin="${(pageInfo.pageNum-5)}" end ="${pageInfo.pageNum+5}" var="pageNum">
                                    <c:choose>
                                        <c:when test="${pageNum eq pageInfo.pageNum}">
                                            <li  class="curPage"><a href="${pageContext.request.contextPath}/product/findAllProduct?page=${pageNum}&&size=${pageInfo.pageSize}&&keyWord=${keyWord}&&cid=${cid}">${pageNum}</a></li>
                                        </c:when>
                                        <c:when test="${pageNum ne pageInfo.pageNum}">
                                            <li><a href="${pageContext.request.contextPath}/product/findAllProduct?page=${pageNum}&&size=${pageInfo.pageSize}&&keyWord=${keyWord}&&cid=${cid}">${pageNum}</a></li>
                                        </c:when>
                                    </c:choose>   </c:forEach>
                            </c:if>
                            <c:if test="${pageInfo.pageNum lt 6}">
                            <c:forEach begin="1" end ="${pageInfo.pages gt 10?10:pageInfo.pages}" var="pageNum">

                                <c:choose>
                                    <c:when test="${pageNum eq pageInfo.pageNum}">
                                        <li  class="curPage"><a href="${pageContext.request.contextPath}/product/findAllProduct?page=${pageNum}&&size=${pageInfo.pageSize}&&keyWord=${keyWord}&&cid=${cid}">${pageNum}</a></li>
                                    </c:when>
                                    <c:when test="${pageNum ne pageInfo.pageNum}">
                                        <li><a href="${pageContext.request.contextPath}/product/findAllProduct?page=${pageNum}&&size=${pageInfo.pageSize}&&keyWord=${keyWord}&&cid=${cid}">${pageNum}</a></li>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                            </c:if>
                            <li class="threeword"><a href="${pageContext.request.contextPath}/product/findAllProduct?page=${pageInfo.pageNum+1}&&size=${pageInfo.pageSize}&&keyWord=${keyWord}&&cid=${cid}">下一页</a></li>
                            <li class="threeword"><a href="${pageContext.request.contextPath}/product/findAllProduct?page=${pageInfo.pages}&&size=${pageInfo.pageSize}&&keyWord=${keyWord}&&cid=${cid}">末页</a></li>
                        </ul>
                    </div>
                </div>
                <div class="right">
                    <div class="top">
                        <div class="hot">HOT</div>
                        <span>热门推荐</span>
                    </div>
                    <ul>
                        <c:forEach items="${productList}" var="product">
                            <li>
                                <a href="${pageContext.request.contextPath}/product/findProductById?id=${product.id}">
                                    <div class="left"><img src="${pageContext.request.contextPath}/${product.rimage}" alt=""></div>
                                    <div class="right">
                                        <p>${product.productName}</p>
                                        <p>网付价<span>&yen;<span>${product.productPrice}</span>起</span>
                                        </p>
                                    </div>
                                </a>
                            </li>
                        </c:forEach>


                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!--引入头部-->
<div id="footer">
    <jsp:include page="user_footer.jsp"></jsp:include>
</div>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/include.js"></script>
</body>

</html>