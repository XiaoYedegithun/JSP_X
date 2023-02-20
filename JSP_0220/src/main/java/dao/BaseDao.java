package dao;

import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {
    /**
     * 封装数据库的增、删、改方法的封装只要传sql语句
     * @param sql 特定的sql语句
     * @return 返回受影响的行
     */
    public int executeUpdate(String sql) {
        Connection con = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

}
