package com.yuanh.servlet;

import com.yuanh.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 修改的提交
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String brandid = request.getParameter("brandid");
        String brandname = request.getParameter("brandname");
        String companyname = request.getParameter("companyname");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String quantity = request.getParameter("quantity");
        String status = request.getParameter("status");
        System.out.println("status ......" +status);

        DBUtil.update("update tb_brand set brandname=?,companyname=?,ordered=?,description=?,quantity=?,status=?  where brandid = ?;"
                , brandname, companyname, ordered, description, quantity, status, brandid);

        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
