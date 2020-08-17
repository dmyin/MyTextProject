package com.dmyin.dao;

import com.dmyin.pojo.Items;
import com.dmyin.pojo.User;

import java.util.List;

public interface UserDao {
    User login(String username);
    List<Items> findAll();
}
