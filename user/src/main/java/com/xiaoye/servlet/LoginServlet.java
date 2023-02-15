package com.xiaoye.servlet;

import com.xiaoye.dao.UserDao;
import com.xiaoye.dao.impl.UserDaoImpl;
import com.xiaoye.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        UserDao userDao = new UserDaoImpl();
        User login = userDao.login(user);
        if(login != null){
            req.getSession().setAttribute("login",login);
            resp.sendRedirect("showServlet?currentPageNo=1");
        }else{
            resp.sendRedirect("index.jsp");
        }
    }
}
