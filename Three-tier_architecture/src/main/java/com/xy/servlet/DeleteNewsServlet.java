package com.xy.servlet;

import com.xy.service.INewsService;
import com.xy.service.impl.NewsServiceImplImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/deleteNewsServlet")
public class DeleteNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("test/html;character=utf-8");
        PrintWriter out = resp.getWriter();
        String nid = req.getParameter("nid");
        INewsService ns = new NewsServiceImplImpl();
        int i = ns.delNews(nid);
        if(i>0){
            resp.sendRedirect("FindAllNewsServlet");
        }else {
            out.println("<script>alert('删除失败！');location.href='admin/admin.jsp';</script>");
        }
    }
}
