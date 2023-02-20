package com.xy.dao.impl;

import com.xy.dao.BaseDao;
import com.xy.dao.INewsDao;
import com.xy.entity.News;
import com.xy.util.DBHelper;
import com.xy.util.PageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends BaseDao implements INewsDao {
    @Override
    public List<News> findAllNews(PageBean pageBean) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<News> newsList = new ArrayList<News>();
        try {
            con = DBHelper.getCon();
            String sql = "select * from t_news limit " + pageBean.startPage() + "," + pageBean.getRows();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNbak(rs.getString("nbak"));
                news.setNcontent(rs.getString("ncontent"));
                news.setTid(rs.getInt("tid"));
                news.setImages(rs.getString("images"));
                news.setNdate(rs.getString("ndate"));
                newsList.add(news);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.close(rs, ps, con);
        }
        return newsList;
    }

    @Override
    public int getCount() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        String sql = "select count(*) from t_news";
        con = DBHelper.getCon();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.close(rs, ps, con);
        }
        return count;
    }

    @Override
    public int saveNews(News news) {
        String sql = "insert into t_news(ntitle,nauthor,nbak,ncontent,tid) values "
                + "('" + news.getNtitle() + "','" + news.getNauthor() + "','" + news.getNbak() + "','" + news.getNcontent() + "'," + news.getTid() + ")";
        return executeUpdate(sql);
    }

    @Override
    public int updateNews(News news) {
        String sql = "update t_news set tid=" + news.getTid() + ", ntitle='" + news.getNtitle() + "'," +
                "nbak='" + news.getNbak() + "',ncontent='" + news.getNcontent() + "'," +
                "nauthor='" + news.getNauthor() + "' where nid=" + news.getNid();
        return executeUpdate(sql);
    }

    @Override
    public int delNews(String nid) {
        String sql = "delete from t_news where nid="+nid;
        return executeUpdate(sql);
    }

    @Override
    public News FindOneNews(String id) {
        Connection con = DBHelper.getCon();
        News news = null;
        try {
            PreparedStatement ps = con.prepareStatement("select  * from t_news where nid=?");
            ps.setInt(1,Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNbak(rs.getString("nbak"));
                news.setNcontent(rs.getString("ncontent"));
                news.setTid(rs.getInt("tid"));
                news.setNdate(rs.getString("ndate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return news;
    }

}
