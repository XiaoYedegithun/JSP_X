import java.sql.*;

public class test {
    private static final String url="jdbc:mysql://127.0.0.1:3306/jsp_x?useUnicode=true&useSSL=false&characterEncoding=UTF8&serverTimezone=UTC";
    private static final String userName="root";
    private static final String password="123456";


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con  = DriverManager.getConnection(url,userName,password);
            System.out.println(con);
            PreparedStatement pr  = con.prepareStatement("select * from User");
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("userId"));
                System.out.println(rs.getString("userName"));
                System.out.println(rs.getString("password"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
