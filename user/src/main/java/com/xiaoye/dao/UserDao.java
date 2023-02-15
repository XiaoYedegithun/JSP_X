package com.xiaoye.dao;

import com.xiaoye.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 登录的方法
     *
     * @param user 登录的用户对象
     * @return 用户对象
     */
    public User login(User user);

    /**
     * 查询数据库中用户数
     *
     * @return 所有用户的数量
     */
    public int count();

    /**
     * 分页查询用户
     *
     * @param pageSize 页面大小
     * @param pageNo   当前页码
     * @return 用户集合
     */
    public List<User> queryUsers(int pageSize, int pageNo);


}
