package com.xiaoye.service;

import com.xiaoye.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 登录的方法
     * @param user 登录的用户对象
     * @return 用户对象
     */
    public User login(User user);

    /**
     * 查询数据库中用户数
     * @return 所有用户数量
     */
    public int count();

    /**
     *分页查询用户
     * @param pageSize 页面大小
     * @param pageNo 当前页码
     * @return 用户集合
     */
    public List<User> queryUser(int pageSize, int pageNo);

}
