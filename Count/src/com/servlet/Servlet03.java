package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//只是从Servlet02获取最新的计数量，它本身不刷新计数
//如果不运行02，先运行03，会出现500错误
public class Servlet03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 从ServletContext获取count属性数据，此处使用了匿名对象
        int count = (Integer) getServletContext().getAttribute("count");//如果不运行02，先运行03，count不存在
        // 显示到页面
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>网站被访问了 "+count+" 次!</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

