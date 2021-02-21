package com.edu.servlet;

import com.edu.entity.Good;
import com.edu.entity.User;
import com.edu.service.GoodService;
import com.edu.service.GoodServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteShopServlet")
public class DeleteShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int gId = Integer.parseInt(request.getParameter("gId"));
        User user = (User)request.getSession().getAttribute("user");
        GoodService goodService = new GoodServiceImp();

        goodService.deleteShopByUIdAndGId(gId,user.getUser_id());
        request.getRequestDispatcher("ShopShowServlet").forward(request,response);
    }
}
