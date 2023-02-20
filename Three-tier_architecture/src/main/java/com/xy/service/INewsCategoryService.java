package com.xy.service;

import com.xy.entity.NewsCategory;

import java.util.List;

public interface INewsCategoryService {
    /**
     *
     * @return
     */
    public List<NewsCategory> findAllNewsCategory();
}
