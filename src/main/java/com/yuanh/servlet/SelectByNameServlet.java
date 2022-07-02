package com.yuanh.servlet;

import com.yuanh.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 搜索功能
 */
@WebServlet("/selectByNameServlet")
public class SelectByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String companyname = request.getParameter("productName");
        //将字符串打散成字节数组
        byte[] bytes = companyname.getBytes("ISO-8859-1");
        //将字节数组按照设定的编码重新组装成字符串
        companyname = new String(bytes,"UTF-8");

        System.out.println("productName.........." + companyname);

        List<Map<String, String>> brands = DBUtil.query("SELECT * FROM tb_brand WHERE companyname LIKE '%' " + " ?  " + "  '%';",companyname);

        System.out.println(brands);
        if (brands == null) {
            request.getRequestDispatcher("/selectAllServlet").forward(request,response);
        }else {
            request.setAttribute("brands",brands);
            request.getRequestDispatcher("/brand.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
