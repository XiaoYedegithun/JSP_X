package com.xy.dao;

import com.xy.entity.User;

public interface IUserDao {
    /**
     *登录方法
     * @param userName 用户名
     * @return 用户对象
     */
    public User login(String userName);
}
