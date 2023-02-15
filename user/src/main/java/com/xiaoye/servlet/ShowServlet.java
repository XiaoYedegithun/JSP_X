package com.xiaoye.servlet;

import com.xiaoye.entity.Page;
import com.xiaoye.entity.User;
import com.xiaoye.service.UserService;
import com.xiaoye.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showServlet")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPageNo = req.getParameter("currentPageNo");
        System.out.println("currentPageNo:" + currentPageNo);
        if (currentPageNo == null) {
            currentPageNo = "1";
        }
        int pageNo = Integer.parseInt(currentPageNo);

        UserService service = new UserServiceImpl();
        Page<User> usersPage = new Page<User>();
        // 页面大小
        usersPage.setPageSize(3);
        // 总条数
        usersPage.setTotalCount(service.count());
        // 当前页码
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > usersPage.getTotalPageCount()) {
            pageNo = usersPage.getTotalPageCount();
        }
        usersPage.setCurrentPageNo(pageNo);

        // 显示页面的分页数据
        usersPage.setList(service.queryUser(usersPage.getPageSize(), usersPage.getCurrentPageNo()));
        req.setAttribute("usersPage", usersPage);
        req.getRequestDispatcher("show.jsp").forward(req, resp);
    }
}

