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
        <a href="#">${product.productName}</a><span> &gt;订单填写</span><span> &gt;为订单 ${order.orderNum} 支付</span>



            <%--    支付--%>
            <form action="${pageContext.request.contextPath}/orders/toPay" method="post">
            <div class="panel panel-default">
                <input type="hidden" name="orderNum" value="${order.orderNum}">
                <div class="panel-heading">费用信息</div>
                <div class="row data-type">

                    <div class="col-md-2 title">支付方式</div>
                    <div class="col-md-4 data text">
                        <select name="payType" id="">
                            <option value="0">微信支付</option>
                            <option value="1">支付宝支付</option>
                        </select>
                    </div>

                    <div class="col-md-2 title">金额</div>
                    <div class="col-md-4 data text">￥${order.orderPrice}(${peopleCount}人)</div>

                </div>
            </div>
            <div class="btn-group"style="align-content: center">
                <input type="submit" class="btn btn-primary dropdown-toggle" value="提交订单">

            </div>

            </form>

    </div>
    </div>
<div class="you_need_konw">
    <span>旅游须知</span>
    <div class="notice">
        <p>1、旅行社已投保旅行社责任险。建议游客购买旅游意外保险 <br>

        <p>2、旅游者参加打猎、潜水、海边游泳、漂流、滑水、滑雪、滑草、蹦极、跳伞、滑翔、乘热气球、骑马、赛车、攀岩、水疗、水上飞机等属于高风险性游乐项目的，敬请旅游者务必在参加前充分了解项目的安全须知并确保身体状况能适应此类活动；如旅游者不具备较好的身体条件及技能，可能会造成身体伤害。</p>

        <p>3、参加出海活动时，请务必穿着救生设备。参加水上活动应注意自己的身体状况，有心脏病、冠心病、高血压、感冒、发烧和饮酒及餐后不可以参加水上活动及潜水。在海里活动时，严禁触摸海洋中各种鱼类，水母，海胆，珊瑚等海洋生物，避免被其蛰伤。老人和小孩必须有成年人陪同才能参加合适的水上活动。在海边游玩时，注意保管好随身携带的贵重物品。</p>

        <p>4、根据中国海关总署的规定，旅客在境外购买的物品，在进入中国海关时可能需要征收关税。详细内容见《中华人民共和国海关总署公告2010年第54号文件》。</p>

        <p>5、建议出发时行李托运，贵重物品、常用物品、常用药品、御寒衣物等请随身携带，尽量不要托运。行李延误属于不可抗力因素，我司将全力协助客人跟进后续工作，但我司对此不承担任何责任。</p>
        <p>1、旅行社已投保旅行社责任险。建议游客购买旅游意外保险 <br>

        <p>2、旅游者参加打猎、潜水、海边游泳、漂流、滑水、滑雪、滑草、蹦极、跳伞、滑翔、乘热气球、骑马、赛车、攀岩、水疗、水上飞机等属于高风险性游乐项目的，敬请旅游者务必在参加前充分了解项目的安全须知并确保身体状况能适应此类活动；如旅游者不具备较好的身体条件及技能，可能会造成身体伤害。</p>

        <p>3、参加出海活动时，请务必穿着救生设备。参加水上活动应注意自己的身体状况，有心脏病、冠心病、高血压、感冒、发烧和饮酒及餐后不可以参加水上活动及潜水。在海里活动时，严禁触摸海洋中各种鱼类，水母，海胆，珊瑚等海洋生物，避免被其蛰伤。老人和小孩必须有成年人陪同才能参加合适的水上活动。在海边游玩时，注意保管好随身携带的贵重物品。</p>

        <p>4、根据中国海关总署的规定，旅客在境外购买的物品，在进入中国海关时可能需要征收关税。详细内容见《中华人民共和国海关总署公告2010年第54号文件》。</p>

        <p>5、建议出发时行李托运，贵重物品、常用物品、常用药品、御寒衣物等请随身携带，尽量不要托运。行李延误属于不可抗力因素，我司将全力协助客人跟进后续工作，但我司对此不承担任何责任。</p>
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