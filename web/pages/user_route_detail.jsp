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
            <a href="#">${product.productName}</a>
        </div>
        <div class="prosum_box">
            <dl class="prosum_left">
                <dt>
                    <c:forEach items="${product.routeImgList}" var="img" begin="0" end="0">
                        <img alt="" class="big_img" src="${pageContext.request.contextPath}/${img.bigPic}">
                    </c:forEach>
                </dt>
                <dd>
                    <a class="up_img up_img_disable"></a>
                    <c:forEach items="${product.routeImgList}" var="img" begin="0" end="3">
                        <a title="" class="little_img" data-bigpic="${pageContext.request.contextPath}/${img.bigPic}" >
                            <img src="${pageContext.request.contextPath}/${img.smallPic}">
                        </a>
                    </c:forEach>
                    <c:forEach items="${product.routeImgList}" var="img" begin="4" >
                        <a title="" class="little_img" data-bigpic="${pageContext.request.contextPath}/${img.bigPic}" style="display: none" >
                            <img src="${pageContext.request.contextPath}/${img.smallPic}">
                        </a>
                    </c:forEach>

                    <a class="down_img down_img_disable" style="margin-bottom: 0;"></a>
                </dd>
            </dl>

            <div class="prosum_right">
               <p class="pros_title">${product.productName}</p>
                <p class="hot">${product.productDesc}</p>
                <div class="pros_other">
                    <p>经营商家  ：${product.seller.sname}</p>
                    <p>咨询电话 : ${product.seller.consphone}</p>
                    <p>地址 ： ${product.seller.address}</p>
                </div>
                <div class="pros_price">
                    <p class="price"><strong>¥${product.productPrice}</strong><span>起</span></p>
                    <p class="collect">
                    <input type="hidden" id="productId" value="${product.id}"/>
                        <input type="hidden" id="uid" value="${uid}" />
                        <c:choose>
                            <c:when test="${isFavourite==true}">
                                <a class="btn" id="favourite"  onclick="changeFavourite(1)"><i class="glyphicon glyphicon-heart-empty"></i>取消收藏</a>
                            </c:when>
                            <c:when test="${isFavourite==false}">
                                <a  class="btn already" id="favourite"onclick="changeFavourite(1)" ><i class="glyphicon glyphicon-heart-empty"></i>点击收藏</a>
                            </c:when>
                        </c:choose>
                        <span id="favouriteTimes">已被收藏${product.isFavourTimes}次</span>
                    </p>
                </div>        
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

<script>
    $(document).ready(function() {
        //焦点图效果
        //点击图片切换图片
        $('.little_img').on('mousemove', function() {
            $('.little_img').removeClass('cur_img');
            var big_pic = $(this).data('bigpic');
            $('.big_img').attr('src', big_pic);
            $(this).addClass('cur_img');
        });
        //上下切换
        var picindex = 0;
        var nextindex = 4;
        $('.down_img').on('click',function(){
            var num = $('.little_img').length;
            if((nextindex + 1) <= num){
                $('.little_img:eq('+picindex+')').hide();
                $('.little_img:eq('+nextindex+')').show();
                picindex = picindex + 1;
                nextindex = nextindex + 1;
            }
        });
        $('.up_img').on('click',function(){
            var num = $('.little_img').length;
            if(picindex > 0){
                $('.little_img:eq('+(nextindex-1)+')').hide();
                $('.little_img:eq('+(picindex-1)+')').show();
                picindex = picindex - 1;
                nextindex = nextindex - 1;
            }
        });
        //自动播放
        // var timer = setInterval("auto_play()", 5000);
    });

    //自动轮播方法
    function auto_play() {
        var cur_index = $('.prosum_left dd').find('a.cur_img').index();
        cur_index = cur_index - 1;
        var num = $('.little_img').length;
        var max_index = 3;
        if ((num - 1) < 3) {
            max_index = num - 1;
        }
        if (cur_index < max_index) {
            var next_index = cur_index + 1;
            var big_pic = $('.little_img:eq(' + next_index + ')').data('bigpic');
            $('.little_img').removeClass('cur_img');
            $('.little_img:eq(' + next_index + ')').addClass('cur_img');
            $('.big_img').attr('src', big_pic);
        } else {
            var big_pic = $('.little_img:eq(0)').data('bigpic');
            $('.little_img').removeClass('cur_img');
            $('.little_img:eq(0)').addClass('cur_img');
            $('.big_img').attr('src', big_pic);
        }
    }





        function changeFavourite(da) {
            console.log("进去咯");
            var target = $("#favourite");
            $.get({
                url:"${pageContext.request.contextPath}/product/changeFavourite",
                data:{uid:$("#uid").val(),
                    productId:$("#productId").val()
                },
                success:function (data) {
                    data=JSON.parse(data);
                    if (data.flag == true)
                    {
                        target.html("<i class=\"glyphicon glyphicon-heart-empty\"></i>取消收藏");
                        target.removeClass("already");
                    }else{
                        target.html("<i class=\"glyphicon glyphicon-heart-empty\"></i>点击收藏");
                        target.addClass("already");
                    }
                    $("#favouriteTimes").html("已被收藏"+data.favouriteTimes+"次")
                }
            })
        }



    </script>
</body>

</html>