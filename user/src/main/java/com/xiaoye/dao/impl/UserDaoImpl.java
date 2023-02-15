package com.xiaoye.dao.impl;

import com.xiaoye.dao.BaseDao;
import com.xiaoye.dao.UserDao;
import com.xiaoye.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public int count() {
        Connection con = BaseDao.getcon();
        PreparedStatement pr = null;
        ResultSet rs = null;
        int count = 0;
        try {
            pr = con.prepareStatement("select count(1) from user");
            rs = pr.executeQuery();
            if (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeAll(rs,pr,con);
        }
        return count;
    }

    public List<User> queryUsers(int pageSize, int pageNo) {
        Connection con = BaseDao.getcon();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "select * from user limit ?,?";
        List<User> list = new ArrayList<User>();
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1,(pageNo-1)*pageSize);
            pr.setInt(2,pageSize);
            rs = pr.executeQuery();
            while (rs.next()){
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeAll(rs,pr,con);
        }
        return list;
    }
}
