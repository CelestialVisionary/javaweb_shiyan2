package com.phoenix.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//WebServlet注解配置Servlet的urlpatterns属性。
@WebServlet("/FirstServlet")	//注解参数中必须是英文双引号，斜杠不能漏掉

public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");	//指定输出页面的格式和字符集

		String username = req.getParameter("username");	//从登录页面接收用户名，存入变量
		username = "Hello "+username;
		
		req.setAttribute("username",username);		//把用户名存入请求对象
		
		//请求转发到登录成功页面显示
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Success.jsp");
		dispatcher.forward(req, resp);

		//上面两句可以简化为下面的一句（使用匿名对象）
		//req.getRequestDispatcher("/Success.jsp").forward(req, resp);
	}	
}