package com.edu.servlet;

import com.edu.entity.User;
import com.edu.service.UserService;
import com.edu.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regServlet")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取页面数据
        //2.调用service层的方法把第一步的数据传递过去，得到结果true/false
        //3.根据第二步的结果跳转页面
        request.setCharacterEncoding("utf-8");
        String user_account = request.getParameter("user_account");
        String user_password = request.getParameter("user_password");
        String user_email = request.getParameter("user_email");
        String cpwd = request.getParameter("cpwd");
        User user = new User(0,user_account,user_password,user_email);


        System.out.println(user.toString());
        System.out.println("cpwd = " + cpwd);


        boolean flag = false;
        if (cpwd.equals(user_password)) {
            UserService userService = new UserServiceImp();
            flag = userService.register(user);
        }else{
            request.setAttribute("msg","两次密码不同");
        }

        if (flag){
            //注册成功
            request.getRequestDispatcher("login.jsp").forward(request,response);//转发
        }else {
            //注册失败
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }
}
