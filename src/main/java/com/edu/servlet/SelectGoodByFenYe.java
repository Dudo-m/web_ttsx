package com.edu.servlet;

import com.edu.entity.Good;
import com.edu.service.GoodService;
import com.edu.service.GoodServiceImp;
import com.edu.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectGoodByFenYe")
public class SelectGoodByFenYe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = Integer.parseInt(request.getParameter("pageNum"));

        GoodService goodService = new GoodServiceImp();
        Page page = goodService.selectByFenYe(currentPage);

        request.setAttribute("page",page);

//        for(Good good : (List<Good>)page.getData()){
//            System.out.println("good = " + good);
//        }
        request.getRequestDispatcher("readmoreShop.jsp").forward(request,response);
    }
}
