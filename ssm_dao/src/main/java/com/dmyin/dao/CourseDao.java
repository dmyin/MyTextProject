package com.dmyin.dao;



import com.dmyin.entity.QueryPageBean;
import com.dmyin.pojo.Course;

import java.util.List;
import java.util.Map;

public interface CourseDao {
    Long countPage(Map queryParams);

    List<Course> listPage(QueryPageBean queryPageBean);

    void addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(Integer id);

    List<Course> findAll(String status);
}
