package com.yuanh.servlet;

import com.yuanh.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

/**
 * 修改1
 */
@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brandid = request.getParameter("brandid");

        Map<String, String> byId = DBUtil.queryOne("select * from tb_brand where brandid = ?", brandid);

        System.out.println("byid" + byId);
        request.setAttribute("brand",byId);

        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
