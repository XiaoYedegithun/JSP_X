package com.xy.service.impl;

import com.xy.dao.INewsDao;
import com.xy.dao.impl.NewsDaoImpl;
import com.xy.entity.News;
import com.xy.service.INewsService;
import com.xy.util.PageBean;

import java.util.List;

public class NewsServiceImplImpl implements INewsService {
    INewsDao newsDao = new NewsDaoImpl();

    @Override
    public List<News> findAllNews(PageBean pageBean) {
        return newsDao.findAllNews(pageBean);
    }

    @Override
    public int saveNews(News news) {
        return newsDao.saveNews(news);
    }

    @Override
    public int updateNews(News news) {
        return newsDao.updateNews(news);
    }

    @Override
    public int delNews(String nid) {
        return newsDao.delNews(nid);
    }

    @Override
    public News FindOneNews(String id) {
        return newsDao.FindOneNews(id);
    }
}
