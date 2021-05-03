<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">


    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                产品管理 <small>产品表单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/product/findAll.do">产品管理</a></li>
                <li class="active">产品表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <form action="${pageContext.request.contextPath}/product/updateProduct.do"
              method="post">
            <input type="hidden" name="id" value="${product.id}">
            <!-- 正文区域 -->
            <section class="content"> <!--产品信息-->

                <div class="panel panel-default">
                    <div class="panel-heading">产品信息</div>
                    <div class="row data-type">

                        <div class="col-md-2 title">产品编号</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="productNum"
                                   placeholder="产品编号" value="${product.productNum}">
                        </div>
                        <div class="col-md-2 title">产品名称</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="productName"
                                   placeholder="产品名称" value="${product.productName}"}>
                        </div>
                        <div class="col-md-2 title">产品类别</div>
                        <div class="col-md-4 data">
                            <select class="form-control select2" style="width: 100%"
                                    name="cid">
                            <c:forEach items="${categoryList}" var="c" varStatus="id">
                            <c:if test="${id.index+1 eq product.cid}">
                                    <option value="${id.index+1}" selected="selected">${c.cname}</option>
                            </c:if>
                                <c:if test="${id.index+1 ne product.cid}">
                                    <option value="${id.index+1}" >${c.cname}</option>
                                </c:if>

                            </c:forEach>


                            </select>
                        </div>


                        <div class="col-md-2 title">出发城市</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="cityName"
                                   placeholder="出发城市" value="${product.cityName}">
                        </div>

                        <div class="col-md-2 title">产品价格</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="产品价格"
                                   name="productPrice" value="${product.productPrice}">
                        </div>

                        <div class="col-md-2 title">产品状态</div>
                        <div class="col-md-4 data">
                            <select class="form-control select2" style="width: 100%"
                                    name="productStatus">
                                <c:if test="${product.productStatus==1}">
                                    <option value="0" >关闭</option>
                                    <option value="1" selected="selected">开启</option>
                                </c:if>
                                <c:if test="${product.productStatus==0}">
                                    <option value="0" selected="selected" >关闭</option>
                                    <option value="1" >开启</option>
                                </c:if>

                            </select>
                        </div>

                        <div class="col-md-2 title rowHeight2x">其他信息</div>
                        <div class="col-md-10 data rowHeight2x">
							<textarea class="form-control" rows="3" placeholder="其他信息"
                                      name="productDesc"   >${product.productDesc}</textarea>
                        </div>

                    </div>
                    <!--数据列表-->

<%--                    图片管理表格--%>

                </div>
                <!--订单信息/--> <!--工具栏-->
                <div class="box-tools text-center">
                    <button type="submit" class="btn bg-maroon">保存</button>
                    <button type="button" class="btn bg-default"
                            onclick="history.back(-1);">返回</button>
                </div>
                <!--工具栏/-->



            </section>
            <!-- 正文区域 /-->
        </form>
        <section class="content">

            <div class="panel panel-default">
                <div class="panel-heading">产品预览信息</div>
                <div class="row data-type">
            <div class="btn-group">
                <div class="alert alert-danger" role="alert" style="display: none" id="alter-danger"><p>
                    存在不合法输入！请校验后再提交订单。
                </p></div>
               <div>
                   <form id="addThumbnail" action="${pageContext.request.contextPath}/routeImage/addThumbnail" method="post" enctype="multipart/form-data" style="display: inline">
                       <input type="hidden" name="rid" value="${product.id}">
                       <a href="javascript:;"   class="btn btn-primary">添加缩略图(大图)
                           <input type="file"  accept=".jpg,.png"  name="bigPicFile"  id = "thumbnailPicBig">
                       </a>
                       <a href="javascript:;"   class="btn btn-primary">添加缩略图（小图）
                           <input type="file"  accept=".jpg,.png"  name="smallPicFile"  id = "thumbnailPicSmall">
                       </a>

                   </form>
                   <button class="btn btn-primary" id="addThumbnailBtn" style="display: inline;float: right;align-content: center;height: 56px" >提交</button>

               </div>
                <div>
                    <form id="changeCover" action="${pageContext.request.contextPath}/routeImage/changeCover" method="post" enctype="multipart/form-data" style="display: inline">
                        <input type="hidden" name="rid" value="${product.id}">
                        <a href="javascript:;"   class="btn btn-primary">更换封面图
                            <input type="file"  accept=".jpg,.png"  name="coverPicFile"  id = "coverPic">
                        </a>
                    </form>
                    <button class="btn btn-primary" id="changeCoverBtn" style="display: inline;align-content: center;height: 56px" >提交</button>

                </div>
            </div>
            <table id="dataList"
                   class="table table-bordered table-striped table-hover dataTable">
                <thead>
                <tr>
                    <th class="" style="padding-right: 0px;"><input
                            id="selall" type="checkbox" class="icheckbox_square-blue">
                    </th>
                    <th class="sorting_asc">ID</th>
                    <th class="sorting_desc">大图路径</th>
                    <th class="sorting_desc">缩略图路径</th>
                    <th class="text-center">操作</th>
                </tr>
                </thead>
                <tbody>


                <c:forEach items="${product.routeImgList}" var="img" >
                    <tr>
                        <td><input value="${img.rgid}" name="ids" type="checkbox"></td>
                        <td>${img.rgid}</td>
                        <td>${img.smallPic}</td>
                        <td>${img.bigPic}</td>
                        <td class="text-center">
                            <button type="button" class="btn bg-olive btn-xs" onclick="location.href='${pageContext.request.contextPath}/routeImage/deleteById.do?rgid=${img.rgid}&&rid=${product.id}'">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
                    <%--                    展示--%>
                    <table id="dataList"
                           class="table table-bordered table-striped table-hover dataTable">
                        <thead>
                        <tr>

                            <th class="sorting_desc">封面图片保存路径</th>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>



                        <tr>

                            <td>${product.rimage}</td>

                            <td class="text-center">
                                <button type="button" class="btn bg-olive btn-xs" onclick="location.href='${pageContext.request.contextPath}/${product.rimage}'">查看大图</button>
                            </td>
                        </tr>

                        </tbody>
                    </table>

            <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-success">预览效果</button>
            </div>
            <div class="wrap">
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

                        </div>
                    </div>
                </div>
            </div>
                </div>
        </section>
    </div>
    <!-- 内容区域 /-->







    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2014-2017 <a
                href="http://www.itcast.cn">研究院研发部</a>.
        </strong> All rights reserved. </footer>
    <!-- 底部导航 /-->

</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/route-detail.css">
<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

<script>

    $("#addThumbnailBtn").click(function () {
        var content2 =$("#thumbnailPicBig").val();
        var content1 =$("#thumbnailPicSmall").val();
        if (content1=='' || content2=='')
        {
            $("#alter-danger").html('<p>\n' +
                '                图片表单输入不合法！请校验后再尝试。\n' +
                '            </p>');
            $("#alter-danger").css("display","block");
            return;
        }else
        {
            $("#alter-danger").css("display","none");
        }

        $("#addThumbnail").submit();
    });


    $("#changeCoverBtn").click(function () {

        var content1 =$("#coverPic").val();
        if (content1=='')
        {
            $("#alter-danger").html('<p>\n' +
                '                图片表单输入不合法！请校验后再尝试。\n' +
                '            </p>');
            $("#alter-danger").css("display","block");
            return;
        }else
        {
            $("#alter-danger").css("display","none");
        }

        $("#changeCover").submit();
    });


    $(document).ready(function() {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale : 'zh-CN'
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function() {

        $('#datepicker-a3').datetimepicker({
            forceParse: 0,//设置为0，时间不会跳转1899，会显示当前时间。
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd hh:mm',//显示格式
            minView: "month",//设置只显示到月份
            initialDate: new Date(),//初始化当前日期
            autoclose: true,//选中自动关闭
            todayBtn: true//显示今日按钮

        });


    });

    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("order-manage");
        $("#datepicker-a3").datetimepicker({
            format : "yyyy-mm-dd hh:ii",
            locale: moment.locale('zh-cn'),

        });

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

</script>


</body>

</html>