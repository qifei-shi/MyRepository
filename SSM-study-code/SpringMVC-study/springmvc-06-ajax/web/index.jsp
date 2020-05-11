<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.0.js"></script>
  <script>
    function a(){
      $.post({
        url:"${pageContext.request.contextPath}/a1",
        data:{"name":$("#username").val()},
      success:function (data) {
            alert(data);
      }
      })
    }

  </script>
  <body>

  <%--失去一个焦点的时候，发起一个请求(携带信息)到后台--%>
  用户名：<input type="text" id="username" onblur="a()">

  </body>
</html>
