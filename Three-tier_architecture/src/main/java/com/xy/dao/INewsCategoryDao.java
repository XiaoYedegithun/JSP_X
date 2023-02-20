package com.xy.dao;

import com.xy.entity.NewsCategory;

import java.util.List;

public interface INewsCategoryDao {
    public List<NewsCategory> findAllNewsCategory();
}
