<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>黑马旅游网</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!--引入头部-->
    <div id="header">
        <jsp:include page="user_header.jsp"></jsp:include>
    </div>
    <!-- banner start-->
    <section id="banner">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000">
            <!-- Indicators -->
            <ol class="carousel-indicators">

                <c:forEach items="${bannerList}" var="banner" begin="0" end="0" varStatus="id">
                    <li data-target="#carousel-example-generic" class="active"  data-slide-to="${id.index}"></li>
                </c:forEach>
                <c:forEach items="${bannerList}" var="banner" begin="1" end="${bannerList.size()}" varStatus="id">
                    <li data-target="#carousel-example-generic" data-slide-to="${id.index}"></li>
                </c:forEach>
            </ol>
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <c:forEach items="${bannerList}" var="banner" begin="0" end="0">
                            <div class="item active">
                                <img src="${pageContext.request.contextPath}/${banner.bImage}" alt="">
                            </div>
                </c:forEach>
                <c:forEach items="${bannerList}" var="banner" begin="1" >
                <div class="item">
                    <img src="${pageContext.request.contextPath}/${banner.bImage}" alt="图裂了">
                </div>
                </c:forEach>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
        </div>
    </section>
    <!-- banner end-->
    <!-- 旅游 start-->
    <section id="content">
         <!-- 黑马精选start-->
        <section class="hemai_jx">
            <div class="jx_top">
                <div class="jx_tit">
                    <img src="${pageContext.request.contextPath}/images/icon_5.jpg" alt="">
                    <span>今日人气王</span>
                </div>
                <!-- Nav tabs -->

            </div>
            <div class="jx_content">
                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="popularity">
                        <div class="row">
                        <c:forEach items="${recomProduct}" var="product" >

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
        <!-- 黑马精选end-->
        <!-- 国内游 start-->
        <section class="hemai_jx">
            <div class="jx_top">
                <div class="jx_tit">
                    <img src="${pageContext.request.contextPath}/images/icon_6.jpg" alt="">
                    <span>随心推荐</span>
                </div>


                <button type="button" class="btn btn-warning">不喜欢？换一批</button>

            </div>
            <div class="heima_gn">
                <div class="guonei_l">
                    <img src="${pageContext.request.contextPath}/images/guonei_1.jpg" alt="">
                </div>
                <div class="guone_r">
                    <div class="row">
                        <c:forEach items="${randProduct}" var="product">
                        <div class="col-md-4">
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
        </section>
        <!-- 国内游 end-->

    </section>
    <!-- 旅游 end-->
   <!--导入底部-->
    <div id="footer">
        <jsp:include page="user_footer.jsp"></jsp:include>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/include.js"></script>
    <script>
        $(function () {
            alert("由于首页部分组件使用了redis进行缓存优化，为保正常体验，请开启redis服务端后再测试该项目其他功能！带来不便，还请见谅！\n 由于该项目启用了邮箱验证功能，请务必保证该项目启动时具备互联网环节，带来不便，还请见谅！")
        });
    </script>

</body>

</html>