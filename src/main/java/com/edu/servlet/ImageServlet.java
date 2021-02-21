package com.edu.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 */

@WebServlet(urlPatterns = "/ImageServlet")
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("ImageServlet");
        BufferedImage bi=new BufferedImage(70,25,BufferedImage.TYPE_INT_RGB);
        //画图片
        Graphics g=bi.getGraphics();
        //颜色
        Color c=new Color(201, 200, 75);
        //给Graphics对象设置颜色
        g.setColor(c);
        //画框  （横坐标，纵坐标，宽度，高度
        g.fillRect(0, 0, 70, 25);
        //内容
        char[] ch="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        //获取随机四个字符
        Random r=new Random();
        int len=ch.length,index;
        //用于保存字符
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<4;i++){
            //返回一个数，0<index<len,这个数是ch数组中某个数的下标
            index=r.nextInt(len);
            //设置随机的颜色
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
            //把字符画到图片上去 drawString(字符串，横坐标，纵坐标)，字符转为字符串：字符+""
            g.drawString(ch[index]+"", (i*15)+3, 18);

            addRandomLine(g,70,25,1);

            sb.append(ch[index]);
        }
        //把字符保存到session里，用于等会进行验证
        request.getSession().setAttribute("piccode", sb.toString());
        System.out.println("验证码 = " + sb.toString());
        //输出图片  (图片，格式，输出到哪里)
        ImageIO.write(bi, "JPG", response.getOutputStream());
    }

    //添加干扰线
    private void addRandomLine(Graphics g,int width,int height,int numbers) {
        Random r = new Random();
        for (int i = 0; i < numbers; i++) {
            int x1 = r.nextInt(width);
            int x2 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int y2 = r.nextInt(height);
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(x1, y1, x2, y2);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
