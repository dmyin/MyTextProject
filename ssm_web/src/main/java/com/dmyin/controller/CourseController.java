package com.dmyin.controller;


import com.dmyin.constants.Constants;
import com.dmyin.entity.PageResult;
import com.dmyin.entity.QueryPageBean;
import com.dmyin.entity.Result;
import com.dmyin.pojo.Course;
import com.dmyin.pojo.User;
import com.dmyin.service.CourseService;
import com.dmyin.utils.DateUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("sever")
public class CourseController {
    @Resource
    private CourseService ms;
    @RequestMapping("coursePage")
    public Result coursePage(@RequestBody QueryPageBean queryPageBean) throws IOException {
        try {
            PageResult pr = ms.coursePage(queryPageBean);
            return new Result(true,"查询成功",pr);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,e.getMessage());
        }
    }

    @RequestMapping("addCourse")
    public Result addCourse(@RequestBody Course course, HttpSession session) throws IOException {
        try {
            //创建时间
            course.setCreateDate(DateUtils.parseDate2String(new Date()));
            //创建用户
            User user = (User) session.getAttribute(Constants.LOGIN_USER);
            course.setUserId(user.getId());
            course.setOrderNo(2);
            ms.addCourse(course);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("updateCourse")
    public Result updateCourse(@RequestBody Course course) throws IOException {
        try {
            ms.updateCourse(course);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"修改成功");
        }
    }

    @RequestMapping("deleteCourse")
    public Result deleteCourse(int id) throws IOException {
        try {
           // Course course = JsonUtils.parseJSON2Object(request, Course.class);
            ms.deleteCourse(id);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,e.getMessage());
        }
    }

    @RequestMapping("findCourse")
    public Result findCourse(String status) throws IOException {
        try {
            List<Course> list = ms.findAll(status);
           return new Result(true,"加载学科成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"加载学科失败");
        }
    }
}
