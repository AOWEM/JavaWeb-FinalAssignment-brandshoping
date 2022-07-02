package com.yuanh.servlet;

import com.yuanh.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 新增
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码 post
        request.setCharacterEncoding("utf-8");

        String brandname = request.getParameter("brandname");
        String companyname = request.getParameter("companyname");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String quantity = request.getParameter("quantity");
        String status = request.getParameter("status");

        System.out.println("新增"+brandname + companyname + ordered  +description +status  );


        DBUtil.update("INSERT INTO tb_brand VALUES (null,?,?,?,?,?,?);",
                brandname, companyname, ordered, description,quantity,status);

        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
