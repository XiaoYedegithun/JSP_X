package com.xy.servlet;

import com.xy.entity.User;
import com.xy.service.IUserService;
import com.xy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("pwd");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        IUserService iUserService = new UserServiceImpl();
        Map<String, Object> login = iUserService.login(user);

        if (((Integer)(login.get("code")))==1 ){
            User user1 = (User) login.get("User");
            req.getSession().setAttribute("login",user1);
            if(user1.getTypeId().equals(1)){
                resp.sendRedirect("FindAllNewsServlet");

            }else {
                resp.sendRedirect("index.jsp");
            }
        }else{ 
            req.getSession().setAttribute("msg",login.get("msg"));
            resp.sendRedirect("login.jsp");
        }
    }
}
