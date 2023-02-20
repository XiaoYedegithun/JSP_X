package com.xy.service;

import com.xy.entity.News;
import com.xy.util.PageBean;

import java.util.List;

public interface INewsService {
    public List<News> findAllNews(PageBean pageBean);

    public int saveNews(News news);

    public int updateNews(News news);

    public int delNews(String nid);

    public News FindOneNews(String id);
}
