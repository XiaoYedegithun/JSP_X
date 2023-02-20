package dao;

import entity.News;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDao extends BaseDao {
    public List<News> queryNews(){
        List<News> newsList = new ArrayList();
        Connection con =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
             con = DBHelper.getCon();
            String sql = "SELECT * FROM t_news";
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNbak(rs.getString("nbak"));
                news.setTid(rs.getInt("tid"));
                news.setNcontent(rs.getString("ncontent"));
                news.setImages(rs.getString("images"));
                news.setNdate(rs.getString("ndate"));
                newsList.add(news);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBHelper.close(rs, ps, con);   }
        return newsList;
    }

    /**
     * 增加一条新闻数据的方法 传入新闻对象 调用父类的executeUpdate方法；
     * @param news 新闻对象
     * @return 受影响的行
     */
    public int saveNews(News news){
        String sql ="insert into t_nesw(ntitle,nauthor,nbak,ncontent,tid) values"+
                "('"+news.getNtitle()+"','"+news.getNauthor()+"','"+news.getNbak()+
                "','"+news.getNcontent()+"','"+news.getTid()+")";
            return executeUpdate(sql);
    }

    /**
     * 修改一条新闻数据的方法 传入新闻对象 调用父类的executeUpdate方法；
     * @param news 新闻对象
     * @return 受影响的行
     */
    public int updateNews(News news){
        String sql = "update t_news set tid="+news.getTid()+",ntitle='"+news.getNtitle()+"',nbak='"
                +news.getNbak()+"',ncontent='"+news.getNcontent()+"',nauthor='"+news.getNauthor()+"'"
                +" where nid="+news.getNid();
        return executeUpdate(sql);
    }


    /**
     * 删除一条新闻数据的方法 传入新闻对象 调用父类的executeUpdate方法；
     * @param nid 删除新闻的nid
     * @return 受影响的行
     */
    public int delNews(String nid){
        String sql = "delete from t_news where nid="+nid;
        return executeUpdate(sql);
    }


}
