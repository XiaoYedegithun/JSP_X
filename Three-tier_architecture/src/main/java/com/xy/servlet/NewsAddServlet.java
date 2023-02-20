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
@WebServlet(urlPatterns = "/saveNews")
public class NewsAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        News news = new News();
        req.setCharacterEncoding("utf-8");
        news.setTid(Integer.valueOf(req.getParameter("ntid")));
        news.setNtitle(req.getParameter("ntitle"));
        news.setNauthor(req.getParameter("nauthor"));
        news.setNbak(req.getParameter("nsummary"));
        news.setNcontent(req.getParameter("ncontent"));

        INewsService ns = new NewsServiceImplImpl();
        int i = ns.saveNews(news);
        if (i>0){
            resp.sendRedirect("FindAllNewsServlet");
        }
    }
}
