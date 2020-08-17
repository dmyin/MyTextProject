package com.dmyin.service;



import com.dmyin.pojo.User;

import java.io.IOException;

public interface MyService {

    User login(User user) throws IOException;
}
