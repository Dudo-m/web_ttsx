package com.edu.servlet;

import com.edu.entity.User;
import com.edu.service.GoodService;
import com.edu.service.GoodServiceImp;
import com.edu.utils.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShopShowServlet")
public class ShopShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodService goodService = new GoodServiceImp();
        User user = (User)request.getSession().getAttribute("user");
        List<Shop> list = goodService.selectShopByUserId(user.getUser_id());
        request.setAttribute("shop",list);
//        商品数
        request.getSession().setAttribute("shop_size",list.size());
//        System.out.println(list);
//        System.out.println(list.size());
        request.getRequestDispatcher("shop.jsp").forward(request,response);
    }
}
