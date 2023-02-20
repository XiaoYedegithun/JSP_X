package com.xy.service.impl;

import com.xy.dao.INewsCategoryDao;
import com.xy.dao.impl.NewsCategoryDaoImpl;
import com.xy.entity.NewsCategory;
import com.xy.service.INewsCategoryService;

import java.util.List;

public class NewsCategoryServiceImpl implements INewsCategoryService {
    INewsCategoryDao newsCategoryDao = new NewsCategoryDaoImpl();

    /**
     * 调用INewsCategoryDaoImpl的findAllNewsCategory()方法
     * @return NewsCategory对象集合
     */
    @Override
    public List<NewsCategory> findAllNewsCategory() {
       return newsCategoryDao.findAllNewsCategory();
    }
}
