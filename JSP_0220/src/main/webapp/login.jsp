<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>用户登录</title>
    <link href="images/login.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="login">

    <div id="top">
        <div id="top_left"><img src="images/login_03.gif" /></div>
        <div id="top_center"></div>
    </div>

    <div id="center">
        <div id="center_left"></div>
        <div id="center_middle">
            <div id="user">用 户
                <input type="text" id="username" name="textfield" value="admin"/>
            </div>
            <div id="password">密   码
                <input type="password" id="pwd" name="textfield2" value="123" />
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
    function doLogin(){
           //通过id获取到对应输入框的值
        var uname=document.getElementById("username").value;
        var pwd=document.getElementById("pwd").value;
        alert("账号："+uname+",密码："+pwd)
    }
</script>
</div>
</body>
</html>

