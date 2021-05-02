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
        <a href="#">${product.productName}</a><span> &gt;订单填写</span>

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
                    <span id="favouriteTimes">已被收藏${product.isFavourTimes}次</span>
                </p>
            </div>
        </div>
    </div>
    <div class="you_need_konw">
        <span>订单填写</span>
        <div class="notice">
            <!--联系人信息-->
            <div class="panel panel-default">
                <div class="panel-heading">联系人信息</div>
                <div class="row data-type">

                    <%--后台导入该账号 值即可--%>
                    <div class="col-md-2 title">会员</div>
                    <div class="col-md-4 data text">${uuser.username}</div>

                    <div class="col-md-2 title">联系人</div>
                    <div class="col-md-4 data text">${uuser.trueName}</div>

                    <div class="col-md-2 title">手机号</div>
                    <div class="col-md-4 data text">${uuser.phoneNum} </div>

                    <div class="col-md-2 title">邮箱</div>
                    <div class="col-md-4 data text"> ${uuser.email} </div>

                </div>
            </div>


            <div class="alert alert-danger" role="alert" style="display: none" id="alter-danger"><p>
                存在不合法输入！请校验后再提交订单。
            </p></div>
            <form id="travellerInfomation" action="${pageContext.request.contextPath}/orders/submitOrder2" method="post">

                <%--游客信息--%>
                <div class="panel panel-default">
                    <div class="panel-heading" >游客信息</div>
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
                        <tbody id= "user-content">
                        <input type="hidden" name = "uid"  value="${uuser.id}">
                        <input type="hidden" name="productId" value="${product.id}">


                        <tr  >
                            <td><select name="travellerType" >

                                <option value="0">成年人</option>
                                <option value="1">未成年人</option>
                            </select></td>
                            <td>
                                <input type="text" name="name" class="name" size="10"
                                       placeholder="姓名">

                            </td>
                            <td>
                                <select name="sex" >
                                    <option value="0">男性</option>
                                    <option value="1">女性</option>
                                </select>
                            </td>
                            <td><input type="text" name="phoneNum" class="phoneNum" size="20"
                                       placeholder="手机号码"  ></td>
                            <td><select name="credentialsType" >
                                <option value="0">身份证</option>
                                <option value="1">护照</option>
                                <option value="2">军官证</option>
                            </select></td>
                            <td><input type="text" name="credentialsNum" class="credentialsNum" size="28"
                                       placeholder="证件号码"     >

                            </td>
                        </tr>


                        </tbody>
                    </table>

                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-info dropdown-toggle" id="add-user" onclick="addUser(1)" >添加游客 </button>


                </div>
            </form>
            <button type="submit" class="btn btn-primary dropdown-toggle" id="submit">提交表单</button>




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
    $("#submit").click(function () {
        var targets = $(".name");
        $(".name").each(function () {
            var content =$(this).val();
            var reg_name = /^[\u4E00-\u9FA5]{2,5}$/;
            var flag = reg_name.test(content);
            if (flag== false)
            {
                $("#alter-danger").html('<p>\n' +
                    '                姓名输入不合法！请输入正确的中文姓名，请校验后再提交订单。\n' +
                    '            </p>');
                $("#alter-danger").css("display","block");
                return;
            }else
            {
                $("#alter-danger").css("display","none");
            }
        $(".phoneNum").each(function () {
            var content =$(this).val();
            var reg_phoneNum=/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
            var flag =reg_phoneNum.test(content);
            if (flag== false)
            {
                $("#alter-danger").html('<p>\n' +
                    '                手机号码输入不合法！请校验后再提交订单。\n' +
                    '            </p>');
                $("#alter-danger").css("display","block");
                return;
            }else
            {
                $("#alter-danger").css("display","none");
            }
         $(".credentialsNum").each(function () {
             var content =$(this).val();
             var reg_creadentialsNum =  /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
             var flag = reg_creadentialsNum.test(content);
             if (flag== false)
             {
                 $("#alter-danger").html('<p>\n' +
                     '                证件号码输入不合法！请校验后再提交订单。\n' +
                     '            </p>');
                 $("#alter-danger").css("display","block");
                 return;
             }else
             {
                 $("#alter-danger").css("display","none");
             }
         })
          $("#travellerInfomation").submit();


        })


        })
    });

    //扩展jquery的格式化方法
$.fn.parseForm=function(){
    var serializeObj={};
    var array=this.serializeArray();
    var str=this.serialize();
    $(array).each(function(){
        if(serializeObj[this.name]){
            if($.isArray(serializeObj[this.name])){
                serializeObj[this.name].push(this.value);
            }else{
                serializeObj[this.name]=[serializeObj[this.name],this.value];
            }
        }else{
            serializeObj[this.name]=this.value;
        }
    });
    return serializeObj;
};

        $("#submitForm").click(function () {
            var content=$("#travellerInfomation").parseForm();

            alert(typeof content);
            $.post({
                url:"${pageContext.request.contextPath}/product/submitOrder",
                data:content,
                success:function (data) {
                    console.log(data);
                }
            })
        });




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

// 添加游客栏
    function addUser(num) {
        var content =' <tr  >\n' +
            '                            <td><select name="travellerType" >\n' +
            '\n' +
            '                                <option value="0">成年人</option>\n' +
            '                                <option value="1">未成年人</option>\n' +
            '                            </select></td>\n' +
            '                            <td>\n' +
            '                                <input type="text" name="name" class="name" size="10"\n' +
            '                                       placeholder="姓名">\n' +
            '\n' +
            '                            </td>\n' +
            '                            <td>\n' +
            '                                <select name="sex" >\n' +
            '                                    <option value="0">男性</option>\n' +
            '                                    <option value="1">女性</option>\n' +
            '                                </select>\n' +
            '                            </td>\n' +
            '                            <td><input type="text" name="phoneNum" class="phoneNum" size="20"\n' +
            '                                       placeholder="手机号码"  ></td>\n' +
            '                            <td><select name="credentialsType" >\n' +
            '                                <option value="0">身份证</option>\n' +
            '                                <option value="1">护照</option>\n' +
            '                                <option value="2">军官证</option>\n' +
            '                            </select></td>\n' +
            '                            <td><input type="text" name="credentialsNum" class="credentialsNum" size="28"\n' +
            '                                       placeholder="证件号码"     >\n' +
            '\n' +
            '                            </td>\n' +
            '                        </tr>';
        $("#user-content").append(content);
    }







</script>
</body>

</html>