<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<script src="statics/js/jquery-3.5.0.js"></script>
<script>

        function a1() {
            $.post({
                url:"${pageContext.request.contextPath}/a3",
                data:{"name":$("#name").val()},
                success:function (data) {
                    console.log(data);
                    if (data==="ok"){
                        $("#userInfo").css("color","green").html(data);
                    }else {
                        $("#userInfo").css("color","red").html(data);
                    }

            }
            });
        }
        function b1() {
            $.post("${pageContext.request.contextPath}/a3",{"pwd":$("#pwd").val()},function (data) {
                console.log(data);
                if (data==="ok"){
                    $("#pwdInfo").css("color","green").html(data);
                }else {
                    $("#pwdInfo").css("color","red").html(data);
                }
            })

        }
</script>

<body>
<p>
    用户名: <input type="text" id="name" onblur="a1()">
    <span id="userInfo"></span>
</p>
<p>
    密  码 : <input type= "text" id="pwd" onblur="b1()">
    <span id="pwdInfo"></span>
</p>

</body>
</html>
