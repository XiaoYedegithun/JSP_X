package com.xy.dao.impl;

import com.xy.dao.INewsCategoryDao;
import com.xy.entity.NewsCategory;
import com.xy.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsCategoryDaoImpl implements INewsCategoryDao {
    @Override
    public List<NewsCategory> findAllNewsCategory() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<NewsCategory> categoryList = new ArrayList<NewsCategory>();
        String sql = "select * from t_news_category";
        try {
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            NewsCategory newsCategory = null;
            while (rs.next()){
                newsCategory = new NewsCategory();
                newsCategory.setTid(rs.getInt("tid"));
                newsCategory.setTname(rs.getString("tname"));
                categoryList.add(newsCategory);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBHelper.close(rs,ps,con);
        }
        return categoryList;
    }
}
