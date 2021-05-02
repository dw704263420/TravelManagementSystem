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
    <span> >订单 ${orders.orderNum}</span>
    <div class="notice">

        <section class="content"> <!--订单信息-->
            <div class="panel panel-default">
                <div class="panel-heading">订单信息</div>
                <div class="row data-type">

                    <div class="col-md-2 title">订单编号</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="订单编号"
                               value="${orders.orderNum }" readonly="readonly">
                    </div>

                    <div class="col-md-2 title">下单时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" class="form-control pull-right"
                                   id="datepicker-a3" readonly="readonly"
                                   value="${orders.orderTime}">
                        </div>
                    </div>
                    <div class="col-md-2 title">路线名称</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="路线名称"
                               value="${orders.product.productName}" readonly="readonly">
                    </div>

                    <div class="col-md-2 title">出发城市</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="出发城市"
                               value="${orders.product.cityName }" readonly="readonly">
                    </div>

                    <div class="col-md-2 title">出发时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" class="form-control pull-right"
                                   id="datepicker-a6" value="${orders.product.departureTimeStr}"
                                   readonly="readonly">
                        </div>
                    </div>
                    <div class="col-md-2 title">出游人数</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="出游人数"
                               value="${orders.peopleCount}" readonly="readonly">
                    </div>

                    <div class="col-md-2 title rowHeight2x">其他信息</div>
                    <div class="col-md-10 data rowHeight2x">
						<textarea class="form-control" rows="3" placeholder="其他信息">
                            ${orders.orderDesc }
                        </textarea>
                    </div>

                </div>
            </div>
            <!--订单信息/--> <!--游客信息-->
            <div class="panel panel-default">
                <div class="panel-heading">游客信息</div>
                <!--数据列表-->
                <table id="dataList"
                       class="table table-bordered table-striped table-hover dataTable">
                    <thead>
                    <tr>
                        <th class="">人群</th>
                        <th class="">姓名</th>
                        <th class="">性别</th>
                        <th class="">手机号码</th>
                        <th class="">证件类型</th>
                        <th class="">证件号码</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="traveller" items="${orders.travellers}">

                        <tr>
                            <td>${traveller.travellerTypeStr}</td>
                            <td><input type="text" size="10" value="${traveller.name }"
                                       readonly="readonly"></td>
                            <td>
                                <c:if test="${traveller.sex eq 0 }">
                                <input type="text" size="10" value="男"
                                       readonly="readonly">
                                </c:if>
                                <c:if test="${traveller.sex eq 1 }">
                                    <input type="text" size="10" value="女"
                                           readonly="readonly">
                                </c:if>
                            </td>
                            <td><input type="text" size="20"
                                       value="${traveller.phoneNum }" readonly="readonly"></td>
                            <td><input type="text" size="15"
                                       value="${traveller.credentialsTypeStr}" readonly="readonly"></td>
                            <td><input type="text" size="28"
                                       value="${traveller.credentialsNum}" readonly="readonly"></td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
                <!--数据列表/-->
            </div>
            <!--游客信息/--> <!--联系人信息-->
            <div class="panel panel-default">
                <div class="panel-heading">联系人信息</div>
                <div class="row data-type">

                    <div class="col-md-2 title">会员</div>
                    <div class="col-md-4 data text">${orders.userInfo.username }</div>

                    <div class="col-md-2 title">联系人</div>
                    <div class="col-md-4 data text">${orders.userInfo.trueName}</div>

                    <div class="col-md-2 title">手机号</div>
                    <div class="col-md-4 data text">${orders.userInfo.phoneNum}</div>

                    <div class="col-md-2 title">邮箱</div>
                    <div class="col-md-4 data text">${orders.userInfo.email}</div>

                </div>
            </div>
            <!--联系人信息/--> <!--费用信息,如果未支付，那么就不会显示-->
            <c:if test="${orders.orderStatus==1}">
                <div class="panel panel-default">
                    <div class="panel-heading">费用信息</div>
                    <div class="row data-type">

                        <div class="col-md-2 title">支付方式</div>
                        <div class="col-md-4 data text">在线支付-${orders.payTypeStr}</div>

                        <div class="col-md-2 title">金额</div>
                        <div class="col-md-4 data text">￥${orders.product.productPrice}</div>

                    </div>
                </div>
            </c:if> <!--费用信息/--> <!--工具栏-->
            <div class="box-tools text-center">

                <button type="button" class="btn bg-default"
                        onclick="javascript:history.back(-1)">返回</button>
            </div>
            <!--工具栏/--> </section>
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