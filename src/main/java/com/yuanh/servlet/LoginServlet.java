package com.yuanh.servlet;

import com.yuanh.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

/**
 * 登录
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取浏览器数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //查询是否有这个用户
        Map<String, String> login = DBUtil.queryOne("select * from tb_user where username = ? and password = ?",
                username, password);

        //转存啥到session域
        HttpSession session = request.getSession();
        session.setAttribute("login",login);

        //判断是否为空
        if (login != null) {
            //登陆成功
            request.getRequestDispatcher("/selectAllServlet").forward(request,response);
        }else {
            request.getRequestDispatcher("/index.html").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
