package sunyang;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/login")
public class LoginServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, IOException {
        resp.setCharacterEncoding("GBK");              //设置响应的编码类型为GBK
        PrintWriter out=resp.getWriter();                //获取输出对象
        out.println("<html>");
        out.println("<head>");
        out.println("<title>用户登录</title>");
        out.println("</head>");
        out.println("<body>");
        HttpSession session=req.getSession();//获取HttpSession实例，session对象，域对象（公共储存空间）

        //判断是否处于登录状态，第一次肯定false，第二次以后可能true
        Boolean isLogin=(Boolean)session.getAttribute("isLogin");
        if(isLogin==null){
            isLogin=false;
        }
        String name=req.getParameter("username");//获取表单上的用户名
        String password=req.getParameter("password");//获取表单上的密码
        if(isLogin==true){  //对于判断已经登录的用户，出现欢迎信息。
            name=(String)session.getAttribute("name");
            out.println("<center><h2>欢迎"+name+"登录</h2></center>");
        }

        else if(name!=null&&password!=null){    //对于判断未登录的用户，把用户信息存入session
            session.setAttribute("name", name);//把用户名保存在HttpSession中
            session.setAttribute("password", password);//把密码保存在HttpSession中
            //把判断用户是否登录的字段保存在HttpSession中
            session.setAttribute("isLogin", true);

            //这段实现了JSP页面的表单功能
            out.println("<center><h2>欢迎"+name+"登录</h2></center>");
        }else{
            out.println("<h2>用户登录</h2>");
            out.println("<form action=login method=post>");
            out.println("用户名：<input type=text name=username>");
            out.println("<br>");
            out.println("密码：<input type=password name=password>");
            out.println("<br>");
            out.println("<input type=submit name=submit value=登录>");
            out.println("<input type=reset name=reset value=重置>");
            out.println("</form>");
        }
        out.println("</body>");
        out.println("</html>");
    }



    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, IOException {
        this.doPost(req, resp);
    }
}
