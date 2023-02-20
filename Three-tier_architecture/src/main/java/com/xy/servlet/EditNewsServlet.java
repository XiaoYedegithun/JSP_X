package com.xy.servlet;

import com.xy.entity.News;
import com.xy.service.INewsService;
import com.xy.service.impl.NewsServiceImplImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/editNews")
public class EditNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("test/html;character=utf-8");
        req.setCharacterEncoding("utf-8");
        String ntid = req.getParameter("ntid");
        String ntitle = req.getParameter("ntitle");
        String nauthor = req.getParameter("nauthor");
        String nbak = req.getParameter("nsummary");
        String ncontent = req.getParameter("ncontent");
        String nid = req.getParameter("nid");
        News news=new News();
        news.setNtitle(ntitle);
        news.setNauthor(nauthor);
        news.setNbak(nbak);
        news.setNcontent(ncontent);
        news.setTid(Integer.parseInt(ntid));
        news.setNid(Integer.parseInt(nid));
        INewsService ns = new NewsServiceImplImpl();
        int i = ns.updateNews(news);
        if (i>0){
            resp.sendRedirect("FindAllNewsServlet");
        }else {
            resp.getWriter().write("<script>alert('修改失败！');location.href='admin/newsEdit.jsp';</script>");
        }
    }
}
