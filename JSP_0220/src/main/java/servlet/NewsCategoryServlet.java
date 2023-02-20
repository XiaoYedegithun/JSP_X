package servlet;


import entity.NewsCategory;
import util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/queryCategory")
public class NewsCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NewsCategory> cList=new ArrayList<>();
        try {
            Connection connection = DBHelper.getCon();
            String sql="select * from t_news_category";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            NewsCategory nc=null;
            while(rs.next()){
                nc=new NewsCategory();
                nc.setTid(rs.getInt("tid"));
                nc.setTname(rs.getString("tname"));
                cList.add(nc);
            }
            //通过session将值返回给页面
            HttpSession session = req.getSession();
            session.setAttribute("cc",cList);
            resp.sendRedirect("admin/newsAdd.jsp");
            DBHelper.close(rs,ps,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
