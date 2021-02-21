package com.edu.servlet;

import com.edu.entity.User;
import com.edu.service.GoodService;
import com.edu.service.GoodServiceImp;
import com.edu.service.UserService;
import com.edu.service.UserServiceImp;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        //生成的验证码
        String piccode = (String) request.getSession().getAttribute("piccode");
        //接收的验证码
        String captcha_1 = request.getParameter("captcha_1");

        UserService userService = new UserServiceImp();
        GoodService goodService = new GoodServiceImp();
        User user = userService.login(username);
        HttpSession session = request.getSession();

//        System.out.println(piccode.toUpperCase());

        //全转换成大写比较
        if (piccode.toUpperCase().equals(captcha_1.toUpperCase())){
            //验证验证码
        if (user!=null){
            //账号存在,验证密码
            if(pwd.equals(user.getUser_password())){
                //密码匹配验证身份
                session.setAttribute("user",user);

                //放入购物车商品,这里直接查全部，可以单独查count(*)
                session.setAttribute("shop_size",goodService.selectShopByUserId(user.getUser_id()).size());

                request.getRequestDispatcher("indexServlet").forward(request,response);
            }else{
                request.setAttribute("msg","输入密码有误");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else {
            //账号不存在
            request.setAttribute("msg","输入账号有误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        }else{
            //验证码错误
            request.setAttribute("msg","验证码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
