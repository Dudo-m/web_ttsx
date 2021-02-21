package com.edu.servlet;

import com.edu.service.GoodService;
import com.edu.service.GoodServiceImp;
import com.edu.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/searchGoodByFenYe")
public class SearchGoodByFenYe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = Integer.parseInt(request.getParameter("pageNum"));
        String search = request.getParameter("search");

//        System.out.println("search = " + search);
//        System.out.println("currentPage = " + currentPage);

        GoodService goodService = new GoodServiceImp();
        Page page = goodService.searchByFenYe(currentPage,search);

        request.setAttribute("page",page);
        request.setAttribute("search",search);

        request.getRequestDispatcher("searchShop.jsp").forward(request,response);
    }
}
