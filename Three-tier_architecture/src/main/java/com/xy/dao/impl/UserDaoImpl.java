package com.xy.dao.impl;

import com.xy.dao.IUserDao;
import com.xy.entity.User;
import com.xy.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    public User login(String userName) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user where userName='" + userName + "'";
        User user = null;
        try {
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setTypeId(rs.getInt("typeId"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBHelper.close(rs,ps,con);
        }
        return user;
    }
}
