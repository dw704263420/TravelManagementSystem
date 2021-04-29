<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 头部 start -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/include.js"></script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

    <header id="header">
        <div class="top_banner">
            <img src="${pageContext.request.contextPath}/images/top_banner.jpg" alt="">
        </div>
        <div class="shortcut">
            <!-- 未登录状态  -->
            <div class="login_out" id="logout">
                <a href="${pageContext.request.contextPath}/pages/user_login.jsp">登录</a>
                <a href="${pageContext.request.contextPath}/pages/user_register.jsp">注册</a>
            </div>
            <!-- 登录状态  -->
            <div class="login" id="login">
            	
                <span id="span_username"></span>
                <a href="${pageContext.request.contextPath}/product/MyFavourite?uid=${uid}" class="collection">我的收藏</a>
                <a href="${pageContext.request.contextPath}/user/userLogout">退出</a>
            </div>
        </div>
        <div class="header_wrap">
            <div class="topbar">
                <div class="logo">
                    <a href="/"><img src="${pageContext.request.contextPath}/images/logo.jpg" alt=""></a>
                </div>
                <div class="search">
                    <form action="${pageContext.request.contextPath}/product/findAllProduct" method="get">
                        <input name="keyWord" id="search" type="text" placeholder="请输入路线名称" class="search_input" autocomplete="off" value="${keyWord}">
                        <input type="submit" class="search-button" value="搜索">
                    </form>
                </div>
                <div class="hottel">
                    <div class="hot_pic">
                        <img src="${pageContext.request.contextPath}/images/hot_tel.jpg" alt="">
                    </div>
                    <div class="hot_tel">
                        <p class="hot_time">客服热线(9:00-6:00)</p>
                        <p class="hot_num">400-618-9090</p>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- 头部 end -->
     <!-- 首页导航 -->
    <div class="navitem">
        <ul class="nav" id="category">
            <li class="nav-active"><a href="index.html">首页</a></li>
        </ul>
    </div>
<script>
    $(function () {
        $.get({
            url:"${pageContext.request.contextPath}/user/findUser",
            data:{},
            success:function (data) {
                data = JSON.parse(data);
                if (data!=null)
                {   $("#logout").remove();
                    $("#span_username").html("欢迎回来："+data);
                }else{
                    $("#login").remove();
                }
            }
        });

        $.get({
            url:"${pageContext.request.contextPath}/category/findAll",
            data:{},
            success:function (data) {
                data= JSON.parse(data);
                console.log(data);
                let lis = '<li class="nav-active"><a href="${pageContext.request.contextPath}/pages/user_index.jsp">首页</a></li>';
                // 遍历数组 拼合字符串
                for (var i = 0; i < data.length; i++) {
                    let li='<li ><a href="'+"${pageContext.request.contextPath}"+'/product/findAllProduct?cid='+(i+1)+'">'+data[i].cname+'</a></li>';
                    lis+=li;
                }

                // 最后拼上 收藏排行榜

                lis+='<li ><a href="'+"${pageContext.request.contextPath}"+'/product/TopFavourite">收藏排行榜</a></li>';
                $("#category").html(lis);

            }
        })




    })
</script>