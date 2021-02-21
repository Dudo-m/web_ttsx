package com.edu.servlet;

import com.edu.entity.Good;
import com.edu.service.GoodService;
import com.edu.service.GoodServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectGoodById")
public class SelectGoodById extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int gId = Integer.parseInt(request.getParameter("gId"));

//        System.out.println("gId = " + gId);
        GoodService goodService = new GoodServiceImp();
        Good good = goodService.selectGoodById(gId);
//        System.out.println("good = " + good);
        request.setAttribute("good",good);

        request.getRequestDispatcher("shop_message.jsp").forward(request,response);
    }
}
