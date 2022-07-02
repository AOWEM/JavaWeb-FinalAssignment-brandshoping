package com.yuanh.servlet;

import com.yuanh.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

/**
 * 注册功能
 */
@WebServlet("/regihServlet")
public class RegihServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取网页注册信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //查询数据库有没有我要注册用户
        Map<String, String> select = DBUtil.queryOne("select * from tb_user where username = ? and password = ?", username, password);
        //select = null
        //查询到数据库没有这个用户
        if (select == null) {
            //添加数据库数据
            boolean update = DBUtil.update("INSERT INTO tb_user VALUES (null,?, ?);", username, password);
            //插入完跳转主页
            request.getRequestDispatcher("index.html").forward(request,response);
        }else {

            request.setAttribute("user_cw","用户名已存在");

            request.getRequestDispatcher("regih.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
