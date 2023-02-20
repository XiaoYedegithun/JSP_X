package com.xy.dao;

import com.xy.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {
    public int executeUpdate(String sql){
        int row = 0;
        Connection con = DBHelper.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            row = ps.executeUpdate();
            DBHelper.close(null,ps,con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }
}
