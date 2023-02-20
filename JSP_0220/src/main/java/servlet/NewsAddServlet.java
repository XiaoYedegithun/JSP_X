package servlet;

import util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/saveNews")
public class NewsAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String ntid = req.getParameter("ntid");
        String ntitle = req.getParameter("ntitle");
        String nauthor = req.getParameter("nauthor");
        String nbak = req.getParameter("nsummary");
        String ncontent = req.getParameter("ncontent");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("test/html;character=utf-8");
        PrintWriter out = resp.getWriter();

        try {
            Connection connection = DBHelper.getCon();
            String sql = "insert into t_news(ntitle,nauthor,nbak,ncontent,tid) " +
                    "values('" + ntitle + "','" + nauthor + "','" + nbak + "','" + ncontent + "'," + ntid + ")";
            PreparedStatement ps = connection.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                resp.sendRedirect("FindAllNewsServlet");
            } else {
                out.write("<script>alert('登录失败！');location.go(-1)</script>");
            }
            DBHelper.close(null,ps,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
