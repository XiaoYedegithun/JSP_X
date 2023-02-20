package com.xy.service.impl;

import com.xy.dao.IUserDao;
import com.xy.dao.impl.UserDaoImpl;
import com.xy.entity.User;
import com.xy.service.IUserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements IUserService {
    IUserDao iUserDao = new UserDaoImpl();

    @Override
    public Map<String, Object> login(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        //创建状态代码
        int code = 1;
        //创建返回消息
        String msg = "登录成功";
        User login = iUserDao.login(user.getUserName());
        if (login == null) {
            //当拿不到IUSerDao.login返回对象时修改状态码和返回消息
            code = 0;
            msg = "账号不存在";
        } else {
            if (!login.getPassword().equals(user.getPassword())) {
                code = -1;
                msg = "密码错误";
            }else {
                map.put("User",login);
            }
        }
        map.put("code",code);
        map.put("msg",msg);
        return map;
    }
}
