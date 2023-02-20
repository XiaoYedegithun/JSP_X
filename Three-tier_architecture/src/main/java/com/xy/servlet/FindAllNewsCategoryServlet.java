package com.xy.servlet;

import com.xy.entity.NewsCategory;
import com.xy.service.INewsCategoryService;
import com.xy.service.impl.NewsCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/queryCategory")
public class FindAllNewsCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        INewsCategoryService categoryService = new NewsCategoryServiceImpl();
        List<NewsCategory> allNewsCategory = categoryService.findAllNewsCategory();
        req.getSession().setAttribute("clist",allNewsCategory);
        resp.sendRedirect("admin/newsAdd.jsp");
    }
}
