<%--
  Created by IntelliJ IDEA.
  User: 14327
  Date: 2020/12/5
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>天天生鲜－登录</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script src="js/login.js"></script>
</head>
<body>

<div class="login_top clearfix">
    <a href="indexServlet" class="login_logo"><img src="images/logo.png"></a>
</div>

<div class="login_form_bg">
    <div class="login_form_wrap clearfix">
        <div class="login_banner fl"></div>
        <div class="slogan fl">日夜兼程 · 急速送达</div>
        <div class="login_form fr">
            <div class="login_title clearfix">
                <h1>用户登录</h1>
                <a href="register.jsp">立即注册</a>
            </div>
            <div class="form_input">
                <form action="loginServlet" method="post" id="from_login">
                    <input type="text" name="username" id="username" class="name_input" placeholder="请输入用户" value="">
                    <div class="user_error">输入错误</div>
                    <input type="password" name="pwd" id="pwd" class="pass_input" placeholder="请输入密码" value="">
                    <div class="pwd_error" style="display: none;">输入错误</div>

<%--                    <img src="images/error.png" alt="captcha" class="captcha">--%>
                    <img class="captcha" style="width: 100px;height: 35px" id="imageCode" alt="captcha" src="ImageServlet" onclick="reloadCode()">

                    <input autocapitalize="off" autocomplete="off" autocorrect="off" spellcheck="false" id="id_captcha_1" name="captcha_1" type="text" placeholder="请输入验证码">
                    <div class="yanzheng_error">请输入验证码</div>
                    <div class="more_input clearfix">
                        <input type="checkbox" name="" id="" checked="checked">
                        <label>记住用户名</label>
                        <a href="#">忘记密码</a>
                    </div>
                    <input type="submit" name="" value="登录" class="input_submit">
                </form>
            </div>
            <div style="color: red;transform:translateX(40%);">${requestScope.msg}</div>
        </div>
    </div>
</div>

<div class="footer login_footer">
    <div class="links">
        <a href="">关于软帝</a>
        <span>|</span>
        <a href="">热门培训</a>
        <span>|</span>
        <a href="">联系我们</a>
        <span>|</span>
        <a href="">在线报名</a>
    </div>
    <p>CopyRight © 2019 武汉软帝信息科技有限责任公司</p>
</div>
</body>
<script>
    function reloadCode(){
        var time=new Date().getTime();
        //由于传过去的时间不一样，所以不是同一个请求
        document.getElementById("imageCode").src="<%=request.getContextPath()%>/ImageServlet?d="+time;
    }
</script>
</html>
