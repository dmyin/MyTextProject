package com.dmyin.controller;

import com.dmyin.constants.Constants;
import com.dmyin.entity.Result;
import com.dmyin.pojo.User;
import com.dmyin.service.MyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@RestController
@RequestMapping("sever")
public class MyServlet{
    @Resource
     private MyService ms;
    @RequestMapping("login")
    public Result login(@RequestBody User user, HttpSession session) throws IOException {
        try {
            User user02 =  ms.login(user);
           session.setAttribute(Constants.LOGIN_USER,user02);
            return new Result(true,"登录成功",user02);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,e.getMessage());
        }
    }

    @RequestMapping("exitUser")
    public Result exitUser(HttpSession session) throws IOException {
        session.invalidate();
       return new Result(true,"退出成功");
    }
}
