package com.xy.dao;

import com.xy.entity.News;
import com.xy.util.PageBean;

import java.util.List;

public interface INewsDao {
    /**
     *分页查询
     * @return
     */
    public List<News> findAllNews(PageBean pageBean);

    public int getCount();

    public int saveNews(News news);

    public int updateNews(News news);

    public int delNews(String nid);

    public News FindOneNews(String id);
}
