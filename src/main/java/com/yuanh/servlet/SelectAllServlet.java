package com.yuanh.servlet;

import com.yuanh.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 查询所有
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Map<String, String>> brands = DBUtil.query("select * from tb_brand");

        //吧查询到数据库的数据转存到reqest域中,
        request.setAttribute("brands",brands);

        request.getRequestDispatcher("/brand.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
