<%--
  Created by IntelliJ IDEA.
  User: 14327
  Date: 2020/12/7
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>天天生鲜－商品列表</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.12.4.min.js.下载"></script>
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

<div class="search_bar clearfix">
    <a href="indexServlet" class="logo fl"><img src="images/logo.png"></a>
    <div class="search_con fl">
        <form method="get" action="searchGoodByFenYe" target="_blank">
            <input type="hidden" name="pageNum" value="1">
            <input type="text" class="input_text fl" name="search" placeholder="搜索商品">
            <input type="submit" class="input_btn fr" value="搜索">
        </form>
    </div>
    <c:if test="${sessionScope.user!=null}">
        <div class="guest_cart fr">
            <a href="ShopShowServlet" class="cart_name fl">我的购物车</a>
            <div class="goods_count fl" id="show_count">${sessionScope.shop_size}</div>
        </div>
    </c:if>
</div>

<div class="navbar_con">
    <div class="navbar clearfix">
        <div class="subnav_con fl">
            <h1>全部商品分类</h1>
            <span></span>
            <ul class="subnav">
                <li><a href="#" class="fruit">新鲜水果</a></li>
                <li><a href="#" class="seafood">海鲜水产</a></li>
                <li><a href="#" class="meet">猪牛羊肉</a></li>
                <li><a href="#" class="egg">禽类蛋品</a></li>
                <li><a href="#" class="vegetables">新鲜蔬菜</a></li>
                <li><a href="#" class="ice">速冻食品</a></li>
            </ul>
        </div>
        <ul class="navlist fl">
            <li><a href="indexServlet">首页</a></li>
            <li class="interval">|</li>
            <li><a href="#">手机生鲜</a></li>
            <li class="interval">|</li>
            <li><a href="#">抽奖</a></li>
        </ul>
    </div>
</div>

<div class="breadcrumb">
    <a href="indexServlet">全部分类</a>
    <span>&gt;</span>
    <span>全部商品</span>
</div>

<div class="main_wrap clearfix">
    <div class="l_wrap fl clearfix">
        <div class="new_goods">
            <h3>新品推荐</h3>
            <ul>
                <li>
                    <a href="shop_message.html"><img src="images/所有商品/57ab290aN34f76b37.jpg"></a>
                    <h4><a href="shop_message.html"> 越南进口红心火龙果 3个装 大果 单果约450~500g </a></h4>
                    <div class="prize">￥33.90</div>
                </li>

                <li>
                    <a href="shop_message.html"><img src="images/所有商品/5b4871e6N072f0d74.jpg"></a>
                    <h4><a href="shop_message.html">寻天果蔬 泰国山竹水果 京东生鲜 5A级 热带水果 2.5k</a></h4>
                    <div class="prize">￥98.00</div>
                </li>


            </ul>
        </div>
    </div>

    <div class="r_wrap fr clearfix">
        <div class="sort_bar">

            <a href="#" class="active">默认</a>
            <a href="#">价格</a>
            <a href="#">人气</a>

        </div>

        <ul class="goods_type_list clearfix">
            <c:forEach var="good" items="${requestScope.page.data}">
                <li>
                    <a href="selectGoodById?gId=${good.gId}"><img src="images/所有商品/${good.gImage}"></a>
                    <h4><a href="selectGoodById?gId=${good.gId}">${good.gName}</a></h4>
                    <div class="operate">
                        <span class="prize">￥${good.gPrice}</span>
                        <span class="unit">${good.gPrice}/${good.gCompany}</span>
                        <a href="javascript:;" class="add_goods" title="加入购物车"></a>
                        <span id="spanid" style="display: none">45</span>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <div class="pagenation">
                <a href="selectGoodByFenYe?pageNum=1">首页</a>
                <a href="selectGoodByFenYe?pageNum=${requestScope.page.previous}">上一页</a>
                <a href="selectGoodByFenYe?pageNum=${requestScope.page.next}">下一页</a>
                <a href="selectGoodByFenYe?pageNum=${requestScope.page.last}">尾页</a>
        </div>
    </div>
</div>

<!--底部 开始-->
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
<!--底部 结束-->

<script>
    $(".add_goods").click(function () {

        $.get("/cart/updatecart/add/1/"+$(this).next().html()+"/1",function (data) {
            if (data.data != 0){
                $("#show_count").html(data.data);
            }
        });

    });
</script>
</body>
</html>