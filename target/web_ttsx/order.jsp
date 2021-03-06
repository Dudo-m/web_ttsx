<%--
  Created by IntelliJ IDEA.
  User: 14327
  Date: 2020/12/8
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>天天生鲜－我的订单</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<!--头部开始-->
<div class="header_con">
    <div class="header">
        <div class="welcome fl">欢迎来到天天生鲜!</div>
        <div class="login_btn fl"><a href="http://www.softeem.com/web1/index.php" style="margin-left:30px" target="_blank">软帝项目</a></div>
        <div class="fr">
            <c:if test="${sessionScope.user != null}">
                <div class="login_info fl" style="display: block">
                    欢迎您：<em>${sessionScope.user.user_account}</em>
                    <a href="logoutServlet" class="zhuxiao">注销</a>
                </div>
                <div class="user_link fl">
                    <span>|</span>
                    <a href="customer.jsp">用户中心</a>
                    <span>|</span>
                    <a href="ShopShowServlet">我的购物车</a>
                    <span>|</span>
                    <a href="#">我的订单</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <div class="login_btn fl">
                    <a href="login.jsp">登录</a>
                    <span>|</span>
                    <a href="register.jsp">注册</a>
                </div>
            </c:if>
        </div>
    </div>
</div>
<!--头部结束-->

<!--内容  开始-->
<div class="search_bar clearfix">
    <a href="indexServlet" class="logo fl"><img src="images/logo.png"></a>
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
    <div class="search_con fr">
        <form method="get" action="searchGoodByFenYe" target="_blank">
            <input type="hidden" name="pageNum" value="1">
            <input type="text" class="input_text fl" name="search" placeholder="搜索商品">
            <input type="submit" class="input_btn fr" value="搜索">
        </form>
    </div>
</div>
<div class="main_con clearfix">
    <div class="left_menu_con clearfix">
        <h3>用户中心</h3>
        <ul>

            <li><a href="customer.jsp">· 个人信息</a></li>
            <li><a href="#" class="active">· 全部订单</a></li>
            <li><a href="showAddressServlet">· 收货地址</a></li>

        </ul>
    </div>

    <div class="right_content clearfix">
        <h3 class="common_title2">全部订单</h3>

        <div class="pagenation">
            <a class="active">1</a>
        </div>
    </div>
</div>
<!--内容  结束-->

<!--底部  开始-->
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
<!--内容  结束-->
</body>
</html>
