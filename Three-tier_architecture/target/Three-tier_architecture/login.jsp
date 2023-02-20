<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>用户登录</title>
    <link href="images/login.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-3.3.1.js"></script>

</head>
<body>

<div id="login">

    <div id="top">
        <div id="top_left"><img src="images/login_03.gif"/></div>
        <div id="top_center"></div>
    </div>

    <div id="center">
        <div id="center_left"></div>
        <div id="center_middle">
            <div id="user">用 户
                <input type="text" id="username" name="textfield" value="admin"/>
            </div>
            <div id="password">密 码
                <input type="password" id="pwd" name="textfield2" value="123"/>
                <span>${msg}</span>
            </div>
            <div id="yzm">
                验证码
                <input type="text" id="code" style="width: 50px" value=""/>
                <span id="yzm1"></span>
            </div>
            <div id="btn" onclick="doLogin()"><a>登录</a><a href="#">清空</a></div>
            <%--javaScript：点击click事件--%>
        </div>
        <div id="center_right"></div>
    </div>
    <div id="down">
        <div id="down_left">
            <div id="inf">
                <span class="inf_text">版本信息</span>
                <span class="copyright">管理信息系统 2008 v2.0</span>
            </div>
        </div>
        <div id="down_center"></div>
    </div>
    <script>
        window.yzm()
            function randomNum(minNum, maxNum) {
                switch (arguments.length) {
                    case 1:
                        return parseInt(Math.random() * minNum + 1, 10);
                        break;
                    case 2:
                        return parseInt(Math.random() * (maxNum - minNum + 1) + minNum, 10);
                        break;
                    default:
                        return 0;
                        break;
                }
            }

          function yzm() {
                let val = $("#code").val().toUpperCase();
                var sz = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                    'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
                var str = ""
                for (let i = 0; i < 4; i++) {
                    str += sz.at(randomNum(0, 35))
                }
                $("#yzm1").append(str).css("color","red");

                if (val == str) {
                    return true;
                } else {
                    return false;
                }
            }
            function doLogin() {
                //通过id获取到对应输入框的值
                if (yzm()) {
                    var uname = document.getElementById("username").value;
                    var pwd = document.getElementById("pwd").value;
                    location.href = "http://localhost:8080/Three-tier_architecture/login?userName=" + uname + "&pwd=" + pwd;
                } else {
                    alert("验证码错误")
                }
            }



    </script>
</div>
</body>
</html>

