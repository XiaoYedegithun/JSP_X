package com.xy.servlet;

import com.xy.dao.INewsDao;
import com.xy.dao.impl.NewsDaoImpl;
import com.xy.entity.News;
import com.xy.service.INewsService;
import com.xy.service.impl.NewsServiceImplImpl;
import com.xy.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/FindAllNewsServlet")
public class FindAllNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        INewsService newsService = new NewsServiceImplImpl();
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        INewsDao nd = new NewsDaoImpl();
        pageBean.setTotal(nd.getCount());
        List<News> allNews = newsService.findAllNews(pageBean);
        req.getSession().setAttribute("allNews",allNews);
        req.getSession().setAttribute("pageBean",pageBean);
        resp.sendRedirect("admin/admin.jsp");
    }
}
