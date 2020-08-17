package com.dmyin.service.impl;

import com.dmyin.dao.UserDao;
import com.dmyin.pojo.Items;
import com.dmyin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<Items> findAll() {
        return userDao.findAll();
    }
}
