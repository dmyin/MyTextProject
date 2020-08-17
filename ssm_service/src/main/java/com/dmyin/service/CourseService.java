package com.dmyin.service;
import com.dmyin.entity.PageResult;
import com.dmyin.entity.QueryPageBean;
import com.dmyin.pojo.Course;

import java.io.IOException;
import java.util.List;

public interface CourseService {

    PageResult coursePage(QueryPageBean queryPageBean) throws IOException;

    void addCourse(Course course) throws IOException;

    void updateCourse(Course course) throws IOException;

    void deleteCourse(Integer id) throws IOException;

    List<Course> findAll(String status) throws IOException;
}
