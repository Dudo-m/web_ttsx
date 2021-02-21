<%--
  Created by IntelliJ IDEA.
  User: 14327
  Date: 2020/12/7
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>天天生鲜－购物车</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
</head>
<body>

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

<div class="search_bar clearfix">
    <a href="indexServlet" class="logo fl"><img src="images/logo.png"></a>
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;购物车</div>
    <div class="search_con fr">
        <form method="get" action="searchGoodByFenYe" target="_blank">
            <input type="hidden" name="pageNum" value="1">
            <input type="text" class="input_text fl" name="search" placeholder="搜索商品">
            <input type="submit" class="input_btn fr" value="搜索">
        </form>
    </div>
</div>

<div class="total_count">全部商品<em>${sessionScope.shop_size}</em>件</div>
<ul class="cart_list_th clearfix">
    <li class="col01">商品名称</li>
    <li class="col02">商品单位</li>
    <li class="col03">商品单价</li>
    <li class="col04">数量</li>
    <li class="col05">小计</li>
    <li class="col06">操作</li>
</ul>

<c:forEach var="shop" items="${requestScope.shop}">
        <ul class="cart_list_td clearfix" id="232">
            <li class="col01"><input type="checkbox" name="" checked=""></li>
            <li class="col02"><img src="images/所有商品/${shop.good.gImage}"></li>
            <li class="col03">${shop.good.gName}<br><em>${shop.good.gPrice}/${shop.good.gCompany}</em></li>
            <li class="col04">${shop.good.gCompany}</li>
            <li class="col05">${shop.good.gPrice}</li>
            <li class="col06">
                <div class="num_add">
                    <a href="javascript:;" class="add fl">+</a>
                    <input type="text" class="num_show fl" value="${shop.num}">
                    <a href="javascript:;" class="minus fl">-</a>
                    <span class="kucun" style="display: none">978</span>
                    <span class="goodsid" style="display: none">44</span>
                </div>
            </li>
            <li class="col07">${shop.good.gPrice}</li>
            <li class="col08"><a href="deleteShopServlet?gId=${shop.good.gId}">删除</a></li>
        </ul>
</c:forEach>

<%--<ul class="cart_list_td clearfix" id="233">--%>
<%--    <li class="col01"><input type="checkbox" name="" checked=""></li>--%>
<%--    <li class="col02"><img src="images/所有商品/5b18c158N35a55d7a.jpg"></li>--%>
<%--    <li class="col03">中科农业 水果礼盒 水果提货券 礼券 238型 水果提货卡券<br><em>238.00元/5.0kg</em></li>--%>
<%--    <li class="col04">5.0kg</li>--%>
<%--    <li class="col05">238.00元</li>--%>
<%--    <li class="col06">--%>
<%--        <div class="num_add">--%>
<%--            <a href="javascript:;" class="add fl">+</a>--%>
<%--            <input type="text" class="num_show fl" value="1">--%>
<%--            <a href="javascript:;" class="minus fl">-</a>--%>
<%--            <span class="kucun" style="display: none">994</span>--%>
<%--            <span class="goodsid" style="display: none">37</span>--%>
<%--        </div>--%>
<%--    </li>--%>
<%--    <li class="col07">238.00元</li>--%>
<%--    <li class="col08"><a href="#">删除</a></li>--%>

<%--</ul>--%>

<%--<ul class="cart_list_td clearfix" id="234">--%>
<%--    <li class="col01"><input type="checkbox" name="" checked=""></li>--%>
<%--    <li class="col02"><img src="images/所有商品/5b514c51N8170488f.jpg"></li>--%>
<%--    <li class="col03">维叶新鲜水果香蕉约17-23条天宝水果生鲜青蕉 香蕉17-2<br><em>29.90元/750g</em></li>--%>
<%--    <li class="col04">750g</li>--%>
<%--    <li class="col05">29.90元</li>--%>
<%--    <li class="col06">--%>
<%--        <div class="num_add">--%>
<%--            <a href="javascript:;" class="add fl">+</a>--%>
<%--            <input type="text" class="num_show fl" value="1">--%>
<%--            <a href="javascript:;" class="minus fl">-</a>--%>
<%--            <span class="kucun" style="display: none">1075</span>--%>
<%--            <span class="goodsid" style="display: none">33</span>--%>
<%--        </div>--%>
<%--    </li>--%>
<%--    <li class="col07">29.90元</li>--%>
<%--    <li class="col08"><a href="#">删除</a></li>--%>

<%--</ul>--%>


<ul class="settlements">
    <li class="col01"><input type="checkbox" id="check_all" name="" checked=""></li>
    <li class="col02">全选</li>
    <li class="col03">合计(不含运费)：<span>¥</span><em id="zong">365.90</em><br>共计<b id="zongshu">${sessionScope.shop_size}</b>件商品</li>
    <li class="col04"><a href="javascript:;" id="jiesuan" style="background-color: rgb(255, 61, 61);">去结算</a></li>
</ul>

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
</html>
<script type="text/javascript" src="js/shop.js"></script>

