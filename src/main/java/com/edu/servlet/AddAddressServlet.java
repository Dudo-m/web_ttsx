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

@WebServlet("/addAddressServlet")
public class AddAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = (User)request.getSession().getAttribute("user");
        UserService userService = new UserServiceImp();
        Address address = userService.showAddressByUId(user.getUser_id());
        String aConsignee = request.getParameter("aConsignee");
        String aAddress = request.getParameter("aAddress");
        int aPC = Integer.parseInt(request.getParameter("aPC"));
        String aPhone = request.getParameter("aPhone");
        if (address.getaId()==0){
            //第一次添加地址
            userService.addAddress(new Address(0,user.getUser_id(),aConsignee,aAddress,aPC,aPhone));
        }else{
            //修改地址
            userService.upadteAddress(new Address(0,user.getUser_id(),aConsignee,aAddress,aPC,aPhone));
        }
        request.getRequestDispatcher("showAddressServlet").forward(request,response);
    }
}
