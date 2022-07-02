package com.yuanh.servlet;

import com.yuanh.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

/**
 * 修改密码
 */
@WebServlet("/changeServlet")
public class ChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwords = request.getParameter("passwords");

        Map<String, String> change = DBUtil.queryOne("select * from tb_user where username = ? and password = ?",username,password);

        System.out.println(change);

        if (change != null) {
            //,修改密码，跳转主页
            DBUtil.update("update tb_user set password = ? where username = ? ",passwords,username);
            request.getRequestDispatcher("/").forward(request,response);
        }else {
            //原密码错误
            request.setAttribute("user_cw","用户名或原密码错误");
            request.getRequestDispatcher("/change.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
