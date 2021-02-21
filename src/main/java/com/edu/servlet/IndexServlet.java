package com.edu.servlet;

import com.edu.service.GoodService;
import com.edu.service.GoodServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/indexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据分类查询
        GoodService goodService = new GoodServiceImp();
        //新鲜水果
        request.setAttribute("xxsg",goodService.selectByType("新鲜水果"));
        request.setAttribute("hcsx",goodService.selectByType("海鲜水产"));
        request.setAttribute("znyr",goodService.selectByType("猪牛羊肉"));
        request.setAttribute("qldp",goodService.selectByType("禽类蛋品"));
        request.setAttribute("xxsc",goodService.selectByType("新鲜蔬菜"));
        request.setAttribute("sdsp",goodService.selectByType("速冻食品"));

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
