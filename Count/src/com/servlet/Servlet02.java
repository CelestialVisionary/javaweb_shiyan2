package com.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet02 extends HttpServlet {
    private ServletConfig config = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //方法中参数config赋值给成员变量config
        this.config = config;
        // 初始化计数变量count
        int count = 0;

        // 将 count =0 存入到 ServletContext中
        System.out.println("getServletContext=="+config.getServletContext());

        // 获取当前应用中的ServletContext对象，并存入当前计数量，当做全局变量
        config.getServletContext().setAttribute("count", new Integer(count));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int count = (Integer) config.getServletContext().getAttribute("count"); //把上次的计数量取出
        count += 1;//每次刷新网页，计数器+1
        // 每次刷新后把计数量存入到ServletContext中
        config.getServletContext().setAttribute("count", count);
        // 向页面输出欢迎光临!
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>欢迎光临本网站! 这是您第"+count+"次访问</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

