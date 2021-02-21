package com.edu.servlet;

import com.edu.entity.Address;
import com.edu.entity.User;
import com.edu.service.UserService;
import com.edu.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showAddressServlet")
public class ShowAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        UserService userService = new UserServiceImp();
        Address address = userService.showAddressByUId(user.getUser_id());
        request.setAttribute("address",address);

        request.getRequestDispatcher("address.jsp").forward(request,response);
    }
}
