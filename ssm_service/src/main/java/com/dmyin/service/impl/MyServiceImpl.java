package com.dmyin.service.impl;


import com.dmyin.dao.UserDao;
import com.dmyin.pojo.User;
import com.dmyin.service.MyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class MyServiceImpl implements MyService {
@Resource
    private UserDao userDao;
@Override
    public User login(User user) throws IOException {
        User loginUser = userDao.login(user.getUsername());
        if (loginUser == null) {
            throw new RuntimeException("没有该用户");
        } else {
            if (user.getPassword().equals(loginUser.getPassword())) {
                return loginUser;
            } else {
                throw new RuntimeException("密码错误");
            }
        }
    }



}
