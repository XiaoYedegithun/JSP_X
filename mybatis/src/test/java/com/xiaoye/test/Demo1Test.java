package com.xiaoye.test;

import com.github.pagehelper.PageHelper;
import com.xiaoye.mapper.UserMapper;
import com.xiaoye.model.User;
import com.xiaoye.util.MybatisSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class Demo1Test {
   private SqlSession sqlSession;
   private User user;

   private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        System.out.println("在当前类下面，任意方法运行之前，我先运行");
        sqlSession = MybatisSessionFactoryUtils.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        user = new User();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("我会在任意方法运行完了之后，再运行");
        sqlSession.commit();
    }

    @Test
    public void save() {
        user.setUname("xy");
        user.setUaccount("xiaoye123");
        user.setUpassword("123456");
        int insert = userMapper.insertSelective(user);
        System.out.println(insert);
    }

    @Test
    public void demo1(){
        PageHelper.startPage(2,3);
        List<User> users = userMapper.queryAll();
        for (User u : users) {
            System.out.println(u);
        }
    }
}