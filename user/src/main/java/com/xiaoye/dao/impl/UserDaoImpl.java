package com.xiaoye.dao.impl;

import com.xiaoye.dao.BaseDao;
import com.xiaoye.dao.UserDao;
import com.xiaoye.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    public User login(User user) {
        Connection con = BaseDao.getcon();
        PreparedStatement pr = null;
        ResultSet rs = null;
        User user1 = new User();
        try {
            pr = con.prepareStatement("select * from user where userName=? and password=?");
            pr.setString(1, user.getUserName());
            pr.setString(2,user.getPassword());
            rs = pr.executeQuery();
            while (rs.next()){
                user1.setUserId(rs.getInt("userId"));
                user1.setUserName(rs.getString("userName"));
                user1.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeAll(rs,pr,con);
        }
        return user1;
    }
}
