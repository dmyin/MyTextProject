package com.dmyin.controller;

import com.dmyin.pojo.Items;
import com.dmyin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("items")
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping("save")
    public String getItemsList(Model model) {
        List<Items> itemsList = userService.findAll();
        model.addAttribute("items", itemsList);
        return "items";
    }

}

