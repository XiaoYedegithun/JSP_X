package servlet;

import entity.News;
import util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(urlPatterns = "/FindOneNewsServlet")
public class FindOneNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nid = req.getParameter("nid");
        try {
            Connection con = DBHelper.getCon();
            String sql = "SELECT * FROM t_news WHERE nid ="+nid;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            News news = null;
            if(rs.next()){
                news =  new News();
                news.setNid(rs.getInt("nid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNbak(rs.getString("nbak"));
                news.setNcontent(rs.getString("ncontent"));
                news.setTid(rs.getInt("tid"));
                news.setImages(rs.getString("images"));
                news.setNdate(rs.getString("ndate"));
            }
            req.getSession().setAttribute("n",news);
            resp.sendRedirect("newsRead.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
