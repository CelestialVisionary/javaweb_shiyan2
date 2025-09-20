package com.phoenix.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String userName = req.getParameter("userName");
        userName = "Hello "+userName;

        req.setAttribute("userName",userName);//域对象

        RequestDispatcher dispatcher = req.getRequestDispatcher("/Success.jsp");//请求转发，转到Success.jsp
        dispatcher.forward(req, resp);

        //req.getRequestDispatcher("/Success.jsp").forward(req, resp);
    }

}
