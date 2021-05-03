
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
<%--  <script src="js/jquery-2.1.1.min%5B1%5D.js">--%>
<%-- 遵循mvc的资源放置位置吧--%>
<%--  </script>--%>

  <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js">

  </script>
  <script>
    // $.ajax()
    function inputBlur() {
      var val = $("#username").val();
      $.post({
        url:"${pageContext.request.contextPath}/a1",
        data:{
          "name":val
        },
      success:function (data) {

          alert(data)

      }

              })
    }
  </script>
  <body>
<%--  失去焦点发起请求，要用到JavaScript,用jquery--%>
<label for=""> 用户名</label> <input type="text" onblur="inputBlur()" name="username" id="username">
  </body>
</html>
