package com.edu.servlet;

import com.edu.entity.Good;
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

@WebServlet("/addShopServlet")
public class AddShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int gId = Integer.parseInt(request.getParameter("gId"));
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("selectGoodById?gId="+gId).forward(request,response);
        }else{
            GoodService goodService= new GoodServiceImp();
            goodService.addShop(gId, user.getUser_id());
            request.getRequestDispatcher("ShopShowServlet").forward(request,response);
        }

    }
}
