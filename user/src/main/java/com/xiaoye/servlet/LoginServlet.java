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
        User login = new User();
        login.setUserName(userName);
        login.setPassword(password);
        UserDao userDao = new UserDaoImpl();
        User user = userDao.login(login);
        System.out.println(user);
    }
}
