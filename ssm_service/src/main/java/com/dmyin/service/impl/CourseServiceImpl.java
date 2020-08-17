package com.dmyin.service.impl;


import com.dmyin.dao.CatalogDao;
import com.dmyin.dao.CourseDao;
import com.dmyin.dao.QuestionDao;
import com.dmyin.dao.TagDao;
import com.dmyin.entity.PageResult;
import com.dmyin.entity.QueryPageBean;
import com.dmyin.pojo.Course;
import com.dmyin.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao mapper;
    @Resource
    private TagDao tagDao;
    @Resource
    private QuestionDao questionDao;
    @Resource
    private CatalogDao catalogDao;
    @Resource
    private CourseDao courseDao;

@Override
    public PageResult coursePage(QueryPageBean queryPageBean) throws IOException {
        //根据查询条件获取总页数
        Long count = mapper.countPage(queryPageBean.getQueryParams());
        //根据bean获取课程集合
        List<Course> courseList = mapper.listPage(queryPageBean);
        //封装
        PageResult pr = new PageResult(count,courseList);
        return pr;
    }
    @Override
    public void addCourse(Course course) throws IOException {
        mapper.addCourse(course);
    }
    @Override
    public void updateCourse(Course course) throws IOException {
        mapper.updateCourse(course);
    }
    @Override
    public void deleteCourse(Integer id) throws IOException {
        Long tagCount = tagDao.courseCount(id);
        if (tagCount > 0) {
            throw new RuntimeException("标签不为空,不能删除");
        }
        //问题数量
        Long questionCount =  questionDao.courseCount(id);
        if (questionCount > 0) {
            throw new RuntimeException("问题不为空,不能删除");
        }
        //二级目录
        Long catalogCount = catalogDao.courseCount(id);
        if (catalogCount > 0) {
            throw new RuntimeException("二级目录不为空,不能删除");
        }
        //删除
        courseDao.deleteCourse(id);
    }
    @Override
    public List<Course> findAll(String status) throws IOException {
        List<Course> list = mapper.findAll(status);
        return list;
    }
}
