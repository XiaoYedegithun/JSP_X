import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(urlPatterns = "/login")
public class UserServlet extends HttpServlet {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/jsp_x?useUnicode=true&useSSL=false&characterEncoding=UTF8&serverTimezone=UTC";
    private static final String userName = "root";
    private static final String password = "123456";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            String user = req.getParameter("userName");
            String pwd = req.getParameter("pwd");
            System.out.println(user+"---------"+pwd);
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;character=utf-8");
            PrintWriter out = resp.getWriter();
            String sql = "select * from User where userName='"+user+"' and password='"+pwd+"'";
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                out.println("<h1>登录成功</h1>");
            }else {
                out.println("<span>失败</span>");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
