package com.xiaoye.service.impl;


import com.xiaoye.dao.UserDao;
import com.xiaoye.dao.impl.UserDaoImpl;
import com.xiaoye.entity.User;
import com.xiaoye.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    public User login(User user) {
        UserDao dao = new UserDaoImpl();
        return dao.login(user);
    }

    public int count() {
        UserDao dao = new UserDaoImpl();
        return dao.count();
    }

    public List<User> queryUser(int pageSize, int pageNo) {
        UserDao dao = new UserDaoImpl();
        return dao.queryUsers(pageSize,pageNo);
    }
}
