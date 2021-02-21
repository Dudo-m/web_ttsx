<%--
  Created by IntelliJ IDEA.
  User: 14327
  Date: 2020/12/6
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>天天生鲜－首页</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/slide.js"></script>
</head>
<body>
<!--头部  开始-->
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
<!--头部 结束-->

<!--导航和轮播部分 开始-->
<div class="search_bar clearfix">
    <a href="#" class="logo fl"><img src="images/logo.png"></a>
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
    <div class="navbar">
        <h1 class="fl">全部商品分类</h1>
        <ul class="navlist fl">
            <li><a href="#">首页</a></li>
            <li class="interval">|</li>
            <li><a href="#">手机生鲜</a></li>
            <li class="interval">|</li>
            <li><a href="#">抽奖</a></li>
        </ul>
    </div>
</div>

<div class="center_con clearfix">
    <ul class="subnav fl">
        <li><a href="#model01" class="fruit">新鲜水果</a></li>
        <li><a href="#model02" class="seafood">海鲜水产</a></li>
        <li><a href="#model03" class="meet">猪牛羊肉</a></li>
        <li><a href="#model04" class="egg">禽类蛋品</a></li>
        <li><a href="#model05" class="vegetables">新鲜蔬菜</a></li>
        <li><a href="#model06" class="ice">速冻食品</a></li>
    </ul>
    <div class="slide fl">
        <ul class="slide_pics">
            <li><img src="images/所有商品/slide.jpg" alt="幻灯片"></li>
            <li><img src="images/所有商品/slide02.jpg" alt="幻灯片"></li>
            <li><img src="images/所有商品/slide03.jpg" alt="幻灯片"></li>
            <li><img src="images/所有商品/slide04.jpg" alt="幻灯片"></li>
        </ul>
        <div class="prev"></div>
        <div class="next"></div>
        <ul class="points"></ul>
    </div>

    <div class="adv fl">
        <a href="#"><img src="images/所有商品/adv01.jpg"></a>
        <a href="#"><img src="images/所有商品/adv02.jpg"></a>
    </div>
</div>
<!--导航和轮播部分 结束-->

<!--全部商品 开始-->
<div class="list_model">
    <div class="list_title clearfix">
        <h3 class="fl" id="model01">新鲜水果</h3>
        <div class="subtitle fl">
            <span>|</span>
            <c:forEach var="good" items="${requestScope.xxsg}">
                <a href="selectGoodById?gId=${good.gId}">${good.gName}</a>
            </c:forEach>
        </div>
        <a href="selectGoodByFenYe?pageNum=1" class="goods_more fr" id="fruit_more">查看更多 &gt;</a>
    </div>

    <div class="goods_con clearfix">
        <div class="goods_banner fl"><img src="images/所有商品/banner01.jpg"></div>
        <ul class="goods_list fl">
            <c:forEach var="good" items="${requestScope.xxsg}">
                <li>
                    <h4><a href="selectGoodById?gId=${good.gId}"> ${good.gName} </a></h4>
                    <a href="selectGoodById?gId=${good.gId}"><img src="images/所有商品/${good.gImage}"></a>
                    <div class="prize">¥ ${good.gPrice}</div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title clearfix">
        <h3 class="fl" id="model02">海鲜水产</h3>
        <div class="subtitle fl">
            <span>|</span>
            <c:forEach var="good" items="${requestScope.hcsx}">
                <a href="selectGoodById?gId=${good.gId}">${good.gName}</a>
            </c:forEach>
        </div>
        <a href="selectGoodByFenYe?pageNum=1" class="goods_more fr">查看更多 &gt;</a>
    </div>

    <div class="goods_con clearfix">
        <div class="goods_banner fl"><img src="images/所有商品/banner02.jpg"></div>
        <ul class="goods_list fl">
            <c:forEach var="good" items="${requestScope.hcsx}">
                <li>
                    <h4><a href="selectGoodById?gId=${good.gId}"> ${good.gName} </a></h4>
                    <a href="selectGoodById?gId=${good.gId}"><img src="images/所有商品/${good.gImage}"></a>
                    <div class="prize">¥ ${good.gPrice}</div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title clearfix">
        <h3 class="fl" id="model03">猪牛羊肉</h3>
        <div class="subtitle fl">
            <span>|</span>
            <c:forEach var="good" items="${requestScope.znyr}">
                <a href="selectGoodById?gId=${good.gId}">${good.gName}</a>
            </c:forEach>
        </div>
        <a href="selectGoodByFenYe?pageNum=1" class="goods_more fr">查看更多 &gt;</a>
    </div>

    <div class="goods_con clearfix">
        <div class="goods_banner fl"><img src="images/所有商品/banner03.jpg"></div>
        <ul class="goods_list fl">
            <c:forEach var="good" items="${requestScope.znyr}">
                <li>
                    <h4><a href="selectGoodById?gId=${good.gId}"> ${good.gName} </a></h4>
                    <a href="selectGoodById?gId=${good.gId}"><img src="images/所有商品/${good.gImage}"></a>
                    <div class="prize">¥ ${good.gPrice}</div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title clearfix">
        <h3 class="fl" id="model04">禽类蛋品</h3>
        <div class="subtitle fl">
            <span>|</span>
            <c:forEach var="good" items="${requestScope.qldp}">
                <a href="selectGoodById?gId=${good.gId}">${good.gName}</a>
            </c:forEach>
        </div>
        <a href="selectGoodByFenYe?pageNum=1" class="goods_more fr">查看更多 &gt;</a>
    </div>

    <div class="goods_con clearfix">
        <div class="goods_banner fl"><img src="images/所有商品/banner04.jpg"></div>
        <ul class="goods_list fl">
            <c:forEach var="good" items="${requestScope.qldp}">
                <li>
                    <h4><a href="selectGoodById?gId=${good.gId}"> ${good.gName} </a></h4>
                    <a href="selectGoodById?gId=${good.gId}"><img src="images/所有商品/${good.gImage}"></a>
                    <div class="prize">¥ ${good.gPrice}</div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title clearfix">
        <h3 class="fl" id="model05">新鲜蔬菜</h3>
        <div class="subtitle fl">
            <span>|</span>
            <c:forEach var="good" items="${requestScope.xxsc}">
                <a href="selectGoodById?gId=${good.gId}">${good.gName}</a>
            </c:forEach>
        </div>
        <a href="selectGoodByFenYe?pageNum=1" class="goods_more fr">查看更多 &gt;</a>
    </div>

    <div class="goods_con clearfix">
        <div class="goods_banner fl"><img src="images/所有商品/banner05.jpg"></div>
        <ul class="goods_list fl">
            <c:forEach var="good" items="${requestScope.xxsc}">
                <li>
                    <h4><a href="selectGoodById?gId=${good.gId}"> ${good.gName} </a></h4>
                    <a href="selectGoodById?gId=${good.gId}"><img src="images/所有商品/${good.gImage}"></a>
                    <div class="prize">¥ ${good.gPrice}</div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title clearfix">
        <h3 class="fl" id="model06">速冻食品</h3>
        <div class="subtitle fl">
            <span>|</span>
            <c:forEach var="good" items="${requestScope.sdsp}">
                <a href="selectGoodById?gId=${good.gId}">${good.gName}</a>
            </c:forEach>
        </div>
        <a href="selectGoodByFenYe?pageNum=1" class="goods_more fr">查看更多 &gt;</a>
    </div>

    <div class="goods_con clearfix">
        <div class="goods_banner fl"><img src="images/所有商品/banner06.jpg"></div>
        <ul class="goods_list fl">
            <c:forEach var="good" items="${requestScope.sdsp}">
                <li>
                    <h4><a href="selectGoodById?gId=${good.gId}"> ${good.gName} </a></h4>
                    <a href="selectGoodById?gId=${good.gId}"><img src="images/所有商品/${good.gImage}"></a>
                    <div class="prize">¥ ${good.gPrice}</div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<!--全部商品 结束-->

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
</body>
</html>
