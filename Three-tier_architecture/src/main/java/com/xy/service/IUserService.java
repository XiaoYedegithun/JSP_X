package com.xy.service;

import com.xy.entity.User;

import java.util.Map;

public interface IUserService {
    public Map<String,Object> login(User user);
}
