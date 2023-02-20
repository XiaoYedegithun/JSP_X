package com.xy.servlet;

import com.xy.entity.News;
import com.xy.entity.NewsCategory;
import com.xy.service.INewsCategoryService;
import com.xy.service.INewsService;
import com.xy.service.impl.NewsCategoryServiceImpl;
import com.xy.service.impl.NewsServiceImplImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/FindOneNewsServlet")
public class FindOneNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        INewsService ns = new NewsServiceImplImpl();
        String nid = req.getParameter("nid");
        String status = req.getParameter("status");
        News news = ns.FindOneNews(nid);
        req.getSession().setAttribute("n" ,news);
        if (status!=null){
            INewsCategoryService cs = new NewsCategoryServiceImpl();
            List<NewsCategory> clist = cs.findAllNewsCategory();
            req.getSession().setAttribute("cc",clist);
            resp.sendRedirect("admin/newsEdit.jsp");
        }else {
            resp.sendRedirect("newsRead.jsp");
        }

    }
}
