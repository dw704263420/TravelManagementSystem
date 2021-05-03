<%--
  Created by IntelliJ IDEA.
  User: 70426
  Date: 2021/4/8
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js"></script>
<script>


    $(function(){
        $("#btn").click(function () {
            $.post("${pageContext.request.contextPath}/a2",function (data) {
                console.log(data);
                // 增加节点
                var html="<>";
                for (var i=0;i<data.length;i++)
                {
                    html+="<tr>"+"<td>"+data[i].name+"</td>"+"</tr>"
                }
                $("#content").html(html);
            });

        })


    });

</script>
<body>
<input type="button" value="加载数据" id="btn">
<table>
    <thead>
    <tr>姓名</tr>
    </thead>
    <tbody id="content">

    </tbody>
</table>
</body>
</html>
